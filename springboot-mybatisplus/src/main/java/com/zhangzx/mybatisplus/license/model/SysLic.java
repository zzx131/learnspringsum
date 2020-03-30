package com.zhangzx.mybatisplus.license.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @Description: 证书实体类
 * @Date: 2020/3/12
 * @Author: zhangzexin
 */
@Data
@TableName("p_sys_lic")
public class SysLic extends Model<SysLic> {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 公钥密码
     */
    private String publicStorePwd;

    /**
     * 私钥密码
     */
    private String privateStorePwd;

    /**
     * 证书生效时间
     */
    private Timestamp issuedTime;

    /**
     * 证书失效时间
     */
    private Timestamp expiryTime;

    /**
     * 授权用户类型
     */
    private String consumerType;

    /**
     * 产品编码
     */
    private String productCode;

    /**
     * 产品模块编码
     */
    private String modelCode;

    /**
     * 授权人
     */
    private String authorizer;

    /**
     * 授权数量
     */
    private Integer authNumber;

    /**
     * 产品使用厂家
     */
    private String userdCompany;

    /**
     * 产品使用硬件设备
     */
    private String userdHardware;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime modifiedTime;

    /**
     * 1 表示删除，0 表示未删除
     */
    private Boolean isDeleted;

    /**
     * 备注
     */
    private String remarks;


}
