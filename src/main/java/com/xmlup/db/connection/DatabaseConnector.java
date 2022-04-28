package com.xmlup.db.connection;

import com.xmlup.xml.model.Body;
import com.xmlup.xml.model.ContentObject;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class DatabaseConnector {

    private final String CONNECTION_URL;
    private final String USERNAME;
    private final String PASSWORD;


    /**
     * Connection by String parameters
     */
    public DatabaseConnector(String connectionUrl, String username, String password) {
        CONNECTION_URL = connectionUrl;
        USERNAME = username;
        PASSWORD = password;
    }

    /**
     * Connection by .properties file (file must be located in current package com.xmlup.db.connection)
     *
     * @param propertiesName only name of the file without way to it.
     */
    public DatabaseConnector(String propertiesName) {
        Properties props = new Properties();
        String packagePath = "src/main/java/" +
                this.getClass().getPackage().toString().replace("package ", "")
                        .replaceAll("\\.", "/") + "/";
        try {
            props.load(new FileReader(packagePath + propertiesName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        CONNECTION_URL = props.getProperty("CONNECTION_URL");
        USERNAME = props.getProperty("USERNAME");
        PASSWORD = props.getProperty("PASSWORD");
    }

    public void fillTableWithData(Body body) {
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
