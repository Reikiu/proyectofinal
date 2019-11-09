/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author hp
 */
public class Proyectos {
    private int id;
    private String direccion;
    private String longitud;
    private String latitud;
    private String foto;
    
    
    public Proyectos() {
        
    }

    //constructor para agregar

    public Proyectos(int id, String direccion, String longitud, String latitud, String foto) {
        this.id = id;
        this.direccion = direccion;
        this.longitud = longitud;
        this.latitud = latitud;
        this.foto = foto;
    }

    public Proyectos(String direccion, String longitud, String latitud, String foto) {
        this.direccion = direccion;
        this.longitud = longitud;
        this.latitud = latitud;
        this.foto = foto;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }  
 
}
