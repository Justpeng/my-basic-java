package learn.webservice.test;


import webservice.student.wsdl.StudentScoreImplService;

public class Client {
    public static void main(String args[]){
        System.out.println("get student score:");
        //调用自动生成的执行服务类
        StudentScoreImplService service = new StudentScoreImplService();
        //获取接口实现类
        webservice.student.wsdl.StudentScoreImpl studentScore = service.getStudentScoreImplPort();
        String score = studentScore.getScoreById("just");
        System.out.println(score);
    }
}
