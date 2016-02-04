package com.tanbobo.cms.core.controller;

import com.tanbobo.cms.base.controller.BaseController;
import com.tanbobo.cms.core.service.ISysAccountService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 *
 */
@Controller
public class SysAccountController extends BaseController {

    @Resource
    private ISysAccountService sysAccountService;

}
