package com.isil.ep1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;


@SpringBootApplication

public class Application {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class, args);
        //1. Cargar driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2. Crear conexión
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EP1",
                "root",
                "angel2104");

        // 3. Crear statement
        // 3.1 Statement INSERTAR
        // 3.2 Statement ELIMINAR
        Statement stmt = con.createStatement();
        String delete = "DELETE FROM users " + "WHERE nombre = ?";
        PreparedStatement ptstmt = con.prepareStatement(delete);

        ptstmt.setString(1,"Piero");

        int filasAfectadas =
                stmt.executeUpdate("INSERT INTO Users VALUES (5,'Mijail','74524670','ING INDUSTRIAL')");
        System.out.println("Filas afectadas: " + filasAfectadas);

        int filasAfectadas2 =
                ptstmt.executeUpdate();
        System.out.println("Filas afectadas: " + filasAfectadas2);

        // 3.3 Statement LISTAR
        CallableStatement callSp = con.prepareCall("{call listarAllUsers()}");


        // 4. Ejecutar query
        ResultSet resultsp = callSp.executeQuery();

        // 5. Recorrer resultados

        while (resultsp.next()){
            System.out.println(resultsp.getString("idUser"));
            System.out.println(resultsp.getString("nombre"));
            System.out.println(resultsp.getString("dni"));
            System.out.println(resultsp.getString("carrera"));
        }
        // 6. Cerrar conexion
        con.close();
    }
}
