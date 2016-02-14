package com.tanbobo.cms.core.controller;

import ch.qos.logback.classic.Logger;
import com.alibaba.fastjson.JSON;
import com.tanbobo.cms.base.controller.BaseController;
import com.tanbobo.cms.core.service.ISysLogService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 日志
 */
@Controller
public class SysLogController extends BaseController {
    @Resource
    private ISysLogService sysLogService;
    private final static Logger logger = (Logger) LoggerFactory.getLogger(SysLogController.class);

    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String logPage() {
        logger.info("logback 成功了");
        return "public/index";
    }

    @RequestMapping(value = "/logApi")
    public void apiTest() throws IOException {
        Map<String, String> result = new HashMap<>();
        result.put("id", "122134123sdfgasd");
        result.put("name", "tanbobo");
        result.put("title", "title1");
        result.put("content", "content1");
//        write(JSON.toJSONString(result));
//        write(EMPTY_ENTITY);
        write(getFailed("返回错误信息"));
    }
}
