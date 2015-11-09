package com.john.entity;

import java.util.List;
import java.util.stream.Collectors;

public class Sentence extends AbstractComposit<SentenceComponent> {

    /**
     * Получить все предложения
     */
    public List<Word> getWords() {
        List<Word> result = this.getComponents().stream().filter(word -> word instanceof Word)
                .map(word -> (Word) word).collect(Collectors.toList());
        return result;
    }

    /**
     * Получить количество слов в предложении
     */
    public int getNumberWords() {
        return this.getWords().size();
    }

    /**
     * Если предложение вопросительное, то true
     */
    public boolean isInterrogative() {
        List<Punctuation> punktuations = this.getComponents().stream()
                .filter(component -> component instanceof Punctuation)
                .map(component -> (Punctuation) component).collect(Collectors.toList());

        if (punktuations.get(punktuations.size() - 1).toSourceString().equals("?")) {
            return true;
        }
        return false;
    }

    /**
     * Если есть одинаковые слова, то true
     */
    public boolean isSameWords() {
        List<Word> words = this.getWords();
        for (int countOne = 0; countOne < words.size(); countOne++) {
            for (int countTwo = 0; countTwo < words.size(); countTwo++) {
                if (countOne != countTwo) {
                    if (words.get(countOne).equalsIgnoreCase(words.get(countTwo))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Проверка на то, есть ли передаваемое слово в предложении или нет
     */
    public boolean isThereWord(Word word) {
        for (Word thisWord : this.getWords()) {
            if (thisWord.equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }
}
