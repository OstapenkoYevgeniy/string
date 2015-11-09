package com.john.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Абстрактный класс для композитов
 */
public abstract class AbstractComposit<E extends Component> implements Composite {
    List<Component> components = new ArrayList<>();

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void add(int index, Component component) {
        components.add(index, component);
    }

    @Override
    public void addAll(List components) {
        components.addAll(components);
    }

    @Override
    public void clear() {
        components.clear();
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public void remove(int index) {
        components.remove(index);
    }

    public String toSourceString() {
        StringBuilder builder = new StringBuilder();
        for (Component component : components) builder.append(component.toSourceString());
        return builder.toString();
    }

    @Override
    public String toString() {
        return this.getClass().toString() + " Size: " + components.size();
    }

}
