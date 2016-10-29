package com.just.module.user.service.impl;

import com.just.module.user.dao.IUserDao;
import com.just.module.user.pojo.SysUser;
import com.just.module.user.service.IUserService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户接口实现类
 *
 * @author:Just
 * @create:2016-10-29 20:20
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    IUserDao userDao;

    @Override
    public SysUser selectById(int id) {
       return  userDao.selectById(id);
    }
}
