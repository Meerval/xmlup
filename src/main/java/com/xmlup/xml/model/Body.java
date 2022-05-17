package com.xmlup.xml.model;

import java.util.List;

public class Body {
    private String title;
    private List<ContentObject> content;

    public Body() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(List<ContentObject> content) {
        this.content = content;
    }

    public List<ContentObject> getContent() {
        return content;
    }


    @Override
    public String toString() {
        return "Body{" +
                "title='" + title + '\'' +
                ", content=" + content +
                '}';
    }
}
