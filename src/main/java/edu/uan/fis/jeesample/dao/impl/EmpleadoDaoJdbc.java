package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.EmpleadoDao;
import edu.uan.fis.jeesample.dto.Empleado;
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
 * Empleado DAO implementation using JDBC
 */
public class EmpleadoDaoJdbc implements EmpleadoDao {
    
    public Empleado create(Empleado empleado) {
        // Sample code
        Connection conn = null;
         Statement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRUEBA;create=false;user=prueba;password=prueba");
            // 3. Creates the empleado in the database
           stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO tbl_empleado (id_empleado, nom_empleado) VALUES(" + empleado.getEmpleadoId() + ",'" + empleado.getName() + "')");
       } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
            stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return empleado;
    }
    
    public Empleado update(Empleado empleado) {
        
         Connection conn = null;
         Statement stmt = null;
        try {            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRUEBA;create=false;user=prueba;password=prueba");
            // 3. actualizar empleadoo en la base de datos
            stmt = conn.createStatement();
            stmt.execute("UPDATE tbl_empleado SET nom_empleado = 'cambiado' WHERE id_empleado = 4");
            
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return empleado;
    //}
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void delete(Empleado empleado) {
       Connection conn = null;
         Statement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRUEBA;create=false;user=prueba;password=prueba");
           // 3. actualizar empleadoo en la base de datos
            stmt = conn.createStatement();
            stmt.execute("DELETE FROM tbl_empleado WHERE id_empleado = 4");
                      
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Empleado findById(Integer empleadoId) {
        Empleado empleadoo=null;
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRUEBA;create=false;user=prueba;password=prueba");
            String updateTableSQL = "Select * FROM tbl_empleado WHERE id_empleado = ?";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar empleadoo en la base de datos
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            //preparedStatement.setString(1, 1);
            preparedStatement.setInt(1, 2);
// execute insert SQL stetement
            rs=preparedStatement.executeQuery();
            while (rs.next())
            {
            empleadoo=new Empleado();
         
            int idempleado=rs.getInt("id_empleado");
             
            String nombre=rs.getString("nom_empleado");
               
            empleadoo.setEmpleadoId(idempleado);
             System.out.println(idempleado);
            empleadoo.setName(nombre);
             System.out.println(nombre);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return empleadoo;
    }
    
    public List<Empleado> findAll() {
        Empleado empleadoo=null;
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement stmt = null;
            List<Empleado> empleadoos = new ArrayList<Empleado>();

        try {
            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRUEBA;create=false;user=prueba;password=prueba");
            String updateTableSQL = "Select * FROM tbl_empleado";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar empleadoo en la base de datos
            
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            preparedStatement.executeQuery();
            rs=preparedStatement.executeQuery();
            while (rs.next())
            {
            empleadoo=new Empleado();
            empleadoo.setEmpleadoId(rs.getInt("id_empleado"));
            empleadoo.setName(rs.getString("nom_empleado"));
            empleadoos.add(empleadoo);
         
            int idempleado=rs.getInt("id_empleado");
             
            String nombre=rs.getString("nom_empleado");
              empleadoo.setName(nombre);   
            empleadoo.setEmpleadoId(idempleado);
             System.out.println(idempleado+" "+nombre);
                 
            }
            //stmt.executeUpdate("INSERT INTO tbl_empleado VALUES(" + empleado.getEmpleadoId() + ",'" + empleado.getName() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
             try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return empleadoos;
    }
}