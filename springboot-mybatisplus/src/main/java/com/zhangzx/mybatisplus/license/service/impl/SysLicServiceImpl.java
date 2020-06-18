package com.zhangzx.mybatisplus.license.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhangzx.mybatisplus.license.mapper.SysLicMapper;
import com.zhangzx.mybatisplus.license.model.SysLic;
import com.zhangzx.mybatisplus.license.service.SysLicService;
import org.springframework.stereotype.Service;

/**
 * @Description: 证书业务类
 * @Date: 2020/3/12
 * @Author: zhangzexin
 */
@Service
public class SysLicServiceImpl extends ServiceImpl<SysLicMapper, SysLic> implements SysLicService {
}
