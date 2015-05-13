package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dto.Product;
import java.util.List;
import junit.framework.TestCase;

public class ProductDaoJdbcTest extends TestCase {
    
    public ProductDaoJdbcTest(String testName) {
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
        Product product = new Product();
        product.setName("Impresora");
        ProductDaoJdbc instance = new ProductDaoJdbc();
        Product expResult = product;
        Product result = instance.create(product);
        
        Product product1 = new Product();
        product1.setName("Scaner");
        ProductDaoJdbc instance1 = new ProductDaoJdbc();
        Product expResult1 = product1;
        Product result1 = instance1.create(product1);
        
    }

    public void testUpdate() {
        System.out.println("update");
        Product product = null;
        ProductDaoJdbc instance = new ProductDaoJdbc();
        Product expResult = null;
        Product result = instance.update(product);
                 }

    public void testDelete() {
        System.out.println("delete");
        Product product = null;
        ProductDaoJdbc instance = new ProductDaoJdbc();
        instance.delete(product);
            }

    public void testFindById() {
        System.out.println("findById");
        Integer productId = null;
        ProductDaoJdbc instance = new ProductDaoJdbc();
        Product expResult = null;
        Product result = instance.findById(productId);      
    }

    public void testFindAll() {
        System.out.println("findAll");
        ProductDaoJdbc instance = new ProductDaoJdbc();
        List expResult = null;
        List result = instance.findAll();
     
    }
}
