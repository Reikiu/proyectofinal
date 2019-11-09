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
@Table(name = "materiaprima")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materiaprima.findAll", query = "SELECT m FROM Materiaprima m")
    , @NamedQuery(name = "Materiaprima.findByIdMaterial", query = "SELECT m FROM Materiaprima m WHERE m.idMaterial = :idMaterial")
    , @NamedQuery(name = "Materiaprima.findByNombre", query = "SELECT m FROM Materiaprima m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Materiaprima.findByPrecioUnidad", query = "SELECT m FROM Materiaprima m WHERE m.precioUnidad = :precioUnidad")})
public class Materiaprima implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMaterial")
    private Integer idMaterial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioUnidad")
    private double precioUnidad;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "existencia")
    private String existencia;

    public Materiaprima() {
    }

    public Materiaprima(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Materiaprima(Integer idMaterial, String nombre, double precioUnidad, String existencia) {
        this.idMaterial = idMaterial;
        this.nombre = nombre;
        this.precioUnidad = precioUnidad;
        this.existencia = existencia;
    }

    public Integer getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public String getExistencia() {
        return existencia;
    }

    public void setExistencia(String existencia) {
        this.existencia = existencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaterial != null ? idMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materiaprima)) {
            return false;
        }
        Materiaprima other = (Materiaprima) object;
        if ((this.idMaterial == null && other.idMaterial != null) || (this.idMaterial != null && !this.idMaterial.equals(other.idMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Materiaprima[ idMaterial=" + idMaterial + " ]";
    }
    
}
