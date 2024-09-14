<h1>如何理解DI依赖注入</h1>

在Spring框架中，依赖注入（Dependency Injection，简称DI）是一种重要的控制反转（IoC，Inversion of Control）技术。依赖注入的核心思想是：对象的依赖关系（即它们所使用的其他对象）不是由对象本身负责创建和查找，而是由外部容器（在Spring中通常指的是Spring容器）在运行时动态地注入到对象中去。这样做的好处包括降低组件间的耦合度，提高代码的重用性和可测试性。

<h1>构建基础类</h1>

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
