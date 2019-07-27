package com.zhongtongnev.modules.test.service.impl;

import com.zhongtongnev.common.utils.PageUtils;
import com.zhongtongnev.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zhongtongnev.modules.test.dao.ZtCertificateDao;
import com.zhongtongnev.modules.test.entity.ZtCertificateEntity;
import com.zhongtongnev.modules.test.service.ZtCertificateService;


@Service("ztCertificateService")
public class ZtCertificateServiceImpl extends ServiceImpl<ZtCertificateDao, ZtCertificateEntity> implements ZtCertificateService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ZtCertificateEntity> page = this.page(
                new Query<ZtCertificateEntity>().getPage(params),
                new QueryWrapper<ZtCertificateEntity>()
        );

        return new PageUtils(page);
    }

}