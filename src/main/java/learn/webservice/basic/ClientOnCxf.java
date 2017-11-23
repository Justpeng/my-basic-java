package learn.webservice.basic;

import learn.webservice.StudentScore;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * Description: BASIC
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 10/16/2017-14:19
 */
public class ClientOnCxf {
    public static void main(String[] args) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(StudentScore.class);
        factory.setAddress("http://localhost:9000/ws/HelloWorld");
        StudentScore studentScore = (StudentScore) factory.create();
        System.out.println(studentScore.getScoreById("aa"));
    }
}
