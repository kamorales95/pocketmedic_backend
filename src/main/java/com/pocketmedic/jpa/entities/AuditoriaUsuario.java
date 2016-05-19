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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KEVIN MORALES
 */
@Entity
@Table(name = "auditoria_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuditoriaUsuario.findAll", query = "SELECT a FROM AuditoriaUsuario a"),
    @NamedQuery(name = "AuditoriaUsuario.findByIdAuditoriaUsuarios", query = "SELECT a FROM AuditoriaUsuario a WHERE a.idAuditoriaUsuarios = :idAuditoriaUsuarios"),
    @NamedQuery(name = "AuditoriaUsuario.findByIdUsuarioOld", query = "SELECT a FROM AuditoriaUsuario a WHERE a.idUsuarioOld = :idUsuarioOld"),
    @NamedQuery(name = "AuditoriaUsuario.findByNombresOld", query = "SELECT a FROM AuditoriaUsuario a WHERE a.nombresOld = :nombresOld"),
    @NamedQuery(name = "AuditoriaUsuario.findByApellidosOld", query = "SELECT a FROM AuditoriaUsuario a WHERE a.apellidosOld = :apellidosOld"),
    @NamedQuery(name = "AuditoriaUsuario.findByTelefonoOld", query = "SELECT a FROM AuditoriaUsuario a WHERE a.telefonoOld = :telefonoOld"),
    @NamedQuery(name = "AuditoriaUsuario.findByDireccionOld", query = "SELECT a FROM AuditoriaUsuario a WHERE a.direccionOld = :direccionOld"),
    @NamedQuery(name = "AuditoriaUsuario.findByEmailOld", query = "SELECT a FROM AuditoriaUsuario a WHERE a.emailOld = :emailOld"),
    @NamedQuery(name = "AuditoriaUsuario.findByFechaNacOld", query = "SELECT a FROM AuditoriaUsuario a WHERE a.fechaNacOld = :fechaNacOld"),
    @NamedQuery(name = "AuditoriaUsuario.findBySexoOld", query = "SELECT a FROM AuditoriaUsuario a WHERE a.sexoOld = :sexoOld"),
    @NamedQuery(name = "AuditoriaUsuario.findByDocumentoOld", query = "SELECT a FROM AuditoriaUsuario a WHERE a.documentoOld = :documentoOld"),
    @NamedQuery(name = "AuditoriaUsuario.findByPasswordOld", query = "SELECT a FROM AuditoriaUsuario a WHERE a.passwordOld = :passwordOld"),
    @NamedQuery(name = "AuditoriaUsuario.findByAvatarOld", query = "SELECT a FROM AuditoriaUsuario a WHERE a.avatarOld = :avatarOld"),
    @NamedQuery(name = "AuditoriaUsuario.findByTarjetaProfesionalOld", query = "SELECT a FROM AuditoriaUsuario a WHERE a.tarjetaProfesionalOld = :tarjetaProfesionalOld"),
    @NamedQuery(name = "AuditoriaUsuario.findByIdUsuarioNew", query = "SELECT a FROM AuditoriaUsuario a WHERE a.idUsuarioNew = :idUsuarioNew"),
    @NamedQuery(name = "AuditoriaUsuario.findByNombresNew", query = "SELECT a FROM AuditoriaUsuario a WHERE a.nombresNew = :nombresNew"),
    @NamedQuery(name = "AuditoriaUsuario.findByApellidosNew", query = "SELECT a FROM AuditoriaUsuario a WHERE a.apellidosNew = :apellidosNew"),
    @NamedQuery(name = "AuditoriaUsuario.findByTelefonoNew", query = "SELECT a FROM AuditoriaUsuario a WHERE a.telefonoNew = :telefonoNew"),
    @NamedQuery(name = "AuditoriaUsuario.findByDireccionNew", query = "SELECT a FROM AuditoriaUsuario a WHERE a.direccionNew = :direccionNew"),
    @NamedQuery(name = "AuditoriaUsuario.findByEmailNew", query = "SELECT a FROM AuditoriaUsuario a WHERE a.emailNew = :emailNew"),
    @NamedQuery(name = "AuditoriaUsuario.findByFechaNacNew", query = "SELECT a FROM AuditoriaUsuario a WHERE a.fechaNacNew = :fechaNacNew"),
    @NamedQuery(name = "AuditoriaUsuario.findBySexoNew", query = "SELECT a FROM AuditoriaUsuario a WHERE a.sexoNew = :sexoNew"),
    @NamedQuery(name = "AuditoriaUsuario.findByDocumentoNew", query = "SELECT a FROM AuditoriaUsuario a WHERE a.documentoNew = :documentoNew"),
    @NamedQuery(name = "AuditoriaUsuario.findByPasswordNew", query = "SELECT a FROM AuditoriaUsuario a WHERE a.passwordNew = :passwordNew"),
    @NamedQuery(name = "AuditoriaUsuario.findByAvatarNew", query = "SELECT a FROM AuditoriaUsuario a WHERE a.avatarNew = :avatarNew"),
    @NamedQuery(name = "AuditoriaUsuario.findByTarjetaProfesionalNew", query = "SELECT a FROM AuditoriaUsuario a WHERE a.tarjetaProfesionalNew = :tarjetaProfesionalNew")})
