
package edu.uan.fis.jeesample.dao.impl;

/**
 *
 * @author Flia.Mersan
 */

import edu.uan.fis.jeesample.dto.Empleado;
import java.util.List;
import junit.framework.TestCase;

public class EmpleadoDaoJdbcTest extends TestCase {
    
    public EmpleadoDaoJdbcTest(String testName) {
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
        Empleado empleado = new Empleado();
        empleado.setName("Alta Empleado");
        empleado.setUser("Usuario Empleado");
        empleado.setPassword("Password");
        empleado.setPerfilId(2);
       
        EmpleadoDaoJdbc instance = new EmpleadoDaoJdbc();
        Empleado expResult = empleado;
        Empleado result = instance.create(empleado);
        
        Empleado empleado1 = new Empleado();
        empleado1.setName("Alta Empleado 1");
        empleado1.setUser("Usuario Empleado 1");
        empleado1.setPassword("Password 1");
        empleado1.setPerfilId(2);
        EmpleadoDaoJdbc instance1 = new EmpleadoDaoJdbc();
        Empleado expResult1 = empleado1;
        Empleado result1 = instance1.create(empleado1);
        
    }

    public void testUpdate() {
        System.out.println("update");
        Empleado empleado = null;
        EmpleadoDaoJdbc instance = new EmpleadoDaoJdbc();
        Empleado expResult = null;
        Empleado result = instance.update(empleado);
                 }

    public void testDelete() {
        System.out.println("delete");
        Empleado empleado = null;
        EmpleadoDaoJdbc instance = new EmpleadoDaoJdbc();
        instance.delete(empleado);
            }

    public void testFindById() {
        System.out.println("findById");
        Integer empleadoId = null;
        EmpleadoDaoJdbc instance = new EmpleadoDaoJdbc();
        Empleado expResult = null;
        Empleado result = instance.findById(empleadoId);      
    }

    public void testFindAll() {
        System.out.println("findAll");
        EmpleadoDaoJdbc instance = new EmpleadoDaoJdbc();
        List expResult = null;
        List result = instance.findAll();
     
    }
}