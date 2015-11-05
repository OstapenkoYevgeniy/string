package com.john.element.Composit;

import java.util.List;

public abstract class AbstractComposite<E> implements Composite<E> {
    private List<E> elements;

    @Override
    public void add(List<E> elements) {
        this.elements = elements;
    }

    @Override
    public void add(E element) {
        elements.add(element);
    }

    @Override
    public void add(int index, E element) {
        elements.add(index, element);
    }
}
