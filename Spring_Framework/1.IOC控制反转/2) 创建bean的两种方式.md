<h1>新建两种类型的基础类</h1>

第一种为只有全参构造器的

```
package SpringFramework_bean;

import lombok.ToString;

@ToString
public class Student_constructor {
    private Integer id;
    private String name;
    private Integer age;

    public Student_constructor(Integer id,String name,Integer age){
        System.out.println("使用constuctor创建bean");
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
```

第二种为只有无参构造器和对应属性的Setter方法的

```
package SpringFramework_bean;

import lombok.ToString;
import org.springframework.asm.SpringAsmInfo;

//@Data
@ToString
public class Student_setter {
    private Integer id;
    private String name;
    private Integer age;

    public Student_setter(){System.out.println("使用setter创建bean");}

    // Get方法
    public Integer getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Integer getAge(){
        return age;
    }

    // Set方法
    public void setId(Integer id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(Integer age){
        this.age = age;
    }
}
```

<h1>通过XML在IOC容器中确定构建bean的属性</h1>

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--setter创建-->
    <bean id="student_setter" class="SpringFramework_bean.Student_setter">
        <property name="age" value="18"></property>
        <property name="name" value="张三"></property>
        <property name="id" value="001"></property>
    </bean>

    <!--constructor创建-->
    <bean id="student_constructor" class="SpringFramework_bean.Student_constructor">
        <constructor-arg name="age" value="19"></constructor-arg>
        <constructor-arg name="name" value="李四"></constructor-arg>
        <constructor-arg name="id" value="002"></constructor-arg>
    </bean>

</beans>
```

<h1>从IOC容器中获取之前XML中构建好的bean对象</h1>

```
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

```

执行结果为

```
使用setter创建bean
使用constuctor创建bean
Student_setter(id=1, name=张三, age=18)
Student_constructor(id=2, name=李四, age=19)

Process finished with exit code 0
```
