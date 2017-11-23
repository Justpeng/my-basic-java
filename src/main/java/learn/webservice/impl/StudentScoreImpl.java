package learn.webservice.impl;

import learn.webservice.StudentScore;

import javax.jws.WebService;

import static java.lang.System.out;

@WebService
public class StudentScoreImpl implements StudentScore {
    @Override
    public String getScoreById(String studentId) {
        out.println("get scoreById，studentId:"+ studentId);
        if("just".equalsIgnoreCase(studentId)){
            return "A";
        }else{
            return "B";
        }
    }
}
