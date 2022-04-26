package com.xmlup.xml.model;

public class Frog implements ContentObject{
    private String id;
    private String guid;
    private String color;
    private String weight;

    public Frog(String id, String guid, String color, String weight) {
        this.id = id;
        this.guid = guid;
        this.color = color;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public String getGuid() {
        return guid;
    }

    public String getColor() {
        return color;
    }

    public String getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Frog{" +
                "id=" + id +
                ", guid='" + guid + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

}
