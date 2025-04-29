import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLconexion {
    public static Connection connect() throws SQLException{
        String url = "jdbc:postgresql://localhost:5433/postgres";
        String user = "postgres";
        String password = "NRPV2006";
        
        Connection connection= DriverManager.getConnection(url, user, password);
        System.out.println("Conexion Exitosa");
        return connection;
    }
}
