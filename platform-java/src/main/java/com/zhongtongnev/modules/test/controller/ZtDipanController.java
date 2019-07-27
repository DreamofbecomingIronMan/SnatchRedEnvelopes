package com.zhongtongnev.modules.test.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhongtongnev.modules.test.entity.ZtDipanEntity;
import com.zhongtongnev.modules.test.service.ZtDipanService;
import com.zhongtongnev.common.utils.PageUtils;
import com.zhongtongnev.common.utils.Result;


@RestController
@RequestMapping("test/ztdipan")
public class ZtDipanController {
    @Autowired
    private ZtDipanService ztDipanService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("test:ztdipan:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = ztDipanService.queryPage(params);

        return Result.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{chassisId}")
    //@RequiresPermissions("test:ztdipan:info")
    public Result info(@PathVariable("chassisId") String chassisId){
		ZtDipanEntity ztDipan = ztDipanService.getById(chassisId);

        return Result.ok().put("ztDipan", ztDipan);
    }

    /**
     * 模糊查询
     */
    @RequestMapping("/select")
    public  Result select(@RequestParam(value = "key") String params){
        List<ZtDipanEntity> ztDipan = ztDipanService.select(params);
        System.err.println(params);
        return  Result.ok().put("ztDipan",ztDipan);
    }
    @RequestMapping("/getInfoById")
    public Result getInfoById(@RequestParam(value = "key",required = false) String chassisId){
        System.err.println(chassisId);
        ZtDipanEntity ztDipan=ztDipanService.getInfoById(chassisId);
        System.err.println(ztDipan.getChassisId()+ztDipan.getFuel());
        return Result.ok().put("ztDipan", ztDipan);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("test:ztdipan:save")
    public Result save(@RequestBody ZtDipanEntity ztDipan){
		ztDipanService.save(ztDipan);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("test:ztdipan:update")
    public Result update(@RequestBody ZtDipanEntity ztDipan){
		ztDipanService.updateById(ztDipan);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("test:ztdipan:delete")
    public Result delete(@RequestBody String[] chassisIds){
		ztDipanService.removeByIds(Arrays.asList(chassisIds));

        return Result.ok();
    }

}
