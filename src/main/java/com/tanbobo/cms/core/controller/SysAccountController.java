package com.tanbobo.cms.core.controller;

import com.tanbobo.cms.base.controller.BaseController;
import com.tanbobo.cms.core.service.ISysAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 *
 */
@Controller
public class SysAccountController extends BaseController {

    @Resource
    private ISysAccountService sysAccountService;

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String accountPage() {

        return "";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "/login";
    }

}
