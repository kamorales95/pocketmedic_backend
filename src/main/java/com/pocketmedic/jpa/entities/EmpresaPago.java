/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pocketmedic.jpa.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KEVIN MORALES
 */
@Entity
@Table(name = "empresas_pagos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpresaPago.findAll", query = "SELECT e FROM EmpresaPago e"),
    @NamedQuery(name = "EmpresaPago.findByIdEmpresaPago", query = "SELECT e FROM EmpresaPago e WHERE e.empresaPagoPK.idEmpresaPago = :idEmpresaPago"),
    @NamedQuery(name = "EmpresaPago.findByIdEmpresa", query = "SELECT e FROM EmpresaPago e WHERE e.empresaPagoPK.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "EmpresaPago.findByIdPagos", query = "SELECT e FROM EmpresaPago e WHERE e.empresaPagoPK.idPagos = :idPagos")})
public class EmpresaPago implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpresaPagoPK empresaPagoPK;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empresa empresa;
    @JoinColumn(name = "id_pagos", referencedColumnName = "id_pagos", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pago pago;

    public EmpresaPago() {
    }

    public EmpresaPago(EmpresaPagoPK empresaPagoPK) {
        this.empresaPagoPK = empresaPagoPK;
    }

    public EmpresaPago(int idEmpresaPago, int idEmpresa, int idPagos) {
        this.empresaPagoPK = new EmpresaPagoPK(idEmpresaPago, idEmpresa, idPagos);
    }

    public EmpresaPagoPK getEmpresaPagoPK() {
        return empresaPagoPK;
    }

    public void setEmpresaPagoPK(EmpresaPagoPK empresaPagoPK) {
        this.empresaPagoPK = empresaPagoPK;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empresaPagoPK != null ? empresaPagoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaPago)) {
            return false;
        }
        EmpresaPago other = (EmpresaPago) object;
        if ((this.empresaPagoPK == null && other.empresaPagoPK != null) || (this.empresaPagoPK != null && !this.empresaPagoPK.equals(other.empresaPagoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pocketmedic.jpa.entities.EmpresaPago[ empresaPagoPK=" + empresaPagoPK + " ]";
    }
    
}
