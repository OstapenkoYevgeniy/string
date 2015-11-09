package com.john.task.comporator;

import com.john.entity.Word;

import java.util.Comparator;

public class RatioVowel implements Comparator<Word> {
    @Override
    public int compare(Word wordOne, Word wordTwo) {
        return Float.compare(wordOne.getRatioVowel(), wordTwo.getRatioVowel());
    }
}
