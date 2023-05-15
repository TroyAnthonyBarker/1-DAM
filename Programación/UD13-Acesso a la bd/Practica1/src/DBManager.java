import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    private static Connection conn = null;

    // Configuración de la conexión a la base de datos
    private static final String DB_HOST = "DESKTOP-00LQ1SJ\\SQLEXPRESS";
    private static final String DB_PORT = "1433";
    private static final String DB_NAME = "CLINICA_BD";
    private static final String DB_URL = "jdbc:sqlserver://"+ DB_HOST + ":" + DB_PORT +";TrustServerCertificate=true";

    private static final String DB_USER = "sql";
    private static final String DB_PASS = "sql";
    private static final String DB_MSQ_CONN_OK = "CONEXIÓN CORRECTA";
    private static final String DB_MSQ_CONN_NO = "ERROR EN LA CONEXIÓN";

    // Configuración de la tabla Pacientes
    private static final String DB_PACIENTES = "pacientes";
    private static final String DB_PACIENTES_SELECT = "SELECT * FROM " + DB_PACIENTES;
    private static final String DB_PACIENTES_CODIGO = "CODIGO";
    private static final String DB_PACIENTES_NOM = "NOMBRE";

    public static void main(String[] args) {
        connect();
    }

    public static boolean connect() {
        try {
            System.out.print("Conectando a la base de datos...");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("OK!");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }



}
