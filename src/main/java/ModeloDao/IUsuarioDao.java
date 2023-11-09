/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ModeloDao;

import Modelo.Usuario;
import Modelo.UsuarioActualizar;
import Modelo.UsuarioAgregar;
import Modelo.UsuarioAgregarCompleto;
import Modelo.UsuarioDeEmergenciaActualizar;
import java.util.ArrayList;

/**
 *
 * @author octav
 */
public interface IUsuarioDao  {

    /**
     *
     * @param id
     * @return
     */
    public Usuario obtenerUsuariobyId(String id);
    public void eliminarUsuario(int id);
    public boolean crearUsuario(UsuarioAgregar user); 
    public void actualizarUsuarioPorId(int id,UsuarioActualizar c);
    public  ArrayList<Usuario> LLenarDatos();
    public boolean crearUsuarioCompleto(UsuarioAgregarCompleto user);
    public UsuarioAgregarCompleto obtenerUsuariobyNumeroEmpleado(String NumeroEmpleado);
    public void actualizarUsuarioContactoPorId (int id ,UsuarioDeEmergenciaActualizar c);
}
