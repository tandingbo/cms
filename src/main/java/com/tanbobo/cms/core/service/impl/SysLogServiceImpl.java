package com.tanbobo.cms.core.service.impl;

import com.tanbobo.cms.core.dao.ISysLogDao;
import com.tanbobo.cms.core.service.ISysLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/2/4.
 */
@Service("sysLogService")
public class SysLogServiceImpl implements ISysLogService {
    @Resource
    private ISysLogDao sysLogDao;
}
