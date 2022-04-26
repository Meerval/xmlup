package com.xmlup;

import com.xmlup.xml.model.Body;
import com.xmlup.xml.model.ContentObject;
import com.xmlup.xml.model.Frog;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXParserHandler extends DefaultHandler {

    Body body = new Body();
    List<ContentObject> frogs = new ArrayList<>();

    private String currentTagName;
    private boolean isFrog = false;
    private String frogID = "0";
    private String frogGUID = "00000000-0000-0000-0000-000000000000";
    private String frogColor = "EMPTY";
    private String frogWeight = "0";

    private static final String TAG_TITLE = "title";
    private final String TAG_CONTENT = "content";
    private final String TAG_FROG = "frog";
    private final String TAG_FROG_GUID = "GUID";
    private final String TAG_FROG_COLOR = "color";
    private final String TAG_FROG_weight = "weight";

    public Body getBody() {
        return body;
    }

    @Override
    public void endDocument() {
        body.setContent(frogs);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentTagName = qName;
        if (currentTagName.equals(TAG_FROG)) {
            isFrog = true;
            frogID = attributes.getValue("id");
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals(TAG_FROG)) {
            isFrog = false;
            Frog frog = new Frog(frogID, frogGUID, frogColor, frogWeight);
            frogs.add(frog);
        }
        currentTagName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String text = new String(ch, start, length);

        if (currentTagName == null) {
            return;
        }
        if (currentTagName.equals(TAG_TITLE)) {
            body.setTitle(text);
            System.out.println(body);
        }

        if(isFrog) {
            switch (currentTagName) {
                case TAG_FROG_GUID:
                    frogGUID = text;
                    break;
                case TAG_FROG_COLOR:
                    frogColor = text;
                    break;
                case TAG_FROG_weight:
                    frogWeight = text;
                    break;
            }
        }

    }
}
