package com.john.task;

import com.john.entity.Sentence;
import com.john.entity.Text;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Найти наибольшее количество предложений текста, в которых есть одинаковые слова.
 */
public class Task1 {
    public List<Sentence> run(Text text) {
        List<Sentence> allSentences = text.getSentences();
        List<Sentence> result = allSentences.stream()
                .filter(sentence -> sentence.isSameWords()).collect(Collectors.toList());
        return result;
    }
}
