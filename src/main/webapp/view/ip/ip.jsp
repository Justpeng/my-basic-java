<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.just.module.ip.common.PageParam" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ip信息</title>
    <link rel="stylesheet" href="/css/ipCss.css" type="text/css">
</head>
<body>
<table>
    <th>ip信息</th>
    <thread>
        <tr>
            <td>id</td>
            <td>ip</td>
            <td>port</td>
            <td>country</td>
            <td>province</td>
            <td>isp</td>
            <td>findTime</td>
        </tr>
        <c:forEach items="${pageParam.data}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.ip}</td>
                <td>${item.port}</td>
                <td>${item.country}</td>
                <td>${item.province}</td>
                <td>${item.isp}</td>
                <td>${item.findTime}</td>
            </tr>
        </c:forEach>
    </thread>
</table>

    <%
        PageParam pageParam = (PageParam) request.getAttribute("pageParam");
        int currPage = pageParam.getCurrPage();
        int totalPage = pageParam.getTotalPage();
        for(int i=1;i<=totalPage;i++){
            if (i == currPage) {
                %><span><%=currPage%></span><%
            }else{
                %><a href="/ip/getList?page=<%=i %>"><%=i %></a><%
            }
        }
    %>
    <span>页</span>









</body>
</html>
