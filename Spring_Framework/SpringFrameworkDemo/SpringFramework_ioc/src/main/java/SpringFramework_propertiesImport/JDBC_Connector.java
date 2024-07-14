package SpringFramework_propertiesImport;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class JDBC_Connector {
    private String user;
    private String password;
    private String url;
    private String drivername;
}
