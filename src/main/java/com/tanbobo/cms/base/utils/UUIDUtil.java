package com.tanbobo.cms.base.utils;

import java.util.UUID;

/**
 * GUID生成工具
 */
public final class UUIDUtil {

    public static final String newId() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(newId());
    }
}
