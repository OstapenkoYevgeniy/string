package com.john.element;

import com.john.element.Composit.AbstractComposite;

import java.util.List;
import java.util.regex.Pattern;

public class Paragraph extends AbstractComposite<Sentence>{
    List<Sentence> sentences;
    public Paragraph() {
    }

    public Paragraph(List<Sentence> sentences) {

    }

    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }
}
