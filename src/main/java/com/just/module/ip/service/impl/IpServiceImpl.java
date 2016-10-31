package com.just.module.ip.service.impl;

import com.just.module.ip.common.PageParam;
import com.just.module.ip.dao.IpDao;
import com.just.module.ip.pojo.Ip;
import com.just.module.ip.service.IIPService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:Just
 * @create:2016-10-31 22:06
 */
@Service
public class IpServiceImpl implements IIPService{

    @Resource
    IpDao ipDao;

    @Override
    public PageParam selectIpList(PageParam pageParam) {
        int currPage = pageParam.getCurrPage();
        // limit offset, size
        int offset = (currPage - 1) * PageParam.pageSize ;
        int size = PageParam.pageSize;
        Map<String, Object> params = new HashMap<>();
        params.put("offset", offset);
        params.put("size", size);

        List<Ip> ipList = ipDao.selectIpList(params);
        pageParam.setData(ipList);
        return pageParam;
    }

    @Override
    public int getRowCount() {
        return ipDao.getRowCount();
    }
}
