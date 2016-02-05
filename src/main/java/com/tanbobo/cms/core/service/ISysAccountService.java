package com.tanbobo.cms.core.service;

import com.tanbobo.cms.core.entity.SysAccount;

/**
 *
 */
public interface ISysAccountService {
    SysAccount findById(String userId);
}
