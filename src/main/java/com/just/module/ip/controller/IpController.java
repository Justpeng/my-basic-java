package com.just.module.ip.controller;

import com.just.module.ip.common.PageParam;
import com.just.module.ip.service.IIPService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author:Just
 * @create:2016-10-31 22:05
 */
@Controller
@RequestMapping("/ip")
public class IpController {

    @Resource
    IIPService ipService;

    @RequestMapping("/getList")
    public ModelAndView getIps(HttpServletRequest request) {
        String currPageStr = request.getParameter("page");

        int currPage = 1;
        try {
            currPage = Integer.parseInt(currPageStr);
        } catch (Exception e) {
        }

        // 获取总记录数
        int rowCount = ipService.getRowCount();
        PageParam pageParam = new PageParam();
        pageParam.setRowCount(rowCount);
        if (pageParam.getTotalPage() < currPage) {
            currPage = pageParam.getTotalPage();
        }
        pageParam.setCurrPage(currPage);
        pageParam = ipService.selectIpList(pageParam);

        request.setAttribute("pageParam", pageParam);


        return new ModelAndView("/ip/ip");
    }

}
