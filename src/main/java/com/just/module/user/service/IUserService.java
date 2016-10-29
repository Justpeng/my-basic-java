package com.just.module.user.service;

import com.just.module.user.pojo.SysUser;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/10/29.
 */

public interface IUserService {
    SysUser selectById(int id);
}
