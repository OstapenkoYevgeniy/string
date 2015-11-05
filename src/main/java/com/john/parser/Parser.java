package com.john.parser;

import com.john.element.Text;

public interface Parser {
    Text parse(String string) throws ParsingException;
}
