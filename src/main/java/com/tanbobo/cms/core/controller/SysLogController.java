package com.tanbobo.cms.core.controller;

import com.tanbobo.cms.base.controller.BaseController;
import com.tanbobo.cms.core.service.ISysLogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 日志
 */
@Controller
@RequestMapping("/log")
public class SysLogController extends BaseController {
    @Resource
    private ISysLogService sysLogService;

}
