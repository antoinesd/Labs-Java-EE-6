package org.beginningee6.tutorial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;

import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author Alexis Hassler
 */
@Stateless
public class DBInit {
    public static final int NUM_BOOKS = 3;
    public static final int NUM_CDS = 1;
    
    @Resource(mappedName="jdbc/sample")
    DataSource ds;
    
    @PostConstruct
    public void initDatabase() {
        System.out.println("=> Initializing database");        
        Connection connection = null;
        try {
            connection = ds.getConnection();
            clearBooks(connection);
            createBooks(connection);
            
            clearCDs(connection);
            createCDs(connection);
            
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    Logger.getLogger(DBInit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Database initiaziation failed");
            for (Throwable ex : e) {
                System.out.println("=> " + ex);
            }
        }
    }

    private void clearBooks(final Connection connection) throws SQLException {
        final PreparedStatement deleteBookStatement = connection.prepareStatement("DELETE FROM book");
        deleteBookStatement.executeUpdate();
    }
    private void createBooks(Connection connection) throws SQLException {
        final PreparedStatement createBookStatement = connection.prepareStatement("INSERT INTO book (id, title) values (?, ?)");
        
        for (int id = 1; id <= NUM_BOOKS; id++) {
            createBookStatement.setInt(1, id);
            createBookStatement.setString(2, "title " + id);
            createBookStatement.addBatch();
        }
        
        createBookStatement.executeBatch();
    }
    

    private void clearCDs(final Connection connection) throws SQLException {
        final PreparedStatement deleteCDStatement = connection.prepareStatement("DELETE FROM cd");
        deleteCDStatement.executeUpdate();
    }
    private void createCDs(Connection connection) throws SQLException {
        final PreparedStatement createBookStatement = connection.prepareStatement("INSERT INTO cd (id, title) values (?, ?)");
        
        for (int id = 1; id <= NUM_CDS; id++) {
            createBookStatement.setInt(1, id);
            createBookStatement.setString(2, "title " + id);
            createBookStatement.addBatch();
        }
        
        createBookStatement.executeBatch();
    }
}
