package com.xmlup.db.connection;

import com.xmlup.xml.model.Body;
import com.xmlup.xml.model.ContentObject;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class DatabaseConnection {

    private final String CONNECTION_URL;
    private final String USERNAME;
    private final String PASSWORD;


    /**
     * Connection by .properties file (file must be located in current package com.xmlup.db.connection)
     *
     * @param propertiesName name of properties file in format 'name.properties' without way.
     */
    public DatabaseConnection(String propertiesName) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/java/com/xmlup/db/connection/" + propertiesName));
            CONNECTION_URL = properties.getProperty("CONNECTION_URL");
            USERNAME = properties.getProperty("USERNAME");
            PASSWORD = properties.getProperty("PASSWORD");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void fillFromXML(Body body) {
        try (Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            System.out.println("Success connection to " + this);

            createTableAndFillItWithBodyData(body, connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createTableAndFillItWithBodyData(Body body, Connection connection) throws SQLException {
        String tableName = body.getTitle();
        List<ContentObject> content = body.getContent();
        ContentObject contentObjectExample = content.get(0);

        Statement statement = connection.createStatement();

        // CREATE TABLE IF NOT EXISTS
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + tableName + " " + contentObjectExample.TABLE_CONFIG());

        // INSERT INTO table
        StringBuilder insertStatement = new StringBuilder("INSERT IGNORE INTO " + tableName + contentObjectExample.TABLE_COLUMNS() + " VALUES ");
        for (ContentObject o : content) {
            insertStatement.append(o.INSERT()).append(",");
        }
        statement.executeUpdate(insertStatement.toString().replaceAll(".$", ""));
    }

    @Override
    public String toString() {
        return "DatabaseConnection{" +
                "CONNECTION_URL='" + CONNECTION_URL + '\'' +
                ", USERNAME='" + USERNAME + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                '}';
    }

}
