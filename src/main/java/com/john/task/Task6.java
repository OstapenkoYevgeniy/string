package com.john.task;

import com.john.entity.Text;
import com.john.entity.Word;
import com.john.task.comporator.Alphabetically;

import java.util.List;

/**
 * Напечатать слова текста в алфавитном порядке по первой букве.
 * Слова, начинающиеся с новой буквы, печатать с красной строки.
 */
public class Task6 {
    public void run(Text text) {
        List<Word> result = text.getWords();
        result.sort(new Alphabetically());
        printAccordingToTask(result);
    }

    /**
     * Вывести на экран согласно условию задачи.
     */
    public void printAccordingToTask(List<Word> words) {
        char tmpLetter = ' ';
        for (Word word : words) {
            char firstLetter = word.toSourceString().toLowerCase().charAt(0);
            // Если новая буква, то вывести с красной строки
            // Переменной 'tmpLetter' присвоить новую букву
            if (tmpLetter != firstLetter) {
                tmpLetter = firstLetter;
                System.out.println("  " + word.toSourceString());
            } else {
                System.out.println(word.toSourceString());
            }
        }
    }
}
