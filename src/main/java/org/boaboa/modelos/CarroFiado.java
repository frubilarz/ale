/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.boaboa.modelos;

/**
 *
 * @author frubilar
 */
public class CarroFiado extends BaseBean{
    
    Integer id = null;
    Integer boleta_id = null;
    Integer cliente_id = null;
    Integer monto = null;

    public CarroFiado() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBoleta_id() {
        return boleta_id;
    }

    public void setBoleta_id(Integer boleta_id) {
        this.boleta_id = boleta_id;
    }

    public Integer getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Integer cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }
    
    
}
