package com.xmlup.xml.parser;

import com.xmlup.xml.model.Body;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class XMLParser {

    public Body parse(String filepath, FrogHandler handler) {
        File file = new File(filepath);

        SAXParserFactory factory = SAXParserFactory.newInstance();
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
