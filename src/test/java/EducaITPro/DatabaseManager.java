package EducaITPro;

import java.sql.*;

public class DatabaseManager {

    private Connection connection;

    public DatabaseManager(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    public String[] obtenerDatosUsuario(int userId) throws SQLException {
        String[] datosUsuario = new String[3];

        String consultaSQL = "SELECT id,usuario, pass FROM usuarios WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(consultaSQL)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                datosUsuario[0] = resultSet.getString("usuario");
                datosUsuario[1] = resultSet.getString("pass");
            }
        }

        return datosUsuario;
    }

    public void cerrarConexion() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
