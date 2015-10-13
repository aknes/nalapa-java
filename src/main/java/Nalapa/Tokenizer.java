package Nalapa;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ananta on 10/1/15.
 */
public class Tokenizer {

    public static boolean isContainingPunctuation(String text) {
        return !text.matches("[a-zA-Z0-9]*$");
    }

    public static String[] splitPunctuationRight (String[] _words) {
        boolean again = true;
        String[] result = _words;
        String[][] container = new String[_words.length][];
        while (again) {
            String[] temp = result;
            for (int i = 0; i < result.length; i++) {
                String word = result[i];
                String[] res = {word};
                int lastCharIdx = word.length() - 1;
                String lastChar = ""+word.charAt(lastCharIdx);
                if (Tokenizer.isContainingPunctuation(lastChar) && lastCharIdx!=0)
                    res = new String[]{word.substring(0,lastCharIdx), lastChar};
                container[i] = res;
            }
            ArrayList<String> stringArray = new ArrayList<String>();
            for (int i = 0; i < container.length; i++)
                for (int j = 0; j < container[i].length; j++)
                    stringArray.add(container[i][j]);
            result = stringArray.toArray(new String[stringArray.size()]);
            again = !Arrays.equals(result, temp);
            if (!again)
                return result;
            container = new String[result.length][];
        }
        return new String[0];
    }

    public static String[] splitPunctuationLeft (String[] _words) {
        boolean again = true;
        String[] result = _words;
        String[][] container = new String[_words.length][];
        while (again) {
            String[] temp = result;
            for (int i = 0; i < result.length; i++) {
                String word = result[i];
                String[] res = {word};
                String firstChar = ""+word.charAt(0);
                if (Tokenizer.isContainingPunctuation(firstChar) && word.length()!=1)
                    res = new String[]{firstChar, word.substring(1, word.length())};
                container[i] = res;
            }
            ArrayList<String> stringArray = new ArrayList<String>();
            for (int i = 0; i < container.length; i++)
                for (int j = 0; j < container[i].length; j++)
                    stringArray.add(container[i][j]);
            result = stringArray.toArray(new String[stringArray.size()]);
            again = !Arrays.equals(result, temp);
            if (!again)
                return result;
            container = new String[result.length][];
        }
        return new String[0];
    }

    public static String[] tokenize (String text) {
        text = (text.length()==0) ? " " : text;
        String[] result = text.split(" ");
        result = Tokenizer.splitPunctuationRight(result);
        result = Tokenizer.splitPunctuationLeft(result);
        return result;
    }

    public static String[] splitSentence(String text){
        text = (text.length()==0) ? " " : text;
        String[] word = text.split("(?<=[-.!?])\\s*");
        return word;
    }
}
