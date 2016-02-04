package com.tanbobo.cms.core.dao.impl;

import com.tanbobo.cms.core.dao.ISysLogDao;
import com.tanbobo.cms.core.entity.SysLog;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/2/4.
 */
@Repository("sysLogDao")
public class SysLogDaoImpl implements ISysLogDao {
    @Override
    public void save(SysLog entity) {
        System.out.println(entity.getContent());
        System.out.println(entity.getAccessIp());
    }
}
