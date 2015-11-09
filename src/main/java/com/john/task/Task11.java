package com.john.task;

import com.john.entity.ParserException;
import com.john.entity.Sentence;
import com.john.entity.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * В каждом предложении текста исключить подстроку максимальной длины,
 * начинающуюся и заканчивающуюся заданными символами.
 */
public class Task11 {
    private String startLetter;
    private String endLetter;

    public Task11(char startLetter, char endLetter) {
        this.startLetter = Character.toString(startLetter);
        this.endLetter = Character.toString(endLetter);
    }

    public List<Sentence> run(Text text) throws IOException, ParserException {
        List<Sentence> sentences = text.getSentences();
        List<Sentence> result = new ArrayList<>();
        text.configure();

        for (Sentence sentence : sentences) {
            String strSentence = sentence.toSourceString();
            int indexOf = strSentence.toLowerCase().indexOf(startLetter.toLowerCase());
            int lastIndexOf = strSentence.toLowerCase().lastIndexOf(endLetter.toLowerCase());

            if (indexOf != -1 && lastIndexOf != -1) {
                strSentence = strSentence.substring(0, indexOf) + strSentence.substring(lastIndexOf + 1, strSentence.length());
                result.add(text.parse(strSentence, Sentence.class));
            }
        }
        return result;
    }
}
