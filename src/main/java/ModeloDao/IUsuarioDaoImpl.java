/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDao;

import Aplicacion.Mensaje;
import Modelo.Usuario;
import Modelo.UsuarioActualizar;
import Modelo.UsuarioAgregar;
import Modelo.UsuarioAgregarCompleto;
import Modelo.UsuarioDeEmergenciaActualizar;

import Persistencia.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class IUsuarioDaoImpl implements IUsuarioDao {
    
    private Connection con;
     private Connection con2;
    Conexion conexion = new Conexion();
    
    
      public IUsuarioDaoImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/pharmaplus", "root", "");
 
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
      @Override
    public Usuario obtenerUsuariobyId(String id) {
      //primero me conecto
      
       Usuario res = null;
        try {
            String sql = "select * from usuariosoficial where Id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            int numeroEntero = Integer.parseInt(id);
            stmt.setInt(1,numeroEntero);
 
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                res = new Usuario(rs.getInt("Id"),rs.getString("Nombre"),rs.getString("Apellido_paterno"),rs.getString("Apellido_materno"),rs.getString("Contraseña"),rs.getString("Telefono_casa"),rs.getString("Telefono_celular"),rs.getString("Curp"),rs.getString("Numero_de_seguro_social"),rs.getString("Puesto_laboral"),rs.getString("Fecha_de_ingreso"),rs.getString("Direccion"),rs.getString("Fecha_de_modificacion"),rs.getString("Numero_de_emergencia"),rs.getString("Nombre_Contacto_Emergencia"),rs.getString("ApellidoP_Contacto_Emergencia"),rs.getString("ApellidoM_Contacto_Emergencia"),rs.getString("Parentesco"));
                        }                  
 
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return res;
    }

   

    @Override
    public void eliminarUsuario(int id) {
        PreparedStatement stat = null;
        try{
            String sql = "DELETE FROM usuariosoficial WHERE Id= ?";
            stat = con.prepareStatement(sql);
            stat.setInt(1, id);//modificacion
           // System.out.println(id.getId());
            if(stat.executeUpdate()==0){
                throw new DaoException("Puede que el producto no se haya borrado");
            }
        }catch(SQLException ex){
            try {
                throw new DaoException("Error de SQL", ex);
            } catch (DaoException ex1) {
                Logger.getLogger(IUsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (DaoException ex) {
            Logger.getLogger(IUsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

    @Override
    public boolean crearUsuario(UsuarioAgregar user) {
        boolean registrar=false;
        Statement stm;
       //Connection con2 = this.conexion.obtenerConexion();
      
        String sql="INSERT INTO usuariosoficial values (NULL,'"
                +user.getNombre()+"','"    
                +user.getApellidoPaterno()+"','"
                +user.getApellidoMaterno()+"','"
                +user.getContraseña()+"','"
                +user.getTelefonoCasa()+"','"
                +user.getTelefonoCelular()+"','"
                +user.getCurp()+"','"
                +user.getNumeroSeguroSocial()+"','"
                +user.getPuestoLaboral()+"','"
                +user.getFechaDeIngreso()+"','"
                +user.getDireccion()+"','"
                +user.getFechaDeModificacion()+"','"
                +user.getNumeroEmergencia()+"','"
                +user.getNombreContactoEmergencia()+"','"
                +user.getApellidoPaternoContactoEmergencia()+"','"
                +user.getApellidoMaternoContactoEmergencia()+"','"
                +user.getParentescocontactoEmergencia()+"')";
                
        System.out.println("Se registro");
    try
        {
         stm=con.createStatement();
         stm.execute(sql);
         registrar=true;
         stm.close();
         con.close();
        }
        catch(SQLException e)
                {
                    System.out.println("ERROR EN REGISTRAR");
                    e.printStackTrace();
                }
        return registrar;
    
    
    }
        
    @Override
          public void actualizarUsuarioPorId (int id ,UsuarioActualizar c) {
        String sql = "UPDATE usuariosoficial SET Nombre = ?, Apellido_paterno = ?, Apellido_materno = ?, Contraseña = ?, Telefono_casa = ?, Telefono_celular = ?, Curp = ?, Numero_de_seguro_social = ?, Puesto_laboral = ?, Direccion = ?, Fecha_de_modificacion = ?  WHERE Id = " +id;
        
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, c.getNombre());
            statement.setString(2, c.getApellidoPaterno());
            statement.setString(3, c.getApellidoMaterno());
            statement.setString(4, c.getContraseña());
            statement.setString(5, c.getTelefonoCasa());
            statement.setString(6, c.getTelefonoCelular());
            statement.setString(7, c.getCurp());
            statement.setString(8, c.getNumeroSeguroSocial());
            statement.setString(9, c.getPuestoLaboral());
            statement.setString(10, c.getDireccion());
            statement.setString(11, c.getFechaDeModificacion());
     
             statement.executeUpdate();
            
           // return filasActualizadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            //return false;
        }
    }

    
    public ArrayList<Usuario> LLenarDatos() {
     //  Usuario usuarios;
       ResultSet rs;
       PreparedStatement ps;
       ArrayList<Usuario> lista = new ArrayList<Usuario>();
       String sql = "SELECT * from usuariosoficial ";
       
      try{
           ps = con.prepareStatement(sql);
           rs= ps.executeQuery();
                while(rs.next()){
                Usuario usuario  = new Usuario();
                usuario.setId(rs.getInt("Id"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setApellidoPaterno(rs.getString("Apellido_paterno"));
                usuario.setApellidoMaterno(rs.getString("Apellido_materno"));
                usuario.setTelefonoCasa(rs.getString("Telefono_casa"));
                usuario.setTelefonoCelular(rs.getString("Telefono_celular"));
                usuario.setContraseña(rs.getString("Contraseña"));
                usuario.setPuestoLaboral(rs.getString("Puesto_laboral"));
                lista.add(usuario);
                }
                rs.close();
                ps.close();
                con.close();
       }catch(SQLException e){
       }
       return lista;
    }

   
    @Override
    public boolean crearUsuarioCompleto(UsuarioAgregarCompleto user) {
        
       try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con2 = DriverManager.getConnection("jdbc:mysql://localhost/pharmaplusgeneraldos", "root", "");
 
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        boolean registrar2=false;
        Statement stm;
       //Connection con2 = this.conexion.obtenerConexion();
      
        String sql="INSERT INTO empleados values ('"
                +user.getNumeroDeEmpleado()+"','"
                +user.getNombre()+"','"    
                +user.getApellidoPaterno()+"','"
                +user.getApellidoMaterno()+"','"
                +user.getTelefonoCasa()+"','"
                +user.getTelefonoCelular()+"','"
                +user.getCurp()+"','"
                +user.getNumeroDeSeguroSocial()+"','"
                +user.getNivelEducativo()+"','"
                +user.getRfc()+"','"
                +user.getDireccion()+"','"
                +user.getPuestoaDesempenar()+"','"
                +user.getFamiliaNo()+"','"
                +user.getNumeroDeCuenta()+"','"
                +user.getFechaDeingreso()+"','"
                +user.getContraseña()+"')";
        System.out.println("Se registro");
    try
        {
         stm=con2.createStatement();
         stm.execute(sql);
         registrar2=true;
         stm.close();
         con2.close();
        }
        catch(SQLException e)
                {
                    System.out.println("ERROR EN REGISTRAR");
                    e.printStackTrace();
                }
        return registrar2;
    

    }  

    @Override
    public UsuarioAgregarCompleto obtenerUsuariobyNumeroEmpleado(String NumeroEmpleado) {
      
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IUsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con2 = DriverManager.getConnection("jdbc:mysql://localhost/pharmaplusgeneraldos", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(IUsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        
        
        UsuarioAgregarCompleto resul = null;
        try {
            String sql = "select * from usuarios where Id=?";
            PreparedStatement stmt = con2.prepareStatement(sql);
           // int numeroEntero = Integer.parseInt(NumeroEmpleado);
            stmt.setString(1,NumeroEmpleado);
 
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                resul = new UsuarioAgregarCompleto(rs.getString("Numero_de_empleado"),rs.getString("Nombre"),rs.getString("Apellido_paterno"),rs.getString("Apellido_materno"),rs.getString("Telefono_celular"),rs.getString("Telefono_casa"),rs.getString("Curp"),rs.getString("Numero_de_seguro_social"),rs.getString("Nivel_educativo"),rs.getString("Rfc"),rs.getString("Direccion"),rs.getString("Puesto"),rs.getString("Id_parientes"),rs.getString("Numero_de_cuenta"),rs.getString("Fecha_de_ingreso"),rs.getString("contraseña"));
            }
 
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return resul;
    }

    @Override
    public void actualizarUsuarioContactoPorId(int id, UsuarioDeEmergenciaActualizar c) {
        String sql = "UPDATE usuariosoficial SET Fecha_de_modificacion = ?, Numero_de_emergencia = ?, Nombre_Contacto_Emergencia= ?, ApellidoP_Contacto_Emergencia = ?, ApellidoM_Contacto_Emergencia = ?, Parentesco = ?  WHERE Id = " +id;
        
        try (PreparedStatement statement = con.prepareStatement(sql)) {
           
             statement.setString(1, c.getFechaDeModificacion());
            statement.setString(2, c.getNumeroEmergencia());
            statement.setString(3, c.getNombreContactoEmergencia());
            statement.setString(4, c.getApellidoPaternoContactoEmergencia());
            statement.setString(5, c.getApellidoMaternoContactoEmergencia());
            statement.setString(6, c.getParentescocontactoEmergencia());
            
          //  statement.setString(6, "51");
             statement.executeUpdate();
            
           // return filasActualizadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            //return false;
        }
    }

   
}


