package server;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class Modelo {
    Connection conexion;

    public void baseDatos() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String usuario = "root";
            String contraseña = "";
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            Statement statement = conexion.createStatement();

            String crearDB = "CREATE DATABASE IF NOT EXISTS bbddUser";
            statement.executeUpdate(crearDB);

            statement.executeUpdate("USE bbddUser");

            String crearTabla = "CREATE TABLE IF NOT EXISTS datos ("
                    + "Usuario VARCHAR(50),"
                    + "Password LONGTEXT"
                    + ")";
            statement.executeUpdate(crearTabla);
        }catch (SQLException e) {
            System.out.println("Error en el conection");
        }
    }

    private static String hashPwd(String pwd) throws NoSuchAlgorithmException {
        String hashOfPwd;
        MessageDigest md = MessageDigest.getInstance("SHA-256"); // sirve para hacer has
        md.update(pwd.getBytes());
        StringBuffer hexString = new StringBuffer();
        byte[] digest = md.digest();
        for (int i = 0; i < digest.length; i++) {
            hexString.append(Integer.toHexString(0xFF & digest[i]));
        }
        hashOfPwd = hexString.toString();
        return hashOfPwd;
    }

    public boolean existeUsuario(String user){
        try {
            String consulta = "SELECT COUNT(*) AS count FROM datos WHERE Usuario = ?";
            PreparedStatement sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, user);
            ResultSet resultSet = sentencia.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar la existencia del usuario");
            e.printStackTrace();
        }
        return false;
    }

    public boolean login(String user, String pwd) {
        try {
            String hashOfPwd = hashPwd(pwd);
            String consulta = "SELECT Password FROM datos WHERE Usuario = ?";
            PreparedStatement sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, user);
            ResultSet resultSet = sentencia.executeQuery();

            if (resultSet.next()) {
                String hashFromDb = resultSet.getString("Password");
                return hashOfPwd.equalsIgnoreCase(hashFromDb);
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al iniciar sesion");
            e.printStackTrace();
        }
        return false;
    }

    public boolean registro(String usuario, String contra) {
        if(existeUsuario(usuario)){
            return false;
        }else{
            try {
                String hashOfPwd = hashPwd(contra);
                String consulta = "INSERT INTO datos (Usuario, Password) VALUES (?, ?)";
                PreparedStatement sentencia = conexion.prepareStatement(consulta);
                sentencia.setString(1, usuario);
                sentencia.setString(2, hashOfPwd);
                sentencia.executeUpdate();
                return true;
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return false;
    }
}



