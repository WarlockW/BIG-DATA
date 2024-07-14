package test;

import SpringFramework_IoC_DI.Classes;
import SpringFramework_IoC_DI.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;

public class SpringFramework_IoC_DI_test {
    public static void main(String[] args) {
        ApplicationContext cxt = new ClassPathXmlApplicationContext("SpringFramework_IoC_DI.xml");
        // 获取班级
        Classes classes = (Classes) cxt.getBean("classes");
        System.out.println(classes);

        //获取setter创建的学生1
        Student student1 = (Student) cxt.getBean("student1");
        System.out.println(student1);
        //获取constructor创建的学生2
        Student student2 = (Student) cxt.getBean("student2");
        System.out.println(student2);
    }
}
