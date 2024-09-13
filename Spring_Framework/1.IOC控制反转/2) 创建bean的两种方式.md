<h1>新建两种类型的基础类</h1>

第一种为只有全参构造器

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
