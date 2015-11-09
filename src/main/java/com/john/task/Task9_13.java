package com.john.task;

import com.john.entity.Text;
import com.john.entity.Word;
import com.john.task.comporator.NumberOfLetters;

import java.util.List;

/**
 * 9. Все слова текста рассортировать по возрастанию количества заданной буквы в слове.
 * Слова с одинаковым коли¬чеством расположить в алфавитном порядке.
 * 13. Отсортировать слова в тексте по убыванию количества вхождений заданного символа,
 * а в случае равенства – по алфавиту.
 */
public class Task9_13 {
    private final boolean UP = true;
    private final boolean DOWN = false;

    private boolean direction = UP;
    private char letter;

    public Task9_13(char letter) {
        this.letter = letter;
    }

    public List<Word> run(Text text) {
        List<Word> result = text.getWords();
        if (direction) {
            result.sort(new NumberOfLetters(Character.toString(letter)));
        } else {
            result.sort(new NumberOfLetters(Character.toString(letter)).reversed());
        }
        return result;
    }

    public void setUpDirection() {
        direction = UP;
    }

    public void setDownDirection() {
        direction = DOWN;
    }
}
