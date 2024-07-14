package test;

import SpringFramework_parent.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringFramework_parent_test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringFramework_parent.xml");
        Person father = (Person) ctx.getBean("father");
        Person child = (Person) ctx.getBean("child");
        System.out.println(father);
        System.out.println(child);
    }
}
