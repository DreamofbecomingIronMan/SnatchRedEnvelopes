package com.zhongtongnev.modules.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhongtongnev.common.utils.PageUtils;
import com.zhongtongnev.modules.test.entity.ZtCertificateEntity;

import java.util.Map;

/**
 * 
 *
 * @author zzh
 * @email 
 * @date 2019-07-20 18:21:09
 */
public interface ZtCertificateService extends IService<ZtCertificateEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

