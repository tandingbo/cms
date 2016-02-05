-- 创建库
CREATE DATABASE cms
  CHARACTER SET utf8;

-- 参数类型
DROP TABLE IF EXISTS sys_option_type;
CREATE TABLE sys_option_type (
  id      CHAR(32)    NOT NULL,
  name    VARCHAR(50) NOT NULL, -- 名称
  orderid INTEGER     NOT NULL, -- 排序号

  PRIMARY KEY (id)
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8;

-- 系统参数
DROP TABLE IF EXISTS sys_option;
CREATE TABLE sys_option (
  id          CHAR(32)     NOT NULL,
  iniid       VARCHAR(50)  NOT NULL, -- 编号
  name        VARCHAR(50)  NOT NULL, -- 名称
  dvalue      TEXT         NULL, -- 默认值
  nowvalue    TEXT         NULL, -- 当前值
  description VARCHAR(200) NULL, -- 说明
  viewable    INTEGER      NOT NULL, -- 范围
  orderid     INTEGER      NOT NULL, -- 排序号
  validatejs  VARCHAR(100) NULL, -- 验证规则
  type_id     CHAR(32)     NOT NULL, -- 类型id

  PRIMARY KEY (id)
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8;

-- 后台模块
DROP TABLE IF EXISTS sys_model;
CREATE TABLE sys_model (
  id          CHAR(32)    NOT NULL,
  parent_id   CHAR(32)    NOT NULL,
  name        VARCHAR(20) NOT NULL,
  img         VARCHAR(30) NULL,
  url         VARCHAR(50) NULL,
  is_use      CHAR(1)     NOT NULL,
  order_id    INTEGER     NOT NULL,
  create_time DATETIME    NOT NULL,

  PRIMARY KEY (id)
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8;

-- 后台角色
DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role (
  id            CHAR(32)     NOT NULL,
  name          VARCHAR(20)  NOT NULL, -- 角色名
  state         CHAR(1)      NOT NULL, -- 状态（0：删除，1：正常，2：停用）
  is_sys        CHAR(1)      NOT NULL, -- 是否系统内置（0：否，1：是）
  display_order INTEGER      NULL, -- 排序号
  create_time   DATETIME     NOT NULL, -- 创建时间
  index_url     VARCHAR(200) NULL,

  PRIMARY KEY (id)
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8;

-- 角色对应权限表
DROP TABLE IF EXISTS sys_role_model;
CREATE TABLE sys_role_model (
  id       CHAR(32) NOT NULL,
  role_id  CHAR(32) NOT NULL, -- 角色id
  model_id CHAR(32) NOT NULL, -- 用户id

  PRIMARY KEY (id)
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8;

-- 管理员对应角色表
DROP TABLE IF EXISTS admin_to_role;
CREATE TABLE admin_to_role (
  id          CHAR(32) NOT NULL,
  admin_id    CHAR(32) NOT NULL, -- 用户id
  role_id     CHAR(32) NOT NULL, -- 角色id
  create_time DATETIME NOT NULL, -- 创建时间

  PRIMARY KEY (id)
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8;