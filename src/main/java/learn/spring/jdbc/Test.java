package main.java.learn.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author:Just
 * @create:2016-10-29 16:48
 */
public class Test {
    public static void main(String args[]){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("main/resources/spring/applicationContext-dataSource.xml");
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.queryForObject("select * from dual",Object.class);
    }

}
