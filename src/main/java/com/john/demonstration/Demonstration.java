package com.john.demonstration;

import com.john.entity.Component;
import com.john.entity.Text;

import java.util.Collection;

/**
 * Данный класс предназначен для удобной демонстрации работы программы.
 */
public class Demonstration {

    /**
     * Сравнение исходной строки и распарсенного текста
     */
    public static void compareTextWithSourceString(String sourceString, Text text) {
        System.out.println("-------------------------------------");
        System.out.println("Comparing with the original string parsed text:");
        System.out.println("text.toSourceString().equals(sourceString) = " + text.toSourceString().equals(sourceString));
    }

    /**
     * Вывод результата на консоль.
     */
    public static <T extends Component> T showResult(Collection<T> result) {
        System.out.println("-------------------------------------");
        for (T component : result) {
            System.out.println(component.toSourceString());
        }
        return null;
    }

    /**
     * Вывод текста.
     */
    public static void print(Text text) {
        System.out.println("-------------------------------------");
        System.out.println(text.toSourceString());
    }
}
