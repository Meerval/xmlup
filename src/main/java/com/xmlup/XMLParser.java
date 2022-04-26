package com.xmlup;

import com.xmlup.xml.model.Body;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class XMLParser {

    private final String filepath = "src/main/resources/test.xml";

    public Body parse() {
        File file = new File(filepath);

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParserHandler handler = new SAXParserHandler();
        SAXParser parser;
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            throw new RuntimeException("Open SAX parser error " + e);
        }


        try {
            parser.parse(file, handler);
        } catch (SAXException e) {
            throw new RuntimeException("SAX parsing error " + e);
        } catch (IOException e) {
            throw new RuntimeException("IO parsing error " + e);
        }

        return handler.getBody();
    }
}
