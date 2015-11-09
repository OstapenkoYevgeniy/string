package com.john.entity;

import com.john.PropertyManager.PropertyManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Текст
 */
public class Text extends AbstractComposit<Paragraph> {
    private Map<Class<? extends Component>, Pattern> patterns;
    private Map<Class<? extends Composite>, Class<? extends Component>> componentMap;

    public List<Paragraph> getParagraphs() {
        List<Paragraph> result = this.getComponents().stream()
                .map(component -> (Paragraph) component).collect(Collectors.toList());
        return result;
    }

    public List<Sentence> getSentences() {
        List<Sentence> result = new ArrayList<>();
        for (Paragraph paragraph : this.getParagraphs()) {
            result.addAll(paragraph.getSentences());
        }
        return result;
    }

    public List<Word> getWords() {
        List<Word> result = new ArrayList<>();
        for (Paragraph paragraph : this.getParagraphs()) {
            for (Sentence sentence : paragraph.getSentences()) {
                result.addAll(sentence.getWords());
            }
        }
        return result;
    }

    /**
     * Парсер
     */
    public Text parse(String sourceString) throws ParserException {
        return parse(sourceString, Text.class);
    }

    /**
     * Парсер принимает строку и класс, если возможно углубиться, то происходит рекурсия
     */
    public <T extends Composite> T parse(String sourceString, Class<T> compositeClass) throws ParserException {
        T t;
        try {
            t = compositeClass.newInstance();

            Class componentClass = componentMap.get(compositeClass);

            Matcher matcher = patterns.get(componentClass).matcher(sourceString);

            while (matcher.find()) {
                if (componentClass == SentenceComponent.class) {
                    if (matcher.group().matches(patterns.get(Word.class).toString())) {
                        t.add(new Word(matcher.group()));
                    }
                    if (matcher.group().matches(patterns.get(Number.class).toString())) {
                        t.add(new Number(new Integer(matcher.group())));
                    }
                    if (matcher.group().matches(patterns.get(Punctuation.class).toString())) {
                        t.add(new Punctuation(matcher.group().charAt(0)));
                    }
                    if (matcher.group().matches(patterns.get(Space.class).toString())) {
                        t.add(new Space(matcher.group().charAt(0)));
                    }
                } else {
                    Component c = parse(matcher.group(), componentClass);
                    t.add(c);
                }
            }
            return t;
        } catch (InstantiationException ie) {
            throw new ParserException("Parsing error! No default constructor!",ie);
        } catch (IllegalAccessException iae) {
            throw new ParserException("Parsing error!", iae);
        }
    }

    /**
     * Конфигурирование парсера
     */
    public void configure() {
        try {
            PropertyManager propertyManager = PropertyManager.getInstance();

            patterns = new HashMap<>();
            patterns.put(Paragraph.class, Pattern.compile(propertyManager.getProperty("paragraph")));
            patterns.put(Sentence.class, Pattern.compile(propertyManager.getProperty("sentence")));
            patterns.put(SentenceComponent.class, Pattern.compile(propertyManager.getProperty("sentence.component")));
            patterns.put(Word.class, Pattern.compile(propertyManager.getProperty("word")));
            patterns.put(Number.class, Pattern.compile(propertyManager.getProperty("number")));
            patterns.put(Punctuation.class, Pattern.compile(propertyManager.getProperty("punctuation")));
            patterns.put(Space.class, Pattern.compile(propertyManager.getProperty("space")));

            componentMap = new HashMap<>();
            componentMap.put(Text.class, Paragraph.class);
            componentMap.put(Paragraph.class, Sentence.class);
            componentMap.put(Sentence.class, SentenceComponent.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
