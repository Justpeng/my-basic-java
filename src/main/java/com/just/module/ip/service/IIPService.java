package com.just.module.ip.service;

import com.just.module.ip.common.PageParam;
import com.just.module.ip.pojo.Ip;

import java.util.List;

/**
 * Created by Administrator on 2016/10/31.
 */
public interface IIPService {
    PageParam selectIpList(PageParam pageParam);

    int getRowCount();
}
