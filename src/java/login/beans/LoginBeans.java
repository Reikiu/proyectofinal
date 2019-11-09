/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.beans;

import controlador.*;
import javax.inject.*;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.*;
import javax.faces.application.*;
import javax.faces.context.FacesContext;
import modelo.*;

/**
 *
 * @author HP
 */
@Named(value = "loginBeans")
@SessionScoped
public class LoginBeans implements Serializable {
    private String nombreUsuario;
    private String password;
    
    @EJB
    
    private UsuarioFacade usuFacade;
    
    private Usuario usuarioAutenticado;

    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public void setUsuarioAutenticado(Usuario usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }
    
    
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    /**
     * Creates a new instance of LoginBeans
     */
    public LoginBeans() {
    }
    public String autenticar(){
        usuarioAutenticado=usuFacade.encotrarUsuarioLogin(nombreUsuario);
        if(usuarioAutenticado!=null){
            if(usuarioAutenticado.getPassword().equals(password)){
               return "ingresar"; 
            }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Credenciales erroneos", "Credenciales erroneos"));
            return  null; 
        }
        return  null;
    }
}
