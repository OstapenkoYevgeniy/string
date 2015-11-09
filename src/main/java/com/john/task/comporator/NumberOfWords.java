package com.john.task.comporator;

import com.john.entity.Sentence;

import java.util.Comparator;

public class NumberOfWords implements Comparator<Sentence> {
    @Override
    public int compare(Sentence sentenceOne, Sentence sentenceTwo) {
        return Integer.compare(sentenceOne.getNumberWords(), sentenceTwo.getNumberWords());
    }
}
