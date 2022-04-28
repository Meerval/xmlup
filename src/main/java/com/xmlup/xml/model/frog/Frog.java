package com.xmlup.xml.model.frog;

import com.xmlup.xml.model.ContentObject;

public class Frog implements ContentObject {
    private int id;
    private String guid;
    private String color;
    private double weight;

    public int getId() {
        return id;
    }

    public String getGuid() {
        return guid;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public Frog setId(String id) {
        this.id = Integer.parseInt(id);
        return this;
    }

    public Frog setGuid(String guid) {
        this.guid = guid;
        return this;
    }

    public Frog setColor(String color) {
        this.color = color;
        return this;
    }

    public Frog setWeight(String weight) {
        this.weight = Double.parseDouble(weight.replace(",", "."));
        return this;
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

    @Override
    public String INSERT() {
        return "('" + guid + "', '" + color + "', " + weight + ")";
    }

    @Override
    public String TABLE_CONFIG() {
        return "(" +
                "id MEDIUMINT NOT NULL AUTO_INCREMENT, " +
                "guid VARCHAR(50) NOT NULL UNIQUE, " +
                "color VARCHAR(15), " +
                "weight FLOAT, " +
                "PRIMARY KEY (id))";
    }

    @Override
    public String TABLE_COLUMNS() {
        return "(guid, color, weight)";
    }

    public enum Tag{

        DEFAULT("not_defined_tag"),
        TITLE("title"),
        FROG("frog"),
        ID("id"),
        GUID("GUID"),
        COLOR("color"),
        WEIGHT("weight");

        private final String XML_TAG;

        Tag(String xmlTag) {
            this.XML_TAG = xmlTag;
        }

        @Override
        public String toString() {
            return XML_TAG;
        }
        public static Tag getByQName(String xmlTag) {
            for (Tag tag : values()) {
                if (tag.toString().equals(xmlTag)) {
                    return tag;
                }
            }
            return DEFAULT;
        }

    }

}
