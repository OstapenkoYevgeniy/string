package com.john.entity;

/**
 * Абстрактный класс для компонентов
 */
public abstract class AbstractComponent<E> implements Leaf<E>, SentenceComponent{
    E leaf;

    public AbstractComponent(E leaf) {
        this.leaf = leaf;
    }

    @Override
    public void change(E leaf) {
        this.leaf = leaf;
    }

    @Override
    public String toSourceString() {
        return leaf.toString();
    }
}
