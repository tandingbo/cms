package com.tanbobo.cms.core.controller;

import ch.qos.logback.classic.Logger;
import com.alibaba.fastjson.JSON;
import com.tanbobo.cms.base.controller.BaseController;
import com.tanbobo.cms.base.utils.DateUtil;
import com.tanbobo.cms.core.service.ISysLogService;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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
        Map<String, Object> result = new HashMap<>();
        result.put("id", "122134123sdfgasd");
        result.put("name", "tanbobo");
        result.put("title", "title1");
        result.put("content", "content1");
        result.put("date", DateUtil.dateFormat(new Date()));
        List<Map<String, Object>> listResult = new ArrayList<>();
        listResult.add(result);
        write(JSON.toJSONString(listResult));
//        write(EMPTY_ENTITY);
//        write(getFailed("返回错误信息"));
    }
}
