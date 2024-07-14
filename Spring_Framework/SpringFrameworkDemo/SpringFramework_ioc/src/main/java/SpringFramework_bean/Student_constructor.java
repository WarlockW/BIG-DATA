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
