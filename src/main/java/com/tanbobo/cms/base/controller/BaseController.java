package com.tanbobo.cms.base.controller;

import ch.qos.logback.classic.Logger;
import com.tanbobo.cms.base.common.constant.BaseConstant;
import com.tanbobo.cms.base.entity.BaseEntity;
import com.tanbobo.cms.core.entity.AuthenToken;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.Assert;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @ExceptionHandler
    public String exception(HttpServletRequest request, HttpServletResponse response, Exception e) {
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

    //① 获取保存在Session中的用户对象
    protected AuthenToken getSessionUser(HttpServletRequest request) {
        return (AuthenToken) request.getSession().getAttribute(BaseConstant.AUTHEN_TOKEN_SESSION_NAME);
    }

    //②将用户对象保存到Session中
    protected void setSessionUser(HttpServletRequest request, AuthenToken token) {
        request.getSession().setAttribute(BaseConstant.AUTHEN_TOKEN_SESSION_NAME, token);
    }

    //③ 获取基于应用程序的url绝对路径
    public final String getAppbaseUrl(HttpServletRequest request, String url) {
        Assert.hasLength(url, "url不能为空");
        Assert.isTrue(url.startsWith("/"), "必须以/打头");
        return request.getContextPath() + url;
    }
}
