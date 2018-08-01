package com.epam.training.task2.model.entity.composite;

import org.apache.log4j.Logger;

public class Leaf implements Component {
    //field
    private String content;
    //logging information
    private static final Logger LOG = Logger.getLogger(Leaf.class);

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
    public void addComponent(Component component) {
        LOG.error("Error! Operation of adding isn't supported for words");
    }

    @Override
    public String toString() {
        return "content=" + content;
    }
}
