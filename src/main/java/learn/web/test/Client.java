package learn.web.test;


import webs.student.StudentScoreImplService;

public class Client {
    public static void main(String args[]){
        System.out.println("客户端查询学生成绩信息");
        //调用自动生成的执行服务类
        StudentScoreImplService service = new StudentScoreImplService();
        //获取接口实现类
        webs.student.StudentScoreImpl studentScore = service.getStudentScoreImplPort();
        String score = studentScore.getScoreById("just");
        System.out.println(score);
    }
}
