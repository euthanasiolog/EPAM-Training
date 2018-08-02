package com.epam.training.task2.model.entity.composite;

public class Leaf implements Component {
    //field
    private String content;

    public Leaf(){

    }

    public Leaf(String content) {
        this.content = content;
    }

    //getters and setters
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String print() {
        return toString();
    }

    @Override
    public String toString() {
        return content;
    }
}
