/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dao;

import edu.uan.fis.jeesample.dto.Usuario;
import java.util.List;
public interface UsuarioDao {

    /**
     * Creates a new usuario. 
     * @param usuario
     * @return 
     */
    Usuario create(Usuario usuario);

    /**
     * Updates an existing usuario. Usuario id can't be modified.
     * @param usuario
     * @return 
     */
    Usuario update(Usuario usuario);

    /**
     * Deletes an existing usuario
     * @param usuario 
     */
    void delete(Usuario usuario);

    /**
     * Find a usuario by id
     * @param usuarioId
     * @return 
     */
    Usuario findById(Integer usuarioId);

    /**
     * Returns all the usuarios in the database
     * @return 
     */
    List<Usuario> findAll();
}

    
    
    
