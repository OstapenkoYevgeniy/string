package com.john.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader implements Reader {
    private String pathfile;

    public FileReader(String pathfile) {
        this.pathfile = pathfile;
    }

    public String read() throws ReadingException {
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(pathfile))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

            return  sb.toString();
        } catch (FileNotFoundException e) {
            throw new ReadingException("File not found!", e);
        } catch (IOException e) {
            throw new ReadingException("Error reading file!", e);
        }
    }
}
