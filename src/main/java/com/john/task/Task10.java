package com.john.task;

import com.john.entity.Text;
import com.john.entity.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Существует текст и список слов. Для каждого слова из заданного списка найти,
 * сколько раз оно встречается в каждом предложении, и рассортировать слова по убыванию общего количества вхождений.
 */
public class Task10 {
    private List<String> strings;

    public Task10(List<String> strings) {
        this.strings = strings;
    }

    public List<Word> run(Text text) {
        List<Word> result = new ArrayList<>();
        List<WordForSort> wordForSorts = strings.stream()
                .map(string -> new WordForSort(string, numberMatches(text, string))).collect(Collectors.toList());

        wordForSorts.sort((wordOne, wordTwo) -> wordTwo.numberMatches.compareTo(wordOne.numberMatches));

        result.addAll(wordForSorts.stream()
                .map(wordForSort -> new Word(wordForSort.word)).collect(Collectors.toList()));

        return result;
    }

    /**
     * Количество совпадений слова в тектсе
     */
    private Integer numberMatches(Text text, String checkWord) {
        List<Word> words = text.getWords();
        int counter = 0;
        for (Word word : words) {
            if (word.toSourceString().equalsIgnoreCase(checkWord)) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Класс для хранения слова и количества его совпадений в слове
     */
    private class WordForSort {
        public String word;
        public Integer numberMatches;

        public WordForSort(String word, Integer numberMatches) {
            this.word = word;
            this.numberMatches = numberMatches;
        }
    }
}


