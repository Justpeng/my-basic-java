package learn.web.impl;

import learn.web.StudentScore;

import javax.jws.WebService;

import static java.lang.System.out;

@WebService
public class StudentScoreImpl implements StudentScore {
    @Override
    public String getScoreById(String studentId) {
        out.print("获取学生成绩，学生id:"+ studentId);
        if("just".equalsIgnoreCase(studentId)){
            return "A";
        }else{
            return "B";
        }
    }
}
