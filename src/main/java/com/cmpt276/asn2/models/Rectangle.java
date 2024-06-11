package com.cmpt276.asn2.models;

import jakarta.persistence.*;

@Entity
@Table(name="rectangles")
public class Rectangle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rid;
    private String name;
    private int width;
    private int height;
    private String color;

    public Rectangle() {
    }
    
    public Rectangle(String name, int width, int height, String color) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
