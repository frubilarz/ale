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
public class Deuda {
    
    Integer id= null;
    Integer monto = null;
    Integer pago_id = null;
    Integer cliente_id = null;

    public Deuda() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Integer getPago_id() {
        return pago_id;
    }

    public void setPago_id(Integer pago_id) {
        this.pago_id = pago_id;
    }

    public Integer getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Integer carro_fiado_id) {
        this.cliente_id = carro_fiado_id;
    }
    
    
}
