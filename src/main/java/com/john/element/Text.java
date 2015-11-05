package com.john.element;

import com.john.PropertyManager.PropertyManager;
import com.john.element.Composit.AbstractComposite;
import com.john.element.Composit.Composite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text extends AbstractComposite<Paragraph> {
    final String PARAGRAPH = "paragraph";
    final String SENTENCE = "sentence";
    final String WORD = "sentence";
    final String NUMBER = "number";
    final String PUNCTUATION = "punctuation";
    final String SPACE = "space";
    List<Paragraph> paragraphs;

    HashMap<Class, Pattern> patterns;

    public Text() {
    }

    public Text(String stringText) throws IOException {
        parse(stringText);
    }


    private <T>T parse(final String str) throws IOException {

        PropertyManager propertyManager = PropertyManager.getInstance();
        patterns = new HashMap<>();

        patterns.put(Paragraph.class, Pattern.compile(propertyManager.getProperty(PARAGRAPH)));
        patterns.put(Sentence.class, Pattern.compile(propertyManager.getProperty(SENTENCE)));
        patterns.put(Word.class, Pattern.compile(propertyManager.getProperty(WORD)));
        patterns.put(Number.class, Pattern.compile(propertyManager.getProperty(NUMBER)));
        patterns.put(Punctuation.class, Pattern.compile(propertyManager.getProperty(PUNCTUATION)));
        patterns.put(Space.class, Pattern.compile(propertyManager.getProperty(SPACE)));

        paragraphs = parse(str, Paragraph.class);

        return null;
//        return parse(str, Paragraph.class);
    }

    private <T>T  parse(String str, Class classs) {
        List<AbstractComposite> result = new ArrayList<>();


        Matcher m = patterns.get(classs).matcher(str);

        if (classs == Paragraph.class) {
            while (m.find()) {
                System.out.println("PARAGRAPH - " + m.group());
                result = (parse(m.group(), Sentence.class));
            }
        }
        if (classs == Sentence.class) {
            while (m.find()) {
                System.out.println("SENTENCE - " + m.group());
                result = (parse(m.group(), Token.class));
            }
        }
//        if (classs == Token.class) {
//            System.out.println("******************************************");
//        }
        return (T) result;
    }
}
