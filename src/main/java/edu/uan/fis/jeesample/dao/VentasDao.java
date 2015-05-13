/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dao;

import edu.uan.fis.jeesample.dto.Ventas;
import java.util.List;

public interface VentasDao {

    /**
     * Creates a new ventas. 
     * @param ventas
     * @return 
     */
    Ventas create(Ventas ventas);

    /**
     * Updates an existing ventas. Ventas id can't be modified.
     * @param ventas
     * @return 
     */
    Ventas update(Ventas ventas);

    /**
     * Deletes an existing ventas
     * @param ventas 
     */
    void delete(Ventas ventas);

    /**
     * Find a ventas by id
     * @param ventasId
     * @return 
     */
    Ventas findById(Integer ventasId);

    /**
     * Returns all the ventass in the database
     * @return 
     */
    List<Ventas> findAll();
}