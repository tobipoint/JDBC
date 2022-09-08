package JDBC1.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {

    protected static Connection conexion = null;
    protected static ResultSet resultado = null;
    protected static Statement sentencia = null;
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DATABASE = "estancias_exterior";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    protected static void conectarBase() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(DRIVER);
            String urlBD = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            conexion = DriverManager.getConnection(urlBD, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    protected static void desconectarBase() throws Exception {

        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            throw e;
        }

    }

    protected static void inserModElimBD(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getClass().getSimpleName());
            throw e;
        } finally {
            desconectarBase();
        }

    }

    public static void consultarBD(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }

    }

}
