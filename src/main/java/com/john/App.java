package com.john;

import com.john.PropertyManager.PropertyManager;
import com.john.demonstration.Demonstration;
import com.john.entity.ParserException;
import com.john.entity.Text;
import com.john.task.Task12;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Logger log = LogManager.getLogger(App.class.getName());

        try {
            PropertyManager propertyManager = PropertyManager.getInstance();

            final String PATHFILE = propertyManager.getProperty("pathfile");
            final String ENCODING = propertyManager.getProperty("encoding");

            String sourceString = new String(Files.readAllBytes(Paths.get(PATHFILE)), ENCODING);

            Text text = new Text();
            text.configure();
            text = text.parse(sourceString);

            Demonstration.compareTextWithSourceString(sourceString, text);

            Demonstration.print(text);

            Task12 task = new Task12(2, 6);
            Demonstration.print(task.run(text));

        } catch (IOException e) {
            log.error(e);
            System.exit(0);
        } catch (ParserException e) {
            log.error(e);
            System.exit(0);
        }
    }
}

