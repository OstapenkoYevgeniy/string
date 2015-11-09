package com.john.task.comporator;

import com.john.entity.Word;

import java.util.Comparator;

public class Alphabetically implements Comparator<Word> {
    @Override
    public int compare(Word wordOne, Word wordTwo) {
        return Character.compare(wordOne.getFirstLetter(), wordTwo.getFirstLetter());
    }
}
