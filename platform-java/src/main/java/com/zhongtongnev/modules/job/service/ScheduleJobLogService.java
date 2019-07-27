package com.zhongtongnev.modules.job.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhongtongnev.common.utils.PageUtils;
import com.zhongtongnev.modules.job.entity.ScheduleJobLogEntity;

import java.util.Map;

/**
 * 定时任务日志
 */
public interface ScheduleJobLogService extends IService<ScheduleJobLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
