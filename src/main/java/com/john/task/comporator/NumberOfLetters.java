package com.john.task.comporator;

import com.john.entity.Word;

import java.util.Comparator;

public class NumberOfLetters implements Comparator<Word> {
    private String searchForLetter;

    public NumberOfLetters(String searchForLetter) {
        this.searchForLetter = searchForLetter;
    }

    @Override
    public int compare(Word wordOne, Word wordTwo) {
        if (wordOne.getNumberLetter(searchForLetter) < wordTwo.getNumberLetter(searchForLetter)) {
            return 1;
        } else if (wordOne.getNumberLetter(searchForLetter) > wordTwo.getNumberLetter(searchForLetter)) {
            return -1;
        } else {
            return Character.compare(wordOne.getFirstConsonant(), wordTwo.getFirstConsonant());
        }
    }
}
