package SpringFramework_IoC_DI;

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
