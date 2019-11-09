/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "maquinaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maquinaria.findAll", query = "SELECT m FROM Maquinaria m")
    , @NamedQuery(name = "Maquinaria.findByIdMaquinaria", query = "SELECT m FROM Maquinaria m WHERE m.idMaquinaria = :idMaquinaria")
    , @NamedQuery(name = "Maquinaria.findByTipoMaquinaria", query = "SELECT m FROM Maquinaria m WHERE m.tipoMaquinaria = :tipoMaquinaria")
    , @NamedQuery(name = "Maquinaria.findByModelo", query = "SELECT m FROM Maquinaria m WHERE m.modelo = :modelo")
    , @NamedQuery(name = "Maquinaria.findByAnioAdquirido", query = "SELECT m FROM Maquinaria m WHERE m.anioAdquirido = :anioAdquirido")
    , @NamedQuery(name = "Maquinaria.findByEstado", query = "SELECT m FROM Maquinaria m WHERE m.estado = :estado")})
public class Maquinaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMaquinaria")
    private Integer idMaquinaria;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nombreMaquinaria")
    private String nombreMaquinaria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipoMaquinaria")
    private String tipoMaquinaria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anioAdquirido")
    private int anioAdquirido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado")
    private String estado;

    public Maquinaria() {
    }

    public Maquinaria(Integer idMaquinaria) {
        this.idMaquinaria = idMaquinaria;
    }

    public Maquinaria(Integer idMaquinaria, String nombreMaquinaria, String tipoMaquinaria, String modelo, int anioAdquirido, String estado) {
        this.idMaquinaria = idMaquinaria;
        this.nombreMaquinaria = nombreMaquinaria;
        this.tipoMaquinaria = tipoMaquinaria;
        this.modelo = modelo;
        this.anioAdquirido = anioAdquirido;
        this.estado = estado;
    }

    public Integer getIdMaquinaria() {
        return idMaquinaria;
    }

    public void setIdMaquinaria(Integer idMaquinaria) {
        this.idMaquinaria = idMaquinaria;
    }

    public String getNombreMaquinaria() {
        return nombreMaquinaria;
    }

    public void setNombreMaquinaria(String nombreMaquinaria) {
        this.nombreMaquinaria = nombreMaquinaria;
    }

    public String getTipoMaquinaria() {
        return tipoMaquinaria;
    }

    public void setTipoMaquinaria(String tipoMaquinaria) {
        this.tipoMaquinaria = tipoMaquinaria;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnioAdquirido() {
        return anioAdquirido;
    }

    public void setAnioAdquirido(int anioAdquirido) {
        this.anioAdquirido = anioAdquirido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaquinaria != null ? idMaquinaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maquinaria)) {
            return false;
        }
        Maquinaria other = (Maquinaria) object;
        if ((this.idMaquinaria == null && other.idMaquinaria != null) || (this.idMaquinaria != null && !this.idMaquinaria.equals(other.idMaquinaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Maquinaria[ idMaquinaria=" + idMaquinaria + " ]";
    }
    
}