public class AuditoriaUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_auditoria_usuarios")
    private Integer idAuditoriaUsuarios;
    @Column(name = "id_usuario_old")
    private Integer idUsuarioOld;
    @Size(max = 40)
    @Column(name = "nombres_old")
    private String nombresOld;
    @Size(max = 40)
    @Column(name = "apellidos_old")
    private String apellidosOld;
    @Size(max = 16)
    @Column(name = "telefono_old")
    private String telefonoOld;
    @Size(max = 100)
    @Column(name = "direccion_old")
    private String direccionOld;
    @Size(max = 100)
    @Column(name = "email_old")
    private String emailOld;
    @Column(name = "fecha_nac_old")
    @Temporal(TemporalType.DATE)
    private Date fechaNacOld;
    @Column(name = "sexo_old")
    private Character sexoOld;
    @Size(max = 45)
    @Column(name = "documento_old")
    private String documentoOld;
    @Size(max = 64)
    @Column(name = "password_old")
    private String passwordOld;
    @Size(max = 500)
    @Column(name = "avatar_old")
    private String avatarOld;
    @Size(max = 45)
    @Column(name = "tarjeta_profesional_old")
    private String tarjetaProfesionalOld;
    @Column(name = "id_usuario_new")
    private Integer idUsuarioNew;
    @Size(max = 40)
    @Column(name = "nombres_new")
    private String nombresNew;
    @Size(max = 40)
    @Column(name = "apellidos_new")
    private String apellidosNew;
    @Size(max = 16)
    @Column(name = "telefono_new")
    private String telefonoNew;
    @Size(max = 100)
    @Column(name = "direccion_new")
    private String direccionNew;
    @Size(max = 100)
    @Column(name = "email_new")
    private String emailNew;
    @Column(name = "fecha_nac_new")
    @Temporal(TemporalType.DATE)
    private Date fechaNacNew;
    @Column(name = "sexo_new")
    private Character sexoNew;
    @Size(max = 45)
    @Column(name = "documento_new")
    private String documentoNew;
    @Size(max = 64)
    @Column(name = "password_new")
    private String passwordNew;
    @Size(max = 500)
    @Column(name = "avatar_new")
    private String avatarNew;
    @Size(max = 45)
    @Column(name = "tarjeta_profesional_new")
    private String tarjetaProfesionalNew;

    public AuditoriaUsuario() {
    }

    public AuditoriaUsuario(Integer idAuditoriaUsuarios) {
        this.idAuditoriaUsuarios = idAuditoriaUsuarios;
    }

    public Integer getIdAuditoriaUsuarios() {
        return idAuditoriaUsuarios;
    }

    public void setIdAuditoriaUsuarios(Integer idAuditoriaUsuarios) {
        this.idAuditoriaUsuarios = idAuditoriaUsuarios;
    }

    public Integer getIdUsuarioOld() {
        return idUsuarioOld;
    }

    public void setIdUsuarioOld(Integer idUsuarioOld) {
        this.idUsuarioOld = idUsuarioOld;
    }

    public String getNombresOld() {
        return nombresOld;
    }

    public void setNombresOld(String nombresOld) {
        this.nombresOld = nombresOld;
    }

    public String getApellidosOld() {
        return apellidosOld;
    }

    public void setApellidosOld(String apellidosOld) {
        this.apellidosOld = apellidosOld;
    }

    public String getTelefonoOld() {
        return telefonoOld;
    }

    public void setTelefonoOld(String telefonoOld) {
        this.telefonoOld = telefonoOld;
    }

    public String getDireccionOld() {
        return direccionOld;
    }

    public void setDireccionOld(String direccionOld) {
        this.direccionOld = direccionOld;
    }

    public String getEmailOld() {
        return emailOld;
    }

    public void setEmailOld(String emailOld) {
        this.emailOld = emailOld;
    }

    public Date getFechaNacOld() {
        return fechaNacOld;
    }

    public void setFechaNacOld(Date fechaNacOld) {
        this.fechaNacOld = fechaNacOld;
    }

    public Character getSexoOld() {
        return sexoOld;
    }

    public void setSexoOld(Character sexoOld) {
        this.sexoOld = sexoOld;
    }

    public String getDocumentoOld() {
        return documentoOld;
    }

    public void setDocumentoOld(String documentoOld) {
        this.documentoOld = documentoOld;
    }

    public String getPasswordOld() {
        return passwordOld;
    }

    public void setPasswordOld(String passwordOld) {
        this.passwordOld = passwordOld;
    }

    public String getAvatarOld() {
        return avatarOld;
    }

    public void setAvatarOld(String avatarOld) {
        this.avatarOld = avatarOld;
    }

    public String getTarjetaProfesionalOld() {
        return tarjetaProfesionalOld;
    }

    public void setTarjetaProfesionalOld(String tarjetaProfesionalOld) {
        this.tarjetaProfesionalOld = tarjetaProfesionalOld;
    }

    public Integer getIdUsuarioNew() {
        return idUsuarioNew;
    }

    public void setIdUsuarioNew(Integer idUsuarioNew) {
        this.idUsuarioNew = idUsuarioNew;
    }

    public String getNombresNew() {
        return nombresNew;
    }

    public void setNombresNew(String nombresNew) {
        this.nombresNew = nombresNew;
    }

    public String getApellidosNew() {
        return apellidosNew;
    }

    public void setApellidosNew(String apellidosNew) {
        this.apellidosNew = apellidosNew;
    }

    public String getTelefonoNew() {
        return telefonoNew;
    }

    public void setTelefonoNew(String telefonoNew) {
        this.telefonoNew = telefonoNew;
    }

    public String getDireccionNew() {
        return direccionNew;
    }

    public void setDireccionNew(String direccionNew) {
        this.direccionNew = direccionNew;
    }

    public String getEmailNew() {
        return emailNew;
    }

    public void setEmailNew(String emailNew) {
        this.emailNew = emailNew;
    }

    public Date getFechaNacNew() {
        return fechaNacNew;
    }

    public void setFechaNacNew(Date fechaNacNew) {
        this.fechaNacNew = fechaNacNew;
    }

    public Character getSexoNew() {
        return sexoNew;
    }

    public void setSexoNew(Character sexoNew) {
        this.sexoNew = sexoNew;
    }

    public String getDocumentoNew() {
        return documentoNew;
    }

    public void setDocumentoNew(String documentoNew) {
        this.documentoNew = documentoNew;
    }

    public String getPasswordNew() {
        return passwordNew;
    }

    public void setPasswordNew(String passwordNew) {
        this.passwordNew = passwordNew;
    }

    public String getAvatarNew() {
        return avatarNew;
    }

    public void setAvatarNew(String avatarNew) {
        this.avatarNew = avatarNew;
    }

    public String getTarjetaProfesionalNew() {
        return tarjetaProfesionalNew;
    }

    public void setTarjetaProfesionalNew(String tarjetaProfesionalNew) {
        this.tarjetaProfesionalNew = tarjetaProfesionalNew;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuditoriaUsuarios != null ? idAuditoriaUsuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuditoriaUsuario)) {
            return false;
        }
        AuditoriaUsuario other = (AuditoriaUsuario) object;
        if ((this.idAuditoriaUsuarios == null && other.idAuditoriaUsuarios != null) || (this.idAuditoriaUsuarios != null && !this.idAuditoriaUsuarios.equals(other.idAuditoriaUsuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pocketmedic.jpa.entities.AuditoriaUsuario[ idAuditoriaUsuarios=" + idAuditoriaUsuarios + " ]";
    }
    
}
