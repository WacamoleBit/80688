package mx.uv;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.mysql.jdbc.Connection;

public class DAO {
    //en el dao se establece la conexion al motor de la base de datos
    private static Conexion c = new Conexion();

    //creamos statements
    //este metodo regresa un conjunto de usuarios que cumpla un criterio
    public static List<Usuario> dameUsuarios() {
        Statement statement = null;
        ResultSet resultSet = null;
        Connection conn = null;
        List<Usuario> lista = null;

        conn = (Connection) c.getConnection();

        try {
            String sql = "SELECT * FROM usuarios;";
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Usuario usuario = new Usuario(resultSet.getString("id"), resultSet.getString("nombre"), resultSet.getString("password"));
                lista.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("Driver: " + e);
        } finally {
            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    System.out.println("SQL Resultset Close: " + e);
                }
                resultSet = null;
            }

            if(statement != null){
                try {
                    statement.close();
                } catch (Exception e) {
                    System.out.println("SQL Statement Close: " + e);
                }
                statement = null;
            }

            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("Connection Close: " + e);
            }
        }

        return lista;
    }
}
