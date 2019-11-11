/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import login.beans.*;

import controlador.*;
import javax.inject.*;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.*;
import javax.faces.application.*;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
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
                HttpSession session = SessionUtils.getSession();
                session.setAttribute("usuario", nombreUsuario);
               return "ingresar"; 
            }
               FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
			return "login";
        }
        return  null;
    }
    public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}
}
