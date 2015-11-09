package com.john.entity;

/**
 * Интерфейс для сущностей, не являющихся композитами
 */
public interface Leaf<E> extends Component {
    void change (E leaf);
}
