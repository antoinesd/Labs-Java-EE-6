package org.beginningee6.tutorial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 * @author Alexis Hassler - http://www.alexis-hassler.com
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
            
            clearTags(connection);

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
        final PreparedStatement statement = connection.prepareStatement("DELETE FROM book");
        statement.executeUpdate();
    }
    private void createBooks(Connection connection) throws SQLException {
        final PreparedStatement statement = connection.prepareStatement("INSERT INTO book (id, title) values (?, ?)");
        
        for (int id = 1; id <= NUM_BOOKS; id++) {
            statement.setInt(1, id);
            statement.setString(2, "title " + id);
            statement.addBatch();
        }
        
        statement.executeBatch();
    }
    

    private void clearCDs(final Connection connection) throws SQLException {
        final PreparedStatement statement = connection.prepareStatement("DELETE FROM cd");
        statement.executeUpdate();
    }
    private void createCDs(Connection connection) throws SQLException {
        final PreparedStatement statement = connection.prepareStatement("INSERT INTO cd (id, title) values (?, ?)");
        
        for (int id = 1; id <= NUM_CDS; id++) {
            statement.setInt(1, id);
            statement.setString(2, "title " + id);
            statement.addBatch();
        }
        
        statement.executeBatch();
    }

    private void clearTags(Connection connection) throws SQLException {
        final PreparedStatement statement = connection.prepareStatement("DELETE FROM tags");
        statement.executeUpdate();        
    }
}
