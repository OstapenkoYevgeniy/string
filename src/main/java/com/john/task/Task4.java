package com.john.task;

import com.john.entity.Sentence;
import com.john.entity.Text;
import com.john.entity.Word;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Во всех вопросительных предложениях текста найти и напеча¬тать без повторений слова заданной длины.
 */
public class Task4 {
    public Set<Word> run(Text text, int min, int max) {
        Set<Word> result = new HashSet<>();
        List<Sentence> sentences = text.getSentences();

        List<Sentence> interrogativeSentence = sentences.stream()
                .filter(sentence -> sentence.isInterrogative()).collect(Collectors.toList());

        for (Sentence sentence : interrogativeSentence) {
            result.addAll(sentence.getWords().stream()
                    .map(Word::toLowerCase).collect(Collectors.toList()));
        }

        Iterator<Word> iterator = result.iterator();
        while (iterator.hasNext()) {
            int wordLength = iterator.next().toSourceString().length();

            if (!(wordLength >= min && wordLength <= max)) {
                iterator.remove();
            }
        }
        return result;
    }
}
