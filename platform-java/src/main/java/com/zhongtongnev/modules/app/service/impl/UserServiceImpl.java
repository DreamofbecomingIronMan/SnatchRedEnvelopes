package com.zhongtongnev.modules.app.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhongtongnev.common.exception.NevException;
import com.zhongtongnev.common.validator.Assert;
import com.zhongtongnev.modules.app.dao.UserDao;
import com.zhongtongnev.modules.app.entity.UserEntity;
import com.zhongtongnev.modules.app.form.LoginForm;
import com.zhongtongnev.modules.app.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public UserEntity queryByMobile(String mobile) {
        return baseMapper.selectOne(new QueryWrapper<UserEntity>().eq("mobile", mobile));
    }

    @Override
    public long login(LoginForm form) {
        UserEntity user = queryByMobile(form.getMobile());
        Assert.isNull(user, "手机号或密码错误");

        //密码错误
        if (!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))) {
            throw new NevException("手机号或密码错误");
        }

        return user.getUserId();
    }
}
