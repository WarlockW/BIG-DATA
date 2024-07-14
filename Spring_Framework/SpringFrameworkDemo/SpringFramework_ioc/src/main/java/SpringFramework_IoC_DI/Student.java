package SpringFramework_IoC_DI;

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
