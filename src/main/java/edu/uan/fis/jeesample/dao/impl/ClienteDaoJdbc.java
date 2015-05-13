package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.ClienteDao;
import edu.uan.fis.jeesample.dto.Cliente;
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
 * Cliente DAO implementation using JDBC
 */
public class ClienteDaoJdbc implements ClienteDao {
    
    public Cliente create(Cliente cliente) {
        // Sample code
        Connection conn = null;
         Statement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRUEBA;create=false;user=prueba;password=prueba");
            // 3. Creates the cliente in the database
           stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO tbl_cliente (id_cliente, nom_cliente) VALUES(" + cliente.getClienteId() + ",'" + cliente.getName() + "')");
       } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
            stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cliente;
    }
    
    public Cliente update(Cliente cliente) {
        
         Connection conn = null;
         Statement stmt = null;
        try {            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRUEBA;create=false;user=prueba;password=prueba");
            // 3. actualizar clienteo en la base de datos
            stmt = conn.createStatement();
            stmt.execute("UPDATE tbl_cliente SET nom_cliente = 'cambiado' WHERE id_cliente = 4");
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cliente;
    //}
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void delete(Cliente cliente) {
       Connection conn = null;
         Statement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRUEBA;create=false;user=prueba;password=prueba");
           // 3. actualizar clienteo en la base de datos
            stmt = conn.createStatement();
            stmt.execute("DELETE FROM tbl_cliente WHERE id_cliente = 4");
                      
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Cliente findById(Integer clienteId) {
        Cliente clienteo=null;
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRUEBA;create=false;user=prueba;password=prueba");
            String updateTableSQL = "Select * FROM tbl_cliente WHERE id_cliente = ?";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar clienteo en la base de datos
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            //preparedStatement.setString(1, 1);
            preparedStatement.setInt(1, 2);
// execute insert SQL stetement
            rs=preparedStatement.executeQuery();
            while (rs.next())
            {
            clienteo=new Cliente();
         
            int idcliente=rs.getInt("id_cliente");
             
            String nombre=rs.getString("nom_cliente");
               
            clienteo.setClienteId(idcliente);
             System.out.println(idcliente);
            clienteo.setName(nombre);
             System.out.println(nombre);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return clienteo;
    }
    
    public List<Cliente> findAll() {
        Cliente clienteo=null;
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement stmt = null;
            List<Cliente> clienteos = new ArrayList<Cliente>();

        try {
            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRUEBA;create=false;user=prueba;password=prueba");
            String updateTableSQL = "Select * FROM tbl_cliente";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar clienteo en la base de datos
            
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            preparedStatement.executeQuery();
            rs=preparedStatement.executeQuery();
            while (rs.next())
            {
            clienteo=new Cliente();
            clienteo.setClienteId(rs.getInt("id_cliente"));
            clienteo.setName(rs.getString("nom_cliente"));
            clienteos.add(clienteo);
         
            int idcliente=rs.getInt("id_cliente");
             
            String nombre=rs.getString("nom_cliente");
              clienteo.setName(nombre);   
            clienteo.setClienteId(idcliente);
             System.out.println(idcliente+" "+nombre);
                 
            }
            //stmt.executeUpdate("INSERT INTO tbl_cliente VALUES(" + cliente.getClienteId() + ",'" + cliente.getName() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
             try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return clienteos;
    }
}