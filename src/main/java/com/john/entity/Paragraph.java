package com.john.entity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Параграф
 */
public class Paragraph extends AbstractComposit<Sentence> {

    /**
     * Получить все предложения
     */
    public List<Sentence> getSentences() {
        List<Sentence> result = this.getComponents().stream()
                .map(component -> (Sentence) component).collect(Collectors.toList());
        return result;
    }


}
