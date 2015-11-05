package com.john;

import com.john.PropertyManager.PropertyManager;
import com.john.element.Text;
import com.john.reader.ReadingException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) throws ReadingException, IOException {

        PropertyManager propertyManager = PropertyManager.getInstance();

        final String PATHFILE = propertyManager.getProperty("pathfile");

        String stringText = new String(Files.readAllBytes(Paths.get(PATHFILE)));

        Text text = new Text(stringText);


    }
}
