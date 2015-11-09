package com.john.task;

import com.john.entity.Text;
import com.john.entity.Word;

/**
 * Преобразовать каждое слово в тексте, удалив из него все последующие (предыдущие) вхождения первой (последней) буквы этого слова.
 */
public class Task15 {

    public Text run(Text text) {
        for (Word word : text.getWords()) {
            Word prepareWord = prepare(word);
            word.clear();
            word.add(prepareWord);
        }
        return text;
    }

    /**
     * Удаление послеующих и предыдущих вхождений первой и последней буквы.
     */
    private Word prepare(Word word) {
        String string = word.toSourceString();

        String firstLetter = Character.toString(string.charAt(0));
        String lastLetter = Character.toString(string.charAt(string.length() - 1));

        string = string.replaceAll("(?i)(?U)" + firstLetter, "");
        string = string.replaceAll("(?i)(?U)" + lastLetter, "");

        return new Word(string);
    }
}
