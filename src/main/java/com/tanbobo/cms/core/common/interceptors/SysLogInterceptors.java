package com.tanbobo.cms.core.common.interceptors;

import com.tanbobo.cms.base.common.constant.BaseConstant;
import com.tanbobo.cms.base.common.interceptors.CommonInterceptor;
import com.tanbobo.cms.base.utils.IpUtil;
import com.tanbobo.cms.base.utils.UUIDUtil;
import com.tanbobo.cms.core.dao.ISysLogDao;
import com.tanbobo.cms.core.entity.SysLog;
import com.tanbobo.cms.core.service.ISysLogService;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 日志拦截器
 */
public class SysLogInterceptors extends CommonInterceptor {
    @Resource
    private ISysLogService sysLogService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //记录用户访问系统信息
        SysLog log = new SysLog();
        log.setUuid(UUIDUtil.newId());
        log.setContent("记录用户访问系统地址信息：" + String.valueOf(request.getRequestURI()));
        log.setType(BaseConstant.LOG_ACCESS_SYSTEM_TYPE);
        log.setAccessIp(IpUtil.getClientIp(request));
        log.setAccessUrl(String.valueOf(request.getRequestURL()));
        log.setAccessTime(new Date());
        sysLogService.save(log);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
