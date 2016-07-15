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
public class CarroVenta extends BaseBean {

    Integer id = null;
    Integer producto_id = null;
    Integer boleta_id = null;
    Integer cantidadProducto = null;
    Integer valor = null;

    public CarroVenta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Integer producto_id) {
        this.producto_id = producto_id;
    }

    public Integer getBoleta_id() {
        return boleta_id;
    }

    public void setBoleta_id(Integer boleta_id) {
        this.boleta_id = boleta_id;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

}
