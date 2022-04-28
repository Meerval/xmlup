package com.xmlup;

import com.xmlup.db.connection.DatabaseConnector;
import com.xmlup.xml.model.Body;
import com.xmlup.xml.parser.FrogHandler;
import com.xmlup.xml.parser.XMLParser;

public class Main {

    public static void main(String[] args) {

        FrogHandler handler = new FrogHandler();
        Body body = new XMLParser().parse("src/main/resources/test.xml", handler);

        DatabaseConnector connection = new DatabaseConnector("MySQL.properties");
        connection.fillTableWithData(body);

    }
}

