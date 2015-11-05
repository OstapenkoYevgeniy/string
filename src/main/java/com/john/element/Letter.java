package com.john.element;

import com.john.element.Composit.Component;

public class Letter implements Component<Character>{
    char letter;

    public Letter() {
    }

    public Letter(char letter) {
        this.letter = letter;
    }

    @Override
    public void add(Character element) {
        letter = element;
    }
}
