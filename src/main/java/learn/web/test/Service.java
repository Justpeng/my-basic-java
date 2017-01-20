package learn.web.test;


import learn.web.impl.StudentScoreImpl;

import javax.xml.ws.Endpoint;

public class Service {

    /**
     * 开启，并发布webService服务
     * @param args
     */
    public static void main(String args[]){
        //定义webService地址: ip+port
        String addr = "http://127.0.0.1:3306/student";
        StudentScoreImpl studentScore = new StudentScoreImpl();
        //发布服务 地址+服务实现类
        Endpoint.publish(addr, studentScore);
    }
}
