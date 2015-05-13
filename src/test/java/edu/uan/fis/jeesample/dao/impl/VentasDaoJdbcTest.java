package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dto.Ventas;
import java.util.List;
import junit.framework.TestCase;

public class VentasDaoJdbcTest extends TestCase {
    
    public VentasDaoJdbcTest(String testName) {
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
        //System.out.println("create");
        //Compras ventas = new Ventas();
        //ventas.setProductId(3);
        //ventas.setClienteId(1);
        //ComprasDaoJdbc instance = new VentasDaoJdbc();
        //Compras expResult = ventas;
        //Compras result = instance.create(ventas);
        //assertEquals(expResult, result);
           System.out.println("create");
        Ventas ventas = new Ventas();
        ventas.setProductId(3);
        ventas.setClienteId(1);
        
        VentasDaoJdbc instance = new VentasDaoJdbc();
        Ventas expResult = ventas;
        Ventas result = instance.create(ventas);
        
        Ventas ventas1 = new Ventas();
        ventas1.setProductId(1);
        ventas1.setClienteId(1);
        VentasDaoJdbc instance1 = new VentasDaoJdbc();
        Ventas expResult1 = ventas1;
        Ventas result1 = instance1.create(ventas1);
    }

    public void testUpdate() {
        System.out.println("update");
        Ventas ventas = null;
        VentasDaoJdbc instance = new VentasDaoJdbc();
        Ventas expResult = null;
        Ventas result = instance.update(ventas);
       
    }

    public void testDelete() {
        System.out.println("delete");
        Ventas ventas = null;
        VentasDaoJdbc instance = new VentasDaoJdbc();
        instance.delete(ventas);
        
    }

    public void testFindById() {
        System.out.println("findById");
        Integer ventasId = null;
        VentasDaoJdbc instance = new VentasDaoJdbc();
        Ventas expResult = null;
        Ventas result = instance.findById(ventasId);
      
    }

    public void testFindAll() {
        System.out.println("findAll");
        VentasDaoJdbc instance = new VentasDaoJdbc();
        List expResult = null;
        List result = instance.findAll();
        
    }
}

