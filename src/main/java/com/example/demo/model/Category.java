package com.example.demo.model;

import java.sql.Timestamp;

public class Category {

    private Long id;
    private String cateName;
    private Timestamp date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", cateName='" + cateName + '\'' +
                ", date=" + date +
                '}';
    }
}
