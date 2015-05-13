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
public class Usuario implements Serializable {

    private String name;
    private String user;
    private String password;
    private Integer usuarioId=0;

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
    
    
    
    
    
    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Usuario == false)
            return false;
        Usuario that = (Usuario) o;
        return that.usuarioId.equals(this.usuarioId);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 79 * hash + (this.usuarioId != null ? this.usuarioId.hashCode() : 0);
        return hash;
    }
}

