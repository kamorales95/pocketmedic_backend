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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KEVIN MORALES
 */
@Entity
@Table(name = "auditoria_consultas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuditoriaConsulta.findAll", query = "SELECT a FROM AuditoriaConsulta a"),
    @NamedQuery(name = "AuditoriaConsulta.findByIdAuditoriaConsulta", query = "SELECT a FROM AuditoriaConsulta a WHERE a.idAuditoriaConsulta = :idAuditoriaConsulta"),
    @NamedQuery(name = "AuditoriaConsulta.findByIdConsultasOld", query = "SELECT a FROM AuditoriaConsulta a WHERE a.idConsultasOld = :idConsultasOld"),
    @NamedQuery(name = "AuditoriaConsulta.findByDescripcionOld", query = "SELECT a FROM AuditoriaConsulta a WHERE a.descripcionOld = :descripcionOld"),
    @NamedQuery(name = "AuditoriaConsulta.findByPublicoOld", query = "SELECT a FROM AuditoriaConsulta a WHERE a.publicoOld = :publicoOld"),
    @NamedQuery(name = "AuditoriaConsulta.findByUrlImageOld", query = "SELECT a FROM AuditoriaConsulta a WHERE a.urlImageOld = :urlImageOld"),
    @NamedQuery(name = "AuditoriaConsulta.findByIdConsultasNew", query = "SELECT a FROM AuditoriaConsulta a WHERE a.idConsultasNew = :idConsultasNew"),
    @NamedQuery(name = "AuditoriaConsulta.findByDescripcionNew", query = "SELECT a FROM AuditoriaConsulta a WHERE a.descripcionNew = :descripcionNew"),
    @NamedQuery(name = "AuditoriaConsulta.findByPublicoNew", query = "SELECT a FROM AuditoriaConsulta a WHERE a.publicoNew = :publicoNew"),
    @NamedQuery(name = "AuditoriaConsulta.findByUrlImageNew", query = "SELECT a FROM AuditoriaConsulta a WHERE a.urlImageNew = :urlImageNew")})
public class AuditoriaConsulta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_auditoria_consulta")
    private Integer idAuditoriaConsulta;
    @Column(name = "id_consultas_old")
    private Integer idConsultasOld;
    @Size(max = 45)
    @Column(name = "descripcion_old")
    private String descripcionOld;
    @Column(name = "publico_old")
    private Boolean publicoOld;
    @Size(max = 500)
    @Column(name = "url_image_old")
    private String urlImageOld;
    @Column(name = "id_consultas_new")
    private Integer idConsultasNew;
    @Size(max = 45)
    @Column(name = "descripcion_new")
    private String descripcionNew;
    @Column(name = "publico_new")
    private Boolean publicoNew;
    @Size(max = 500)
    @Column(name = "url_image_new")
    private String urlImageNew;

    public AuditoriaConsulta() {
    }

    public AuditoriaConsulta(Integer idAuditoriaConsulta) {
        this.idAuditoriaConsulta = idAuditoriaConsulta;
    }

    public Integer getIdAuditoriaConsulta() {
        return idAuditoriaConsulta;
    }

    public void setIdAuditoriaConsulta(Integer idAuditoriaConsulta) {
        this.idAuditoriaConsulta = idAuditoriaConsulta;
    }

    public Integer getIdConsultasOld() {
        return idConsultasOld;
    }

    public void setIdConsultasOld(Integer idConsultasOld) {
        this.idConsultasOld = idConsultasOld;
    }

    public String getDescripcionOld() {
        return descripcionOld;
    }

    public void setDescripcionOld(String descripcionOld) {
        this.descripcionOld = descripcionOld;
    }

    public Boolean getPublicoOld() {
        return publicoOld;
    }

    public void setPublicoOld(Boolean publicoOld) {
        this.publicoOld = publicoOld;
    }

    public String getUrlImageOld() {
        return urlImageOld;
    }

    public void setUrlImageOld(String urlImageOld) {
        this.urlImageOld = urlImageOld;
    }

    public Integer getIdConsultasNew() {
        return idConsultasNew;
    }

    public void setIdConsultasNew(Integer idConsultasNew) {
        this.idConsultasNew = idConsultasNew;
    }

    public String getDescripcionNew() {
        return descripcionNew;
    }

    public void setDescripcionNew(String descripcionNew) {
        this.descripcionNew = descripcionNew;
    }

    public Boolean getPublicoNew() {
        return publicoNew;
    }

    public void setPublicoNew(Boolean publicoNew) {
        this.publicoNew = publicoNew;
    }

    public String getUrlImageNew() {
        return urlImageNew;
    }

    public void setUrlImageNew(String urlImageNew) {
        this.urlImageNew = urlImageNew;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuditoriaConsulta != null ? idAuditoriaConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuditoriaConsulta)) {
            return false;
        }
        AuditoriaConsulta other = (AuditoriaConsulta) object;
        if ((this.idAuditoriaConsulta == null && other.idAuditoriaConsulta != null) || (this.idAuditoriaConsulta != null && !this.idAuditoriaConsulta.equals(other.idAuditoriaConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pocketmedic.jpa.entities.AuditoriaConsulta[ idAuditoriaConsulta=" + idAuditoriaConsulta + " ]";
    }
    
}
