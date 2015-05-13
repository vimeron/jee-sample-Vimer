/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
package edu.uan.fis.jeesample.dao;

import edu.uan.fis.jeesample.dto.ClienteDao;
import java.util.List;

public interface ClienteDao {

    /**
     * Creates a new cliente. 
     * @param cliente
     * @return 
     */

package edu.uan.fis.jeesample.dao;

import java.util.List;

public interface ClienteDao {
    edu.uan.fis.jeesample.dto.Cliente create(edu.uan.fis.jeesample.dto.Cliente cliente);

    /**
     * Updates an existing cliente. ClienteDao id can't be modified.
     * @param cliente
     * @return 
     */
    edu.uan.fis.jeesample.dto.Cliente update(edu.uan.fis.jeesample.dto.Cliente cliente);

    /**
     * Deletes an existing cliente
     * @param cliente 
     */
    void delete(edu.uan.fis.jeesample.dto.Cliente cliente);

    /**
     * Find a cliente by id
     * @param clienteId
     * @return 
     */
    edu.uan.fis.jeesample.dto.Cliente findById(Integer clienteId);

    /**
     * Returns all the clientes in the database
     * @return 
     */
    List<edu.uan.fis.jeesample.dto.Cliente> findAll();
}

