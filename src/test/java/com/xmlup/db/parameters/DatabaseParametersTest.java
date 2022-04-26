package com.xmlup.db.parameters;

import com.xmlup.Hooks;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DatabaseParametersTest extends Hooks {

    private final DatabaseParameters databaseParameters = new DatabaseParameters(CONNECTION_URL, USERNAME, PASSWORD);

    @Test
    void getUsernameTest() {
        assertEquals(databaseParameters.getUsername(), USERNAME);
    }

    @Test
    void getPasswordTest() {
        assertEquals(databaseParameters.getPassword(), PASSWORD);
    }

    @Test
    void getConnectionUrlTest() {
        assertEquals(databaseParameters.getConnectionUrl(), CONNECTION_URL);
    }
}