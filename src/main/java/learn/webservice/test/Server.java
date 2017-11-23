package learn.webservice.test;


import learn.webservice.impl.StudentScoreImpl;

import javax.xml.ws.Endpoint;

/**
 * @author:lip
 */
public class Server {

    /**
     * 开启，并发布webService服务
     * @param args
     */
    public static void main(String[] args){
        //定义webService地址: ip+port
        String addr = "http://127.0.0.1:3306/student";
        StudentScoreImpl studentScore = new StudentScoreImpl();
        //发布服务 地址+服务实现类
        Endpoint.publish(addr, studentScore);
    }
}
