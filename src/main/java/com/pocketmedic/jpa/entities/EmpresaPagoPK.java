/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pocketmedic.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author KEVIN MORALES
 */
@Embeddable
public class EmpresaPagoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_empresa_pago")
    private int idEmpresaPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_empresa")
    private int idEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pagos")
    private int idPagos;

    public EmpresaPagoPK() {
    }

    public EmpresaPagoPK(int idEmpresaPago, int idEmpresa, int idPagos) {
        this.idEmpresaPago = idEmpresaPago;
        this.idEmpresa = idEmpresa;
        this.idPagos = idPagos;
    }

    public int getIdEmpresaPago() {
        return idEmpresaPago;
    }

    public void setIdEmpresaPago(int idEmpresaPago) {
        this.idEmpresaPago = idEmpresaPago;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdPagos() {
        return idPagos;
    }

    public void setIdPagos(int idPagos) {
        this.idPagos = idPagos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEmpresaPago;
        hash += (int) idEmpresa;
        hash += (int) idPagos;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaPagoPK)) {
            return false;
        }
        EmpresaPagoPK other = (EmpresaPagoPK) object;
        if (this.idEmpresaPago != other.idEmpresaPago) {
            return false;
        }
        if (this.idEmpresa != other.idEmpresa) {
            return false;
        }
        if (this.idPagos != other.idPagos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pocketmedic.jpa.entities.EmpresaPagoPK[ idEmpresaPago=" + idEmpresaPago + ", idEmpresa=" + idEmpresa + ", idPagos=" + idPagos + " ]";
    }
    
}
