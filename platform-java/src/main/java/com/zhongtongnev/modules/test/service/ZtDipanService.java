package com.zhongtongnev.modules.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhongtongnev.common.utils.PageUtils;
import com.zhongtongnev.modules.test.entity.ZtDipanEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface ZtDipanService extends IService<ZtDipanEntity> {

    PageUtils queryPage(Map<String, Object> params);

    public List<ZtDipanEntity> select(@Param(value = "key") String params);

    public  ZtDipanEntity getInfoById(@Param(value = "chassisId")String chassisId);
}

