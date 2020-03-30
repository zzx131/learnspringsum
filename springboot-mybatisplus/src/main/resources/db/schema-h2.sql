DROP TABLE IF EXISTS user;

CREATE TABLE user
(
	id BIGINT(20) NOT NULL COMMENT '主键ID',
	name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
	age INT(11) NULL DEFAULT NULL COMMENT '年龄',
	email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS p_sys_lic;

create table p_sys_lic
(
   id                   int not null auto_increment comment '主键',
   primary key (id),
   public_store_pwd       varchar(40) comment '公钥密码',
   private_store_Pwd      varchar(40) comment '私钥密码',
   issued_time           timestamp comment '证书生效时间',
   expiry_time           timestamp comment '证书失效时间',
   consumer_type         varchar(40) comment '授权用户类型',
   product_code          varchar(40) comment '产品编码',
   model_code            varchar(40) comment '产品模块编码',
   authorizer           varchar(40) comment '授权人',
   auth_number           int comment '授权数量',
   userd_company         varchar(40) comment '产品使用厂家',
   userd_hardware        varchar(40) comment '产品使用硬件设备',
   create_time          datetime not null comment '创建时间',
   modified_time        datetime not null comment '修改时间',
   is_deleted   tinyint default 0 comment '1 表示删除，0 表示未删除',
   remarks               varchar(20)  comment '备注'
);

