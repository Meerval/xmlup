package com.xmlup.db.connection;

import com.xmlup.Hooks;
import com.xmlup.db.parameters.DatabaseParameters;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest extends Hooks {

    @Test
    void connectWithDataclassTest() {
        DatabaseParameters databaseParameters = new DatabaseParameters(CONNECTION_URL, USERNAME, PASSWORD);
        DatabaseConnection connection = new DatabaseConnection(databaseParameters);
        assertNotNull(connection);
        Statement statement = connection.connect();
        assertNotNull(statement);
    }

    @Test
    void connectWithArgumentParametersTest() {
        DatabaseConnection connection = new DatabaseConnection(CONNECTION_URL, USERNAME, PASSWORD);
        assertNotNull(connection);
        Statement statement = connection.connect();
        assertNotNull(statement);
    }


}