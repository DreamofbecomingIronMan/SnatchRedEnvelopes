package com.zhongtongnev.modules.test.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhongtongnev.common.utils.PageUtils;
import com.zhongtongnev.common.utils.Query;

import com.zhongtongnev.modules.test.dao.ZtDipanDao;
import com.zhongtongnev.modules.test.entity.ZtDipanEntity;
import com.zhongtongnev.modules.test.service.ZtDipanService;


@Service("ztDipanService")
public class ZtDipanServiceImpl extends ServiceImpl<ZtDipanDao, ZtDipanEntity> implements ZtDipanService {

    @Autowired
    private ZtDipanDao ztDipanDao=null;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ZtDipanEntity> page = this.page(
                new Query<ZtDipanEntity>().getPage(params),
                new QueryWrapper<ZtDipanEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<ZtDipanEntity> select(@Param(value = "key") String params) {
        return ztDipanDao.select(params);
    }

    @Override
    public ZtDipanEntity getInfoById(@Param(value = "chassisId") String chassisId) {
        return ztDipanDao.getInfoById(chassisId);
    }

}