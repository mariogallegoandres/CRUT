package oracle;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleConection {

    private Connection conexion;

    private OracleConection conectar() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
            //BD == nombre y usuario de la base de datos
            //123 == contraseña de acceso
            conexion = DriverManager.getConnection(BaseDeDatos, "JAVA", "12345");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public void cerrarConexion() throws SQLException {
        conexion.close();
    }

    public Connection getConexion() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            this.conectar();
        }
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public ResultSet consultar(String sql) throws SQLException {
        ResultSet resultado = null;
        try {
            Statement sentencia;
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
            getConexion().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return resultado;
    }

    public boolean ejecutar(String sql) throws SQLException {
        try {
            Statement sentencia;
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(sql);
            getConexion().commit();
            sentencia.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("ERROR SQL");
            return false;
        }
        return true;
    }
}
