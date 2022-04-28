package com.xmlup.xml.parser;

import com.xmlup.xml.model.Body;
import com.xmlup.xml.model.ContentObject;
import com.xmlup.xml.model.frog.Frog;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import static com.xmlup.xml.model.frog.Frog.Tag.*;


public class FrogHandler extends DefaultHandler {

    private final Body body = new Body();
    private final List<ContentObject> content = new ArrayList<>(15000);

    private Frog.Tag currentTagName;
    private boolean isContentObject = false;
    private Frog frog;

    public Body getBody() {
        return body;
    }

    @Override
    public void endDocument() {
        body.setContent(content);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentTagName = Frog.Tag.getByQName(qName);
        if (currentTagName.equals(FROG)) {
            isContentObject = true;
            frog = new Frog();
            frog.setId(attributes.getValue(ID.toString()));
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals(FROG.toString())) {
            isContentObject = false;
            content.add(frog);
        }
        currentTagName = DEFAULT;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String text = new String(ch, start, length);

        if (currentTagName == null) {
            return;
        }

        if (currentTagName.equals(TITLE)) {
            body.setTitle(text);
        }

        if (isContentObject) {
            switch (currentTagName) {
                case GUID:
                    frog.setGuid(text);
                    break;
                case COLOR:
                    frog.setColor(text);
                    break;
                case WEIGHT:
                    frog.setWeight(text);
                    break;
            }
        }

    }


}
