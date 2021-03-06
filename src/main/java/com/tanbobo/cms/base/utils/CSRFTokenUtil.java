package com.tanbobo.cms.base.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * CSRF工具类
 */
public class CSRFTokenUtil {
    /**
     * The token parameter name
     */
    static final String CSRF_PARAM_NAME = "CSRFToken";

    /**
     * The location on the session which stores the token
     */
    public static final String CSRF_TOKEN_FOR_SESSION_ATTR_NAME = CSRFTokenUtil.class.getName() + ".tokenval";

    public static String getTokenForSession(HttpSession session) {
        String token = null;
        synchronized (session) {
//            token = (String) session.getAttribute(CSRF_TOKEN_FOR_SESSION_ATTR_NAME);
//            if (null == token) {
//                token = UUID.randomUUID().toString();
//                session.setAttribute(CSRF_TOKEN_FOR_SESSION_ATTR_NAME, token);
//            }
            token = UUID.randomUUID().toString();
            session.setAttribute(CSRF_TOKEN_FOR_SESSION_ATTR_NAME, token);
        }
        return token;
    }

    /**
     * Extracts the token value from the session
     *
     * @param request
     * @return
     */
    public static String getTokenFromRequest(HttpServletRequest request) {
        return request.getParameter(CSRF_PARAM_NAME);
    }
}
