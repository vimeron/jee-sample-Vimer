package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.VentasDao;
import edu.uan.fis.jeesample.dto.Ventas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Ventas DAO implementation using JDBC
 */
public class VentasDaoJdbc implements VentasDao {
    
    public Ventas create(Ventas ventas) {
        // Sample code
        Connection conn = null;
         Statement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRUEBA;create=false;user=prueba;password=prueba");
            // 3. Creates the ventas in the database
           stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO tbl_ventas (id_ventas, nom_ventas) VALUES(" + ventas.getVentasId() + ",'" + ventas.getName() + "')");
       } catch (SQLException ex) {
            Logger.getLogger(VentasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VentasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
            stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(VentasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(VentasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ventas;
    }
    
    public Ventas update(Ventas ventas) {
        
         Connection conn = null;
         Statement stmt = null;
        try {            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRUEBA;create=false;user=prueba;password=prueba");
            // 3. actualizar ventaso en la base de datos
            stmt = conn.createStatement();
            stmt.execute("UPDATE tbl_ventas SET nom_ventas = 'cambiado' WHERE id_ventas = 4");
            
        } catch (SQLException ex) {
            Logger.getLogger(VentasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VentasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(VentasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(VentasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ventas;
    //}
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void delete(Ventas ventas) {
       Connection conn = null;
         Statement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRUEBA;create=false;user=prueba;password=prueba");
           // 3. actualizar ventaso en la base de datos
            stmt = conn.createStatement();
            stmt.execute("DELETE FROM tbl_ventas WHERE id_ventas = 4");
                      
        } catch (SQLException ex) {
            Logger.getLogger(VentasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VentasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(VentasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(VentasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Ventas findById(Integer ventasId) {
        Ventas ventaso=null;
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRUEBA;create=false;user=prueba;password=prueba");
            String updateTableSQL = "Select * FROM tbl_ventas WHERE id_ventas = ?";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar ventaso en la base de datos
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            //preparedStatement.setString(1, 1);
            preparedStatement.setInt(1, 2);
// execute insert SQL stetement
            rs=preparedStatement.executeQuery();
            while (rs.next())
            {
            ventaso=new Ventas();
         
            int idventas=rs.getInt("id_ventas");
             
            String nombre=rs.getString("nom_ventas");
               
            ventaso.setVentasId(idventas);
             System.out.println(idventas);
            ventaso.setName(nombre);
             System.out.println(nombre);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VentasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VentasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(VentasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(VentasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(VentasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ventaso;
    }
    
    public List<Ventas> findAll() {
        Ventas ventaso=null;
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement stmt = null;
            List<Ventas> ventasos = new ArrayList<Ventas>();

        try {
            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRUEBA;create=false;user=prueba;password=prueba");
            String updateTableSQL = "Select * FROM tbl_ventas";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar ventaso en la base de datos
            
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            preparedStatement.executeQuery();
            rs=preparedStatement.executeQuery();
            while (rs.next())
            {
            ventaso=new Ventas();
            ventaso.setVentasId(rs.getInt("id_ventas"));
            ventaso.setName(rs.getString("nom_ventas"));
            ventasos.add(ventaso);
         
            int idventas=rs.getInt("id_ventas");
             
            String nombre=rs.getString("nom_ventas");
              ventaso.setName(nombre);   
            ventaso.setVentasId(idventas);
             System.out.println(idventas+" "+nombre);
                 
            }
            //stmt.executeUpdate("INSERT INTO tbl_ventas VALUES(" + ventas.getVentasId() + ",'" + ventas.getName() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(VentasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VentasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
             try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(VentasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(VentasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(VentasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ventasos;
    }
}