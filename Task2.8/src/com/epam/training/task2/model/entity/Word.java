package com.epam.training.task2.model.entity;

/**
 * Word is the class-entity which has information about words:
 * content(String)
 * firstConsonantLetter(char)
 * isFirstLetterVowel(boolean)
 *
 * It implements Comparable<Word> to compare words with first vowel letter by first consonant letter.
 *
 * 16 July 2018
 * @author Arthur Lyup
 */

import java.util.Objects;

public class Word implements Comparable<Word> {
    //fields
    private String content;
    private char firstConsonantLetter;

    //constant values
    //line of vowels
    private static String vowels = "aeyuoi";

    //the empty constructor
    public Word(){}

    //the constructor with arg (content)
    public Word(String content){
        this.content = content;
        char firstLetter = Character.toLowerCase(content.charAt(0));
        if (vowels.contains(Character.toString(firstLetter))) {
            setFirstConsonantLetter(findFirstConsonantLetter(content));
        }
    }

    //searching first consonant letter in word
    private static char findFirstConsonantLetter(String content){
        int length = content.length();
        for (int i = 1; i < length; i++){
            if (!vowels.contains(Character.toString(content.charAt(i)))){
                return Character.toLowerCase(content.charAt(i));
            }
        }
        return '\u0000';
    }

    //constructor with args
    public Word(String content, char firstConsonantLetter) {
        this.content = content;
        this.firstConsonantLetter = firstConsonantLetter;
    }

    //getters and setters
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public char getFirstConsonantLetter() {
        return firstConsonantLetter;
    }

    public void setFirstConsonantLetter(char firstConsonantLetter) {
        this.firstConsonantLetter = firstConsonantLetter;
    }

    ///////////////////////////////////////////////////////////////////

    //compares words with first vowel letter by first consonant letter
    @Override
    public int compareTo(Word word) {
        return firstConsonantLetter < word.firstConsonantLetter ? -1 : 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word = (Word) o;
        return getFirstConsonantLetter() == word.getFirstConsonantLetter() &&
                Objects.equals(getContent(), word.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContent(), getFirstConsonantLetter());
    }

    @Override
    public String toString() {
        return content;
    }
}
