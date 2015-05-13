/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dto;
import java.io.Serializable;

/**
 *
 * @author Flia.Mersan
 */
public class Ventas implements Serializable {

    private String name;
    private String user;
    private String nomproduct;
    private Integer ventasId=0;
    private Integer productId=0;
    private Integer clienteId=0;

    public String getName() {
        return name;
    }  
     public void setName(String name) {
        this.name = name;
    }
    public Integer getVentasId() {
        return ventasId;
    }

    public void setVentasId(Integer ventasId) {
        this.ventasId = ventasId;
    }
    
     public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
        public String getNameProduct() {
        return name;
    }

    public void setNameProduct(String name) {
        this.name = name;
    }
        
     public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Ventas == false)
            return false;
        Ventas that = (Ventas) o;
        return that.ventasId.equals(this.ventasId);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 79 * hash + (this.ventasId != null ? this.ventasId.hashCode() : 0);
        return hash;
    }
}


