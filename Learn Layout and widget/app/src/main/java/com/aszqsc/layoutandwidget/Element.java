package com.aszqsc.layoutandwidget;

public class Element {
    private String Elename;
    private String description;
    private int imgName;
    private String color;

    public String getElename() {
        return Elename;
    }

    public void setElename(String elename) {
        Elename = elename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImgName() {
        return imgName;
    }

    public void setImgName(int imgName) {
        this.imgName = imgName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Element(String elename, String description, int imgName, String color) {
        Elename = elename;
        this.description = description;
        this.imgName = imgName;
        this.color = color;
    }
}
