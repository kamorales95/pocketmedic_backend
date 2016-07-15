/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pocketmedic.jpa.entities;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KEVIN MORALES
 */
@Entity
@Table(name = "RESPUESTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r"),
    @NamedQuery(name = "Respuesta.findByIdRespuestas", query = "SELECT r FROM Respuesta r WHERE r.idRespuestas = :idRespuestas"),
    @NamedQuery(name = "Respuesta.findByIdUsuario", query = "SELECT r FROM Respuesta r WHERE r.idConsultas.idUsuario.idUsuario = :idUsuario"),
    @NamedQuery(name = "Respuesta.findByDescripcion", query = "SELECT r FROM Respuesta r WHERE r.descripcion = :descripcion")})
public class Respuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_respuestas")
    private Integer idRespuestas;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_consultas", referencedColumnName = "id_consultas")
    @ManyToOne(optional = false)
    private Consulta idConsultas;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Respuesta() {
    }

    public Respuesta(Integer idRespuestas) {
        this.idRespuestas = idRespuestas;
    }

    public Integer getIdRespuestas() {
        return idRespuestas;
    }

    public void setIdRespuestas(Integer idRespuestas) {
        this.idRespuestas = idRespuestas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Consulta getIdConsultas() {
        return idConsultas;
    }

    public void setIdConsultas(Consulta idConsultas) {
        this.idConsultas = idConsultas;
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
        hash += (idRespuestas != null ? idRespuestas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuesta)) {
            return false;
        }
        Respuesta other = (Respuesta) object;
        if ((this.idRespuestas == null && other.idRespuestas != null) || (this.idRespuestas != null && !this.idRespuestas.equals(other.idRespuestas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pocketmedic.jpa.entities.Respuesta[ idRespuestas=" + idRespuestas + " ]";
    }
    
}
