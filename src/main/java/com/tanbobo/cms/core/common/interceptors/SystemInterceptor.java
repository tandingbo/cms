package com.tanbobo.cms.core.common.interceptors;

import com.tanbobo.cms.base.common.constant.BaseConstant;
import com.tanbobo.cms.base.common.interceptors.CommonInterceptor;
import com.tanbobo.cms.base.utils.IpUtil;
import com.tanbobo.cms.base.utils.UUIDUtil;
import com.tanbobo.cms.core.entity.AuthenToken;
import com.tanbobo.cms.core.entity.SysAccount;
import com.tanbobo.cms.core.entity.SysLog;
import com.tanbobo.cms.core.service.ISysAccountService;
import com.tanbobo.cms.core.service.ISysLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 系统拦截器
 */
public class SystemInterceptor extends CommonInterceptor {
    @Resource
    private ISysLogService sysLogService;
    @Resource
    private ISysAccountService accountService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        // 记录访问日志
        String uri = request.getRequestURI();
        if (!uri.matches("(.*)resources(.*)")) {
            //记录用户访问系统信息
            SysLog log = new SysLog();
            log.setUuid(UUIDUtil.newId());
            log.setContent("记录用户访问系统地址信息：" + String.valueOf(uri));
            log.setType(BaseConstant.LOG_ACCESS_SYSTEM_TYPE);
            log.setAccessIp(IpUtil.getClientIp(request));
            log.setAccessUrl(String.valueOf(request.getRequestURL()));
            log.setAccessTime(new Date());
            sysLogService.save(log);
        }

        /**
         * 自动登录拦截实现
         *    1),获取用户的session中的AuthenToken
         *        存在：不做任何操作
         *   不存在：
         *    2),获取Cookie中的用户ID，存在，获取该用户的详细信息，保存到session
         *   Cookie不存在
         *    3),获取当前访问url
         *    4),获取web.xml中放行的地址
         *    5),如果访问的url不是放行的地址，跳转到登录页面
         */
        String parentPath = request.getContextPath();
        // 从session 里面获取用户名的信息
        HttpSession session = request.getSession(true);
        AuthenToken authenToken = (AuthenToken) session.getAttribute(BaseConstant.AUTHEN_TOKEN_SESSION_NAME);
        if (null == authenToken) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null && cookies.length > 0) {
                for (Cookie cookie : cookies) {
                    if ("userId".equals(cookie.getName())) {
                        String userId = cookie.getValue();
                        SysAccount account = accountService.findById(userId);
                        if (account != null) {
                            authenToken = new AuthenToken();
                            authenToken.setNickName(account.getNickName());
                            authenToken.setGender("女");
                            if ("1".equals(account.getSex())) {
                                authenToken.setGender("男");
                            }
                            authenToken.setLoginTime(new Date());
                            authenToken.setLoginName(account.getUserName());
                            authenToken.setUserId(userId);
                            session.setAttribute(BaseConstant.AUTHEN_TOKEN_SESSION_NAME, authenToken);
                            //获取资源
//                            BaseResource resc = new BaseResource();
//                            List<BaseResource> listResc = resourceService.findListTree(resc);
//                            session.setAttribute("listResc", listResc);
                            return true;
                        }
                    }
                }
                /**
                 * 如果以前登录没有选择记住密码
                 * 如果要访问的地址不是要放行的方法，那么拦截跳转到登录页面是要放行的方法，放行
                 */
                String path = request.getRequestURI();
                path = path.substring(path.lastIndexOf("/"));
                String noLoginUrl = request.getSession().getServletContext().getInitParameter("noLoginUrl");
                if (StringUtils.isNotEmpty(noLoginUrl)) {
                    String[] noLoginUrlArr = noLoginUrl.split(",");
                    List<String> list = Arrays.asList(noLoginUrlArr);
                    if (list != null && list.contains(path)) {
                        return true;
                    }
                }
            }
            response.sendRedirect(parentPath + "/login");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
