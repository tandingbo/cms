package com.tanbobo.cms.main.controller;

import ch.qos.logback.classic.Logger;
import com.tanbobo.cms.base.controller.BaseController;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping("/book")
public class BookController extends BaseController {
    //定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger = (Logger) LoggerFactory.getLogger(BookController.class);

    @RequestMapping(value = "/search")
    @ResponseBody
    public Map<String, Object> search(){
        logger.info("app访问成功了");
        Map<String, Object> result = new HashMap<>();
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("title", "tanbobo");
        list.add(map);

        result.put("books", list);
        return result;
    }
}
