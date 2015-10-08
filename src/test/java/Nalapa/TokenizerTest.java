package Nalapa;

/**
 * Created by ananta on 10/1/15.
 */

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TokenizerTest {

    private Tokenizer tokenizer;

    @Before
    public void setUp() {
        tokenizer = new Tokenizer();
    }

    @Test
    public void isContainingPunctuation() {
        String text1 = "asd123";
        String text2 = "asd123?.,!";

        assertEquals(false, tokenizer.isContainingPunctuation(text1));
        assertEquals(true, tokenizer.isContainingPunctuation(text2));
    }

    @Test
    public void tokenize() {
        String[] sentences = {
            "Hello world, my name is Alice...",
            "Monday, (1/11). I have 1.000 rupiah.",
            "\"Hahaha\"",
            " ",
            ""
        };

        String[][] tokenss = {
            {"Hello", "world", ",", "my", "name", "is", "Alice", ".", ".", "."},
            {"Monday", ",", "(", "1/11", ")", ".", "I", "have", "1.000", "rupiah", "."},
            {"\"", "Hahaha", "\""},
            {},
            {}
        };

        for (int i = 0; i < sentences.length; i++) {
            String[] t = tokenizer.tokenize(sentences[i]);
            assertEquals(t.length, tokenss[i].length);
            assertEquals(true, Arrays.equals(t, tokenss[i]));
        }
    }

}
