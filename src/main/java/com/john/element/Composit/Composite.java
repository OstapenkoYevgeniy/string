package com.john.element.Composit;

import java.util.List;

public interface Composite<E> {
    void add(List<E> elements);

    void add(E element);

    void add(int index, E element);
}
