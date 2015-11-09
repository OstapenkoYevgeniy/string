package com.john.entity;

import java.util.List;

/**
 * Интерфейс для сущностей - композитов
 */
public interface Composite<E extends Component> extends Component{
    void add(E component);

    void add(int index, E component);

    void addAll(List<E> components);

    void remove (E component);

    void remove (int index);

    void clear();
}
