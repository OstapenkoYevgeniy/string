package com.john.task;

import com.john.entity.Text;
import com.john.entity.Word;

/**
 * В некотором предложении текста слова заданной длины заменить указанной подстрокой, длина которой может не совпадать с длиной слова.
 */
public class Task16 {
    private String substring;
    private int min;
    private int max;

    public Task16(String substring, int min, int max) {
        this.substring = substring;
        this.min = min;
        this.max = max;
    }

    public Text run(Text text) {
        for (Word word : text.getWords()) {
            int wordLength = word.toSourceString().length();
            if (min <= wordLength && max >= wordLength) {
                word.clear();
                word.add(new Word(substring));
            }
        }
        return text;
    }
}
