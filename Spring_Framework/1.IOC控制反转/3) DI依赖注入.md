<h1>如何理解DI依赖注入</h1>

在Spring框架中，依赖注入（Dependency Injection，简称DI）是一种重要的控制反转（IoC，Inversion of Control）技术。依赖注入的核心思想是：对象的依赖关系（即它们所使用的其他对象）不是由对象本身负责创建和查找，而是由外部容器（在Spring中通常指的是Spring容器）在运行时动态地注入到对象中去。这样做的好处包括降低组件间的耦合度，提高代码的重用性和可测试性。

<h1>构建基础类</h1>

student类，其中一个属性

```
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private Classes classes;

    public Student(){}

    public Student(Integer id,String name,Integer age,Classes classes) {
        System.out.println("通过有参构造创建对象");
        this.id = id;
        this.name = name;
        this.age = age;
        this.classes = classes;
    }
}

```

student类，用于后续注入classes类

```
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
public class Classes {
    private Integer id;
    private String name;

    public Classes(Integer id,String name){
        this.id = id;
        this.name = name;
    }
}
```

<h1>通过XML对bean进行配置</h1>

Spring通过XML默认从上到下对bean对象进行构建，因此在构建Student的时候应该先完成对Classes的构建，因此在bean中使用depends-on参数。 <br>
在配置Student的Classes属性时，由于引入的不是常规类型的变量，而是一个对象类型（也就是DI，将一种bean注入进另一个bean），所以不能用 value 而是要用 ref <br>

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--创建班级bean-->
    <bean id="classes" class="SpringFramework_IoC_DI.Classes">
        <constructor-arg name="id" value="01"></constructor-arg>
        <constructor-arg name="name" value="一班"></constructor-arg>
    </bean>

    <!--使用setter创建student1-->
    <bean id="student1" class="SpringFramework_IoC_DI.Student" depends-on="classes">
        <property name="age" value="19"></property>
        <property name="name" value="张三"></property>
        <property name="id" value="001"></property>
        <property name="classes" ref="classes"></property>
    </bean>

    <!--使用constructor创建student2-->
    <bean id="student2" class="SpringFramework_IoC_DI.Student" depends-on="classes">
        <constructor-arg name="age" value="18"></constructor-arg>
        <constructor-arg name="name" value="李四"></constructor-arg>
        <constructor-arg name="id" value="002"></constructor-arg>
        <constructor-arg name="classes" ref="classes"></constructor-arg>
    </bean>
</beans>
```
