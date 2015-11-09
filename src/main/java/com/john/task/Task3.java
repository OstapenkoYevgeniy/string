package com.john.task;

import com.john.entity.Sentence;
import com.john.entity.Text;
import com.john.entity.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Найти такое слово в первом предложении, которого нет ни в одном из остальных предложений.
 */
public class Task3 {
    public List<Word> run(Text text) {
        List<Word> result = new ArrayList<>();
        List<Word> otherWords = new ArrayList<>();

        List<Sentence> otherSentences = text.getSentences();
        Sentence firstSentence = otherSentences.get(0);
        otherSentences.remove(0);

        for (Sentence otherSentence : otherSentences) {
            otherWords.addAll(otherSentence.getWords());
        }

        boolean isThere;

        for (Word word : firstSentence.getWords()) {
            isThere = false;

            for (Word otherWord : otherWords) {
                if (word.equalsIgnoreCase(otherWord)) {
                    isThere = true;
                }
            }

            if (!isThere) {
                result.add(word);
            }
        }
        return result;
    }
}
