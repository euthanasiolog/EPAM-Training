package com.epam.training.task2.model.entity.composite.leaf;

import com.epam.training.task2.model.entity.composite.Component;

public class Leaf implements Component {
    private String content;
    private Lexeme typeOfLexeme;

    public Leaf(){

    }

    public Leaf(String content, Lexeme typeOfLexeme) {
        this.content = content;
        this.typeOfLexeme = typeOfLexeme;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTypeOfLexeme() {
        return typeOfLexeme.toString();
    }

    public void setTypeOfLexeme(String typeOfLexeme) {
        /*typeOfLexeme = typeOfLexeme.toUpperCase();
        Lexeme[] lexemes = Lexeme.values();
        if (typeOfLexeme.)*/
    }

    public void printToFile() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return typeOfLexeme.toString() + "{" +
                "content='" + content +
                '}';
    }
}
