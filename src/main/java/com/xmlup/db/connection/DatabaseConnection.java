package com.xmlup.db.connection;

import com.xmlup.db.parameters.DatabaseParameters;
import com.xmlup.xml.model.Body;
import com.xmlup.xml.model.ContentObject;
import com.xmlup.xml.model.Frog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DatabaseConnection {

    private final DatabaseParameters databaseParameters;

    DatabaseConnection(String connectionUrl, String username, String password) {
        databaseParameters = new DatabaseParameters(connectionUrl, username, password);
    }

    public DatabaseConnection(DatabaseParameters sqlConnectionData) {
        this.databaseParameters = new DatabaseParameters(
                sqlConnectionData.getConnectionUrl(),
                sqlConnectionData.getUsername(),
                sqlConnectionData.getPassword()
        );
    }

    public void fullDatabase(Body body) {
        String tableName = body.getTitle();
        List<ContentObject> content = body.getContent();

        try (Connection connection = DriverManager.getConnection(
                databaseParameters.getConnectionUrl(),
                databaseParameters.getUsername(),
                databaseParameters.getPassword()
        )) {
            System.out.println("Success connection to " + databaseParameters);
            Statement statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                    "id MEDIUMINT NOT NULL AUTO_INCREMENT, " +
                    "guid VARCHAR(50) NOT NULL UNIQUE, " +
                    "color VARCHAR(15), " +
                    "weight FLOAT, " +
                    "PRIMARY KEY (id))");
            for (ContentObject o : content) {
                System.out.println(o);
                statement.executeUpdate("INSERT IGNORE INTO " + tableName + "(guid, color, weight) " +
                        "VALUES ('" + ((Frog) o).getGuid() + "', '" + ((Frog) o).getColor() + "', " + ((Frog) o).getWeight().replace(",",".") + ")");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
