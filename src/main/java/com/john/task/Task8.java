package com.john.task;

import com.john.entity.Text;
import com.john.entity.Word;
import com.john.task.comporator.FirstConsonant;

import java.util.Iterator;
import java.util.List;

/**
 * Слова текста, начинающиеся с гласных букв, рассортировать в алфавитном порядке по первой согласной букве слова.
 */
public class Task8 {
    public List<Word> run(Text text) {
        List<Word> result = text.getWords();

        Iterator<Word> iterator = result.iterator();
        Word word;
        while (iterator.hasNext()) {
            word = iterator.next();
            if (!word.isStartsVowel() || word.isAllVowels()) {
                iterator.remove();
            }
        }

        result.sort(new FirstConsonant());
        return result;
    }
}
