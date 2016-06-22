/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pocketmedic.jpa.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "CONSULTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consulta.findAll", query = "SELECT c FROM Consulta c"),
    @NamedQuery(name = "Consulta.findByIdConsultas", query = "SELECT c FROM Consulta c WHERE c.idConsultas = :idConsultas"),
    @NamedQuery(name = "Consulta.findByDescripcion", query = "SELECT c FROM Consulta c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Consulta.findByPublico", query = "SELECT c FROM Consulta c WHERE c.publico = :publico"),
        @NamedQuery(name = "Consulta.findByIdUsuario", query = "SELECT c FROM Consulta c WHERE c.idUsuario.idUsuario = :idUsuario"),
    @NamedQuery(name = "Consulta.findByUrlImage", query = "SELECT c FROM Consulta c WHERE c.urlImage = :urlImage"),
    @NamedQuery(name = "Consulta.findByFechaCita", query = "SELECT c FROM Consulta c WHERE c.fechaCita = :fechaCita")})
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_consultas")
    private Integer idConsultas;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "publico")
    private Boolean publico;
    @Size(max = 500)
    @Column(name = "url_image")
    private String urlImage;
    @Column(name = "fecha_cita")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCita;
    @JoinColumn(name = "categoria", referencedColumnName = "id_profesiones")
    @ManyToOne(optional = false)
    private TituloCertificado categoria;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Consulta() {
    }

    public Consulta(Integer idConsultas) {
        this.idConsultas = idConsultas;
    }

    public Integer getIdConsultas() {
        return idConsultas;
    }

    public void setIdConsultas(Integer idConsultas) {
        this.idConsultas = idConsultas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getPublico() {
        return publico;
    }

    public void setPublico(Boolean publico) {
        this.publico = publico;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public TituloCertificado getCategoria() {
        return categoria;
    }

    public void setCategoria(TituloCertificado categoria) {
        this.categoria = categoria;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsultas != null ? idConsultas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
        if ((this.idConsultas == null && other.idConsultas != null) || (this.idConsultas != null && !this.idConsultas.equals(other.idConsultas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pocketmedic.jpa.entities.Consulta[ idConsultas=" + idConsultas + " ]";
    }
    
}
