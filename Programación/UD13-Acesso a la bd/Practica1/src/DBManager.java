import java.sql.*;

public class DBManager {

    private static Connection conn = null;

    // Configuración de la conexión a la base de datos
    private static final String DB_HOST = "DESKTOP-00LQ1SJ\\SQLEXPRESS";
    private static final String DB_PORT = "1433";
    private static final String DB_TRUST_SERVER = "TrustServerCertificate=true";
    private static final String DB_URL = "jdbc:sqlserver://"+ DB_HOST + ":" + DB_PORT +";" + DB_TRUST_SERVER;

    private static final String DB_USER = "sql";
    private static final String DB_PASS = "sql";
    private static final String DB_MSQ_CONN_OK = "CONEXIÓN CORRECTA";
    private static final String DB_MSQ_CONN_NO = "ERROR EN LA CONEXIÓN";

    // Configuración de la tabla Pacientes
    private static final String DB_PACIENTES = "dbo.pacientes";
    private static final String DB_PACIENTES_SELECT = "SELECT * FROM " + DB_PACIENTES;

    // Configuración de la tabla Visitas
    private static final String DB_VISITAS = "visitas";
    private static final String DB_VISITAS_SELECT = "SELECT * FROM " + DB_VISITAS;

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

    public static ResultSet selectAllPacientes(){
        try {
            Statement st = conn.createStatement();
            st.execute(DB_PACIENTES_SELECT);
            return st.getResultSet();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet selectPacientesWhere(String where){
        try {
            Statement st = conn.createStatement();
            st.execute(DB_PACIENTES_SELECT + where);
            return st.getResultSet();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet selectVisitas(int idPaciente){
        try {
            Statement st = conn.createStatement();
            st.execute("SELECT codigo, fechaVisita, enfermedad, importe, porcentajePago, proximaVisita FROM dbo.visitas WHERE idPaciente = " + idPaciente);
            return st.getResultSet();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void editPaciente(int codigo, String nombre, String direccion, String ciudad, int telefono, boolean diabetico, Date fechaNac, int turno, String gentilicio){
        try{
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(DB_PACIENTES_SELECT + " WHERE CODIGO = " + codigo);

            rs.last();
            rs.updateString("NOMBRE", nombre);
            rs.updateString("DIRECCION", direccion);
            rs.updateString("CIUDAD", ciudad);
            rs.updateInt("TELEFONO", telefono);
            rs.updateBoolean("DIABETICO", diabetico);
            rs.updateDate("FECHANAC", fechaNac);
            rs.updateInt("TURNO", turno);
            rs.updateString("GENTILICIO", gentilicio);

            rs.updateRow();
            rs.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void deletePaciente(int codigo){
        try{
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(DB_PACIENTES_SELECT + " WHERE CODIGO = " + codigo);

            rs.last();
            rs.deleteRow();
            rs.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }



}
