/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author octav
 */
public class ConexionApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conn = null;

    Statement sentencia = null;

    ResultSet resultado;

System.out.println( "Conexión a la base de datos..." );

try{ // Se carga el driver JDBC-ODBC
   Class.forName ("com.mysql.cj.jdbc.Driver");
} catch( ClassNotFoundException e ) {
   System.out.println("No se pudo cargar el driver JDBC");
}

try{ // Se establece la conexión con la base de datos

conn = DriverManager.getConnection
("jdbc:mysql://localhost/pharmaplus?"+"user=root");
sentencia = conn.createStatement();
} catch (SQLException ex) {
System.out.println("No hay conexión con la base de datos.");

}
 try {
    System.out.println( "Seleccionando..." );
    resultado = sentencia.executeQuery
    ("SELECT  Id,Nombre, Apellido_paterno,Numero_de_emergencia FROM usuariosoficial");
    //Se recorren las tuplas retornadas
    while (resultado.next())
    {
    System.out.println(resultado.getInt("Id") + "---" + resultado.getString("Nombre")+ "---" + resultado.getString("Apellido_paterno")+ "---" + resultado.getString("Numero_de_emergencia"));
    }   
      conn.close(); //Cierre de la conexión
} catch( SQLException e ){

    System.out.println("Error: " + e.getMessage());

}
System.out.println("Consulta finalizada.");
} //Fin del main

    public void obtenerConexion() {
        
    }
   
    }
    

