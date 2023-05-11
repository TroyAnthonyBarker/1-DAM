import java.sql.*;
import java.time.LocalDate;
import java.util.Arrays;

public class ImcDTO {

    private final Connection CONNECTION;
    private Statement statement;
    private final String TABLA_IMC = "imcdata";


    public ImcDTO() throws SQLException {
        String PASSWD_DB = "";
        String USER_DB = "root";
        String connexionString = "jdbc:mysql://localhost/imcdto";
        CONNECTION = DriverManager.getConnection(connexionString, USER_DB, PASSWD_DB);
    }

    public boolean startConnexion() {
        try {
            statement = CONNECTION.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean stopConnexion() {
        try {
            statement.close();
            CONNECTION.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public String[][] requestData(int cantidad){
        String[][] result = new String[cantidad][3];
        try {
            String sqlQuery = "select * from imcdata order by id DESC limit " + cantidad;
            ResultSet rs = statement.executeQuery(sqlQuery);
            int count = 0;
            while (rs.next()){
                result[count][0] = String.valueOf(rs.getInt("id"));
                result[count][1] = String.valueOf(rs.getDate("fechanac"));
                result[count][2] = String.valueOf(rs.getFloat("imc"));
                count++;
            }
            System.out.println(Arrays.deepToString(result));
        } catch (SQLException e) {
            result = null;
        }
        return result;
    }

    public boolean insertData(LocalDate date, float imc) {
        try {
            String sqlQuery = "select * from imcdata";
            ResultSet rs = statement.executeQuery(sqlQuery);
            rs.moveToInsertRow();
            rs.updateObject("fechanac", date);
            rs.updateFloat("imc", imc);
            rs.insertRow();
            rs.close();
            return true;
        } catch (SQLException e){
            System.err.println(e.getSQLState());
            return false;
        }
    }
}
