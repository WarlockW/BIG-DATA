package test;

import SpringFramework_propertiesImport.JDBC_Connector;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringFramework_propertiesImport_test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringFramework_propertiesImport.xml");
        JDBC_Connector jdbc_connector = (JDBC_Connector)ctx.getBean("jbdc_connector");
        System.out.println(jdbc_connector);
    }
}
