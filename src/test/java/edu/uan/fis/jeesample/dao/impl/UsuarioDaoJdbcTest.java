/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dao.impl;

/**
 *
 * @author Flia.Mersan
 */

import edu.uan.fis.jeesample.dto.Usuario;
import java.util.List;
import junit.framework.TestCase;

public class UsuarioDaoJdbcTest extends TestCase {
    
    public UsuarioDaoJdbcTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testCreate() {
        System.out.println("create");
        Usuario usuario = new Usuario();
        usuario.setName("Nuevo Usuario");
        usuario.setUser("User Usuario");
        usuario.setPassword("Password");
        UsuarioDaoJdbc instance = new UsuarioDaoJdbc();
        Usuario expResult = usuario;
        Usuario result = instance.create(usuario);
        
        Usuario usuario1 = new Usuario();
        usuario1.setName("Nuevo Usuario 1");
        usuario1.setUser("User Usuario 1");
        usuario1.setPassword("Password 1");
        UsuarioDaoJdbc instance1 = new UsuarioDaoJdbc();
        Usuario expResult1 = usuario1;
        Usuario result1 = instance1.create(usuario1);
        
    }

    public void testUpdate() {
        System.out.println("update");
        Usuario usuario = null;
        UsuarioDaoJdbc instance = new UsuarioDaoJdbc();
        Usuario expResult = null;
        Usuario result = instance.update(usuario);
                 }

    public void testDelete() {
        System.out.println("delete");
        Usuario usuario = null;
        UsuarioDaoJdbc instance = new UsuarioDaoJdbc();
        instance.delete(usuario);
            }

    public void testFindById() {
        System.out.println("findById");
        Integer usuarioId = null;
        UsuarioDaoJdbc instance = new UsuarioDaoJdbc();
        Usuario expResult = null;
        Usuario result = instance.findById(usuarioId);      
    }

    public void testFindAll() {
        System.out.println("findAll");
        UsuarioDaoJdbc instance = new UsuarioDaoJdbc();
        List expResult = null;
        List result = instance.findAll();
     
    }
}