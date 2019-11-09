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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "nomina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nomina.findAll", query = "SELECT n FROM Nomina n")
    , @NamedQuery(name = "Nomina.findByIdNomina", query = "SELECT n FROM Nomina n WHERE n.idNomina = :idNomina")
    , @NamedQuery(name = "Nomina.findByHorasTrabajadas", query = "SELECT n FROM Nomina n WHERE n.horasTrabajadas = :horasTrabajadas")
    , @NamedQuery(name = "Nomina.findByHorasExtras", query = "SELECT n FROM Nomina n WHERE n.horasExtras = :horasExtras")
    , @NamedQuery(name = "Nomina.findBySueldo", query = "SELECT n FROM Nomina n WHERE n.sueldo = :sueldo")})
public class Nomina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNomina")
    private Integer idNomina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horasTrabajadas")
    private int horasTrabajadas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horasExtras")
    private int horasExtras;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sueldo")
    private double sueldo;
    @JoinColumn(name = "idEmpleado", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false)
    private Empleado idEmpleado;

    public Nomina() {
    }

    public Nomina(Integer idNomina) {
        this.idNomina = idNomina;
    }

    public Nomina(Integer idNomina, int horasTrabajadas, int horasExtras, double sueldo) {
        this.idNomina = idNomina;
        this.horasTrabajadas = horasTrabajadas;
        this.horasExtras = horasExtras;
        this.sueldo = sueldo;
    }

    public Integer getIdNomina() {
        return idNomina;
    }

    public void setIdNomina(Integer idNomina) {
        this.idNomina = idNomina;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNomina != null ? idNomina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nomina)) {
            return false;
        }
        Nomina other = (Nomina) object;
        if ((this.idNomina == null && other.idNomina != null) || (this.idNomina != null && !this.idNomina.equals(other.idNomina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Nomina[ idNomina=" + idNomina + " ]";
    }
    
}
