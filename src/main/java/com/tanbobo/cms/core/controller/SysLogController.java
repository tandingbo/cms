package com.tanbobo.cms.core.controller;

import ch.qos.logback.classic.Logger;
import com.tanbobo.cms.base.controller.BaseController;
import com.tanbobo.cms.core.service.ISysLogService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * 日志
 */
@Controller
public class SysLogController extends BaseController {
    @Resource
    private ISysLogService sysLogService;
    //定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger = (Logger) LoggerFactory.getLogger(SysLogController.class);

    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String logPage() {
        session.setAttribute("t", "tanbobo");
//        logger.info("logback 成功了");
        System.out.println("session value:"+session.getAttribute("t"));
        return "public/index";
    }
}
