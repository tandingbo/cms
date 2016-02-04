package com.tanbobo.cms.core.controller;

import com.tanbobo.cms.base.controller.BaseController;
import com.tanbobo.cms.core.service.ISysLogService;
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

    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String logPage() {
        return "index";
    }
}
