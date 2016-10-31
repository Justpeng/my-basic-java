package com.just.module.ip.dao;

import com.just.module.ip.common.PageParam;
import com.just.module.ip.pojo.Ip;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/31.
 */
@Repository
public interface IpDao {
    List<Ip> selectIpList(Map<String, Object> params);

    int getRowCount();
}
