package com.john.task;

import com.john.entity.Component;
import com.john.entity.Sentence;
import com.john.entity.Text;
import com.john.entity.Word;

import java.util.List;

/**
 * В каждом предложении текста поменять местами первое слово с последним, не изменяя длины предложения.
 */
public class Task5 {
    public List<Sentence> run(Text text) {
        for (Sentence sentence : text.getSentences()) {
            List<Component> components = sentence.getComponents();

            // 'min' и 'max' - для поиска первого и последнего слова в предложении
            int min = 99999;
            int max = 0;

            for (int i = 0; i < components.size(); i++) {
                if (components.get(i) instanceof Word) {
                    if (min > i)
                        min = i;
                    if (max < i)
                        max = i;
                }
            }

            Word tmpWord = (Word) components.get(min);
            components.set(min, components.get(max));
            components.set(max, tmpWord);
        }
        return text.getSentences();
    }
}
