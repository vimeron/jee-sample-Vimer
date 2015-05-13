package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.UsuarioDao;
import edu.uan.fis.jeesample.dto.Usuario;
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
 * Usuario DAO implementation using JDBC
 */
public class UsuarioDaoJdbc implements UsuarioDao {
    
    public Usuario create(Usuario usuario) {
        // Sample code
        Connection conn = null;
         Statement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRUEBA;create=false;user=prueba;password=prueba");
            // 3. Creates the usuario in the database
           stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO tbl_usuario (id_usuario, nom_usuario) VALUES(" + usuario.getUsuarioId() + ",'" + usuario.getName() + "')");
       } catch (SQLException ex) {
            Logger.getLogger(UsuarioDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
            stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuario;
    }
    
    public Usuario update(Usuario usuario) {
        
         Connection conn = null;
         Statement stmt = null;
        try {            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRUEBA;create=false;user=prueba;password=prueba");
            // 3. actualizar usuarioo en la base de datos
            stmt = conn.createStatement();
            stmt.execute("UPDATE tbl_usuario SET nom_usuario = 'cambiado' WHERE id_usuario = 4");
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuario;
    //}
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void delete(Usuario usuario) {
       Connection conn = null;
         Statement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRUEBA;create=false;user=prueba;password=prueba");
           // 3. actualizar usuarioo en la base de datos
            stmt = conn.createStatement();
            stmt.execute("DELETE FROM tbl_usuario WHERE id_usuario = 4");
                      
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Usuario findById(Integer usuarioId) {
        Usuario usuarioo=null;
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRUEBA;create=false;user=prueba;password=prueba");
            String updateTableSQL = "Select * FROM tbl_usuario WHERE id_usuario = ?";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar usuarioo en la base de datos
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            //preparedStatement.setString(1, 1);
            preparedStatement.setInt(1, 2);
// execute insert SQL stetement
            rs=preparedStatement.executeQuery();
            while (rs.next())
            {
            usuarioo=new Usuario();
         
            int idusuario=rs.getInt("id_usuario");
             
            String nombre=rs.getString("nom_usuario");
               
            usuarioo.setUsuarioId(idusuario);
             System.out.println(idusuario);
            usuarioo.setName(nombre);
             System.out.println(nombre);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuarioo;
    }
    
    public List<Usuario> findAll() {
        Usuario usuarioo=null;
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement stmt = null;
            List<Usuario> usuarioos = new ArrayList<Usuario>();

        try {
            // 1. Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRUEBA;create=false;user=prueba;password=prueba");
            String updateTableSQL = "Select * FROM tbl_usuario";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar usuarioo en la base de datos
            
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            preparedStatement.executeQuery();
            rs=preparedStatement.executeQuery();
            while (rs.next())
            {
            usuarioo=new Usuario();
            usuarioo.setUsuarioId(rs.getInt("id_usuario"));
            usuarioo.setName(rs.getString("nom_usuario"));
            usuarioos.add(usuarioo);
         
            int idusuario=rs.getInt("id_usuario");
             
            String nombre=rs.getString("nom_usuario");
              usuarioo.setName(nombre);   
            usuarioo.setUsuarioId(idusuario);
             System.out.println(idusuario+" "+nombre);
                 
            }
            //stmt.executeUpdate("INSERT INTO tbl_usuario VALUES(" + usuario.getUsuarioId() + ",'" + usuario.getName() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
             try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuarioos;
    }
}