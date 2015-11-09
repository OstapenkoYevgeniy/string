package com.john.task;

import com.john.entity.Sentence;
import com.john.entity.Text;

/**
 * Из текста удалить все слова заданной длины, начинающиеся на согласную букву.
 */
public class Task12 {
    private int min;
    private int max;

    public Task12(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public Text run(Text text) {
        for (Sentence sentence : text.getSentences()) {
            sentence.getWords().stream().filter(word -> word.isStartsConsonant()).forEach(word -> {
                int wordLength = word.toSourceString().length();
                if (min <= wordLength && max >= wordLength) {
                    sentence.remove(word);
                }
            });
        }
        return text;
    }
}
