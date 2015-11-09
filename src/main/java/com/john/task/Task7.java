package com.john.task;

import com.john.entity.Text;
import com.john.entity.Word;
import com.john.task.comporator.RatioVowel;

import java.util.List;

/**
 * Рассортировать слова текста по возрастанию доли гласных букв
 * (отношение количества гласных к общему количеству букв в слове).
 */
public class Task7 {
    public List<Word> run(Text text) {
        List<Word> result = text.getWords();
        result.sort(new RatioVowel());
        return result;
    }
}
