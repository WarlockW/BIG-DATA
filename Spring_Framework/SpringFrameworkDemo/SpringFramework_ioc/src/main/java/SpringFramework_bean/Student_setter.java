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
