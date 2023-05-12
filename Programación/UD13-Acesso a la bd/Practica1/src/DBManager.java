import java.sql.Connection;

public class DBManager {

    private static Connection conn = null;

    // Configuración de la conexión a la base de datos
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "1433";
    private static final String DB_NAME = "tienda";
    private static final String DB_URL = "jdbc:sqlserver://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME + "?serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
    private static final String DB_MSQ_CONN_OK = "CONEXIÓN CORRECTA";
    private static final String DB_MSQ_CONN_NO = "ERROR EN LA CONEXIÓN";

    // Configuración de la tabla Pacientes
    private static final String DB_PACIENTES = "pacientes";
    private static final String DB_PACIENTES_SELECT = "SELECT * FROM " + DB_PACIENTES;
    private static final String DB_PACIENTES_CODIGO = "CODIGO";
    private static final String DB_PACIENTES_NOM = "NOMBRE";

}
