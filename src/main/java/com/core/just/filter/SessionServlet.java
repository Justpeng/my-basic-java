package com.core.just.filter;

import com.core.just.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author:Just
 * @create:2016-12-11 10:12
 */
public class SessionServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        HttpSession httpSession = req.getSession();
        String type =  req.getParameter("type");
        if("logout".equalsIgnoreCase(type)){
            //模拟退出登录删除session
            if(httpSession!=null) {
                httpSession.invalidate();
            }
            out.println("已退出登录！");
            out.println("sessionId:！");
            out.println("<br/>");
            out.close();
        }else{//模拟访问
            Integer count = (Integer) httpSession.getAttribute("count");
            if (count == null) {
                count=1;
            }else{
                count++;
            }
            httpSession.setAttribute("count",count);
            out.println("第"+count+"次访问！");
            out.println("<br/>");
            out.println("SessionId:"+httpSession.getId());
            out.close();
        }

    }
}