package com.xmlup;

import com.xmlup.db.connection.DatabaseConnection;
import com.xmlup.db.parameters.DatabaseParameters;
import com.xmlup.xml.model.Body;
import com.xmlup.xml.model.ContentObject;
import com.xmlup.xml.model.Frog;

import java.io.IOException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {

        XMLParser saxParser= new XMLParser();
        Body body = saxParser.parse();


        DatabaseParameters db = new DatabaseParameters("jdbc:mysql://localhost:3306/testme", "root", "root");
//        DatabaseParameters db2 = new DatabaseParameters("jdbc:postgresql://localhost:5432/testme", "postgres", "postgres");

        DatabaseConnection connection = new DatabaseConnection(db);
        connection.fullDatabase(body);



//        File file = new File(filepath);
//        System.out.println(file.length());
//        long start = System.currentTimeMillis();
//        Files.lines(Paths.get(filepath)).filter(str -> str.contains("<")).forEach(System.out::println);
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);

//        File file = new File(filepath);



    }
}

