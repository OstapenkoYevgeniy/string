package com.john.entity;

import java.util.ArrayList;
import java.util.List;

public class Word extends AbstractComposit<Letter> implements SentenceComponent {

    public Word() {
    }

    public Word(String string) {
        List<Component> letters = new ArrayList<>();
        for (int count = 0; count < string.length(); count++) {
            letters.add(new Letter(string.charAt(count)));
        }
        this.setComponents(letters);
    }

    /**
     * Получить первую букву слова
     */
    public char getFirstLetter() {
        return this.toSourceString().charAt(0);
    }

    /**
     * Если слово на чинается на гласную букву, то true
     */
    public boolean isStartsVowel() {
        String letter = Character.toString(this.toSourceString().charAt(0));
        if (letter.toUpperCase().matches("[АЕЁИОУЫЭЮЯ]")) {
            return true;
        }
        return false;
    }

    /**
     * Если слово начинается на согласную букву, то true
     */
    public boolean isStartsConsonant() {
        String letter = Character.toString(this.toSourceString().charAt(0));
        if (letter.toUpperCase().matches("[БВГДЖЗЙКЛМНПРСТФХЦЧШЩ]")) {
            return true;
        }
        return false;
    }

    /**
     * Возвращает первую согласную букву в слове, если их нет то ' '
     */
    public char getFirstConsonant() {
        String strWord = this.toSourceString();
        for (int i = 0; i < strWord.length(); i++) {
            String letter = Character.toString(strWord.charAt(i));
            if (letter.toUpperCase().matches("[БВГДЖЗЙКЛМНПРСТФХЦЧШЩ]")) {
                return letter.charAt(0);
            }
        }
        return ' ';
    }

    /**
     * Возвращает количество передаваемой буквы в слове
     */
    public int getNumberLetter(String letter) {
        String strWord = this.toSourceString();
        int counter = 0;
        String wordLetter;
        for (int count = 0; count < strWord.length(); count++) {
            wordLetter = Character.toString(strWord.charAt(count));
            if (wordLetter.compareToIgnoreCase(letter) == 0) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Если все гласные, то true
     */
    public boolean isAllVowels() {
        String strWord = this.toSourceString();
        for (int i = 0; i < strWord.length(); i++) {
            String letter = Character.toString(strWord.charAt(i));
            if (letter.toUpperCase().matches("[БВГДЖЗЙКЛМНПРСТФХЦЧШЩ]")) {
                return false;
            }
        }
        return true;
    }

    /**
     * Соотношение гласных букв в слове к согласным
     */
    public float getRatioVowel() {
        String word = this.toSourceString();
        float vowel = 0; // гласная буква
        float consonant = 0; // согласная буква

        for (int i = 0; i < word.length(); i++) {
            String letter = Character.toString(word.charAt((i)));
            if (letter.toUpperCase().matches("[БВГДЖЗЙКЛМНПРСТФХЦЧШЩ]")) {
                consonant++;
            } else if (letter.toUpperCase().matches("[АЕЁИОУЫЭЮЯ]")) {
                vowel++;
            }
        }

        if (vowel > 0) {
            return consonant / vowel;
        } else {
            return -1;
        }
    }

    public boolean equalsIgnoreCase(Word word) {
        return this.toSourceString().equalsIgnoreCase(word.toSourceString());
    }

    public Word toLowerCase() {
        String word = this.toSourceString().toLowerCase();
        this.clear();
        for (int count = 0; count < word.length(); count++) {
            this.add(new Letter(word.charAt(count)));
        }
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Word) {
            Word word = (Word) obj;
            return this.toSourceString().equals(word.toSourceString());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        Letter letter;
        for (Component component : this.getComponents()) {
            letter = (Letter) component;
            result += (int) letter.toSourceString().toLowerCase().charAt(0);
            result += result * (int) letter.toSourceString().toLowerCase().charAt(0);
        }
        return result;
    }
}
