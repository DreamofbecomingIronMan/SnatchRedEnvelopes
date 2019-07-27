package com.zhongtongnev.modules.test.controller;

import java.util.Arrays;
import java.util.Map;

import com.zhongtongnev.common.utils.PageUtils;
import com.zhongtongnev.common.utils.Result;
import com.zhongtongnev.modules.app.annotation.Login;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhongtongnev.modules.test.entity.ZtCertificateEntity;
import com.zhongtongnev.modules.test.service.ZtCertificateService;



/**
 * 
 *
 * @author zzh
 * @email 
 * @date 2019-07-20 18:21:09
 */
@RestController
@RequestMapping("/test/ztcertificate")
public class ZtCertificateController {
    @Autowired
    private ZtCertificateService ztCertificateService;

    /**
     * 列表
     */
    //@Login
    @RequestMapping("/list")
//    @RequiresPermissions("test:ztcertificate:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = ztCertificateService.queryPage(params);

        return Result.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("test:ztcertificate:info")
    public Result info(@PathVariable("id") Integer id){
		ZtCertificateEntity ztCertificate = ztCertificateService.getById(id);

        return Result.ok().put("ztCertificate", ztCertificate);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("test:ztcertificate:save")
    public Result save(@RequestBody ZtCertificateEntity ztCertificate){
		ztCertificateService.save(ztCertificate);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("test:ztcertificate:update")
    public Result update(@RequestBody ZtCertificateEntity ztCertificate){
		ztCertificateService.updateById(ztCertificate);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("test:ztcertificate:delete")
    public Result delete(@RequestBody Integer[] ids){
		ztCertificateService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
