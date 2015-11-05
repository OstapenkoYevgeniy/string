package com.john.element;

import com.john.element.Composit.AbstractComposite;

import java.util.List;

public class Sentence extends AbstractComposite<Sentence> {
    private List<Sentence> sentences;
    public Sentence() {
    }
}
