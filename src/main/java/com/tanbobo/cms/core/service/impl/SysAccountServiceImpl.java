package com.tanbobo.cms.core.service.impl;

import com.tanbobo.cms.core.dao.ISysAccountDao;
import com.tanbobo.cms.core.service.ISysAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service("sysAccountService")
public class SysAccountServiceImpl implements ISysAccountService {
    @Resource
    private ISysAccountDao sysAccountDao;
}
