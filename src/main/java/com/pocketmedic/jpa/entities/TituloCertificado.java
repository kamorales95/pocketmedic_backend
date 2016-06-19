/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pocketmedic.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author KEVIN MORALES
 */
@Entity
@Table(name = "TITULOS_Y_CERTIFICADOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TituloCertificado.findAll", query = "SELECT t FROM TituloCertificado t"),
    @NamedQuery(name = "TituloCertificado.findByIdProfesiones", query = "SELECT t FROM TituloCertificado t WHERE t.idProfesiones = :idProfesiones"),
    @NamedQuery(name = "TituloCertificado.findByTitulos", query = "SELECT t FROM TituloCertificado t WHERE t.titulos like :titulos")})
public class TituloCertificado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_profesiones")
    private Integer idProfesiones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "titulos")
    private String titulos;
    @JoinTable(name = "PROFESIONES_USUARIOS", joinColumns = {
        @JoinColumn(name = "id_profesiones", referencedColumnName = "id_profesiones")}, inverseJoinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToMany
    private List<Usuario> usuarioList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    private List<Consulta> consultaList;
    private static final long serialVersionUID = 1L;

    public TituloCertificado() {
    }

    public TituloCertificado(Integer idProfesiones) {
        this.idProfesiones = idProfesiones;
    }

    public TituloCertificado(Integer idProfesiones, String titulos) {
        this.idProfesiones = idProfesiones;
        this.titulos = titulos;
    }

    public Integer getIdProfesiones() {
        return idProfesiones;
    }

    public void setIdProfesiones(Integer idProfesiones) {
        this.idProfesiones = idProfesiones;
    }

    public String getTitulos() {
        return titulos;
    }

    public void setTitulos(String titulos) {
        this.titulos = titulos;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfesiones != null ? idProfesiones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TituloCertificado)) {
            return false;
        }
        TituloCertificado other = (TituloCertificado) object;
        if ((this.idProfesiones == null && other.idProfesiones != null) || (this.idProfesiones != null && !this.idProfesiones.equals(other.idProfesiones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pocketmedic.jpa.entities.TituloCertificado[ idProfesiones=" + idProfesiones + " ]";
    }

    @XmlTransient
    public List<Consulta> getConsultaList() {
        return consultaList;
    }

    public void setConsultaList(List<Consulta> consultaList) {
        this.consultaList = consultaList;
    }

}
