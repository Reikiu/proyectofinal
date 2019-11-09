/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")
    , @NamedQuery(name = "Proyecto.findByIdProyecto", query = "SELECT p FROM Proyecto p WHERE p.idProyecto = :idProyecto")
    , @NamedQuery(name = "Proyecto.findByNombre", query = "SELECT p FROM Proyecto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Proyecto.findByFactura", query = "SELECT p FROM Proyecto p WHERE p.factura = :factura")
    , @NamedQuery(name = "Proyecto.findByFechaInicio", query = "SELECT p FROM Proyecto p WHERE p.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Proyecto.findByFechaFin", query = "SELECT p FROM Proyecto p WHERE p.fechaFin = :fechaFin")
    , @NamedQuery(name = "Proyecto.findByMontoEmpleados", query = "SELECT p FROM Proyecto p WHERE p.montoEmpleados = :montoEmpleados")
    , @NamedQuery(name = "Proyecto.findByMatUti", query = "SELECT p FROM Proyecto p WHERE p.matUti = :matUti")
    , @NamedQuery(name = "Proyecto.findByMontoMaquinaria", query = "SELECT p FROM Proyecto p WHERE p.montoMaquinaria = :montoMaquinaria")
    , @NamedQuery(name = "Proyecto.findByMontoMateria", query = "SELECT p FROM Proyecto p WHERE p.montoMateria = :montoMateria")
    , @NamedQuery(name = "Proyecto.findByMontoTotal", query = "SELECT p FROM Proyecto p WHERE p.montoTotal = :montoTotal")
    , @NamedQuery(name = "Proyecto.findByProgreso", query = "SELECT p FROM Proyecto p WHERE p.progreso = :progreso")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProyecto")
    private Integer idProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "factura")
    private int factura;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "estadoProyecto")
    private String estadoProyecto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montoEmpleados")
    private int montoEmpleados;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mat_uti")
    private int matUti;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montoMaquinaria")
    private int montoMaquinaria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montoMateria")
    private int montoMateria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montoTotal")
    private double montoTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "progreso")
    private int progreso;
    @ManyToMany(mappedBy = "proyectoCollection")
    private Collection<Empleado> empleadoCollection;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "direccion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Direccion direccion;

    public Proyecto() {
    }

    public Proyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Proyecto(Integer idProyecto, String nombre, int factura, String estadoProyecto, Date fechaInicio, Date fechaFin, int montoEmpleados, int matUti, int montoMaquinaria, int montoMateria, double montoTotal, int progreso) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.factura = factura;
        this.estadoProyecto = estadoProyecto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.montoEmpleados = montoEmpleados;
        this.matUti = matUti;
        this.montoMaquinaria = montoMaquinaria;
        this.montoMateria = montoMateria;
        this.montoTotal = montoTotal;
        this.progreso = progreso;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

    public String getEstadoProyecto() {
        return estadoProyecto;
    }

    public void setEstadoProyecto(String estadoProyecto) {
        this.estadoProyecto = estadoProyecto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getMontoEmpleados() {
        return montoEmpleados;
    }

    public void setMontoEmpleados(int montoEmpleados) {
        this.montoEmpleados = montoEmpleados;
    }

    public int getMatUti() {
        return matUti;
    }

    public void setMatUti(int matUti) {
        this.matUti = matUti;
    }

    public int getMontoMaquinaria() {
        return montoMaquinaria;
    }

    public void setMontoMaquinaria(int montoMaquinaria) {
        this.montoMaquinaria = montoMaquinaria;
    }

    public int getMontoMateria() {
        return montoMateria;
    }

    public void setMontoMateria(int montoMateria) {
        this.montoMateria = montoMateria;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public int getProgreso() {
        return progreso;
    }

    public void setProgreso(int progreso) {
        this.progreso = progreso;
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyecto != null ? idProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.idProyecto == null && other.idProyecto != null) || (this.idProyecto != null && !this.idProyecto.equals(other.idProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Proyecto[ idProyecto=" + idProyecto + " ]";
    }
    
}
