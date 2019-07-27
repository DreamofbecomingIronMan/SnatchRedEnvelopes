package com.zhongtongnev.modules.test.dao;

import com.zhongtongnev.modules.test.entity.ZtDipanEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface ZtDipanDao extends BaseMapper<ZtDipanEntity> {
	public List<ZtDipanEntity> select(@Param(value = "key") String params);

	public ZtDipanEntity getInfoById(@Param(value = "chassisId")String chassisId);
}
