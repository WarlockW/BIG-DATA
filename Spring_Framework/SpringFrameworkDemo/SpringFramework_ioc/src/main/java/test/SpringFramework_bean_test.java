package test;

import SpringFramework_bean.Student_constructor;
import SpringFramework_bean.Student_setter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringFramework_bean_test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringFramework_bean.xml");
        // 获取setter方法创建的bean(张三)
        Student_setter student_setter = (Student_setter)ctx.getBean("student_setter");
        System.out.println(student_setter);

        // 获取constructor方法创建的bean（李四）
        Student_constructor student_constructor = (Student_constructor) ctx.getBean("student_constructor");
        System.out.println(student_constructor);
    }
}
