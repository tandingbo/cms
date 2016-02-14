package com.tanbobo.cms.base.controller;

import ch.qos.logback.classic.Logger;
import com.tanbobo.cms.base.common.constant.BaseConstant;
import com.tanbobo.cms.base.entity.BaseEntity;
import com.tanbobo.cms.core.entity.AuthenToken;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.Assert;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 公共控制器
 */
public class BaseController {
    protected Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    /**
     * modelAttribut作用说明:
     * 1.放置在方法的形参上表示引用Model中的数据
     * 2.放置在方法上表示请示该类的每个action前都会首先执行它，也可以将一些准备数据的操作放置在该方法里面
     * @param request
     * @param response
     */
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }

    //① 获取保存在Session中的用户对象
    protected AuthenToken getSessionUser() {
        return (AuthenToken) session.getAttribute(BaseConstant.AUTHEN_TOKEN_SESSION_NAME);
    }

    //②将用户对象保存到Session中
    protected void setSessionUser(AuthenToken token) {
        session.setAttribute(BaseConstant.AUTHEN_TOKEN_SESSION_NAME, token);
    }

    //③ 获取基于应用程序的url绝对路径
    public final String getAppbaseUrl(String url) {
        Assert.hasLength(url, "url不能为空");
        Assert.isTrue(url.startsWith("/"), "必须以/打头");
        return request.getContextPath() + url;
    }

    @ExceptionHandler
    public String exception(Exception e) {
        logger.error(this.getClass() + " is errory, errorType=" + e.getClass(), e);
        //如果是json格式的ajax请求
        if (request.getHeader("accept").indexOf("application/json") > -1
                || (request.getHeader("X-Requested-With") != null
                && request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1)) {
            response.setStatus(500);
            response.setContentType("application/json;charset=utf-8");
//            SpringMvcUtil.responseWriter(response, e.getMessage());
            return null;
        } else {//如果是普通请求
            request.setAttribute("exceptionMsg", e.getMessage());
            // 根据不同的异常类型可以返回不同界面
            if (e instanceof SQLException) {
                return "sqlerror";
            } else {
                return "error";
            }
        }
    }

    /**
     * 上下文
     * @return
     */
    public String getContextPath(){
        return request.getContextPath();
    }

    /**
     * 返回空数据
     */
    protected static final String EMPTY_ARRAY = "{\"status\": 1, \"data\": []}";
    protected static final String EMPTY_ENTITY = "{\"status\": 1, \"data\": {}}";
    protected static final String EMPTY_STRING = "{\"status\": 1, \"data\": \"\"}";

    /**
     * 往客户端写入数据
     * @param str
     * @throws IOException
     */
    protected void write(String str) throws IOException{
        response.setCharacterEncoding(request.getCharacterEncoding());
        response.setContentType("text/html");
        Writer writer = response.getWriter();
        try{
            if(StringUtils.isNoneBlank(str)){
                writer.write(str);
            }
        } finally {
            writer.flush();
            writer.close();
        }
    }

    /**
     * 错误信息
     * @param failed
     * @return
     */
    protected String getFailed(String... failed) {
        StringBuilder builder = new StringBuilder("{\"status\": 0, \"failed\": \"");
        for (String str : failed) {
            builder.append(str);
        }
        builder.append("\"}");
        return builder.toString();
    }
}
