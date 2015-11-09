package com.john.task;

import com.john.entity.Sentence;
import com.john.entity.Text;
import com.john.task.comporator.NumberOfWords;

import java.util.List;

/**
 * Вывести все предложения заданного текста
 * в порядке возрастания количества слов в каждом из них.
 */
public class Task2 {
    public List<Sentence> run (Text text) {
        List<Sentence> result = text.getSentences();
        result.sort(new NumberOfWords());
        return result;
    }
}
