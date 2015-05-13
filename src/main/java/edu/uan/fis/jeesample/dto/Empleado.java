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
public class Empleado implements Serializable {

    private String name;
    private String user;
    private String password;
    private Integer empleadoId=0;
    private Integer perfilId=0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
        public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
      
    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }
    
     public Integer getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(Integer empleadoId) {
        this.perfilId = empleadoId;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Empleado == false)
            return false;
        Empleado that = (Empleado) o;
        return that.empleadoId.equals(this.empleadoId);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 79 * hash + (this.empleadoId != null ? this.empleadoId.hashCode() : 0);
        return hash;
    }
}


