package Nalapa;

/**
 * Created by ananta on 10/1/15.
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import Nalapa.Cleaner;

public class CleanerTest {

    private Cleaner cleaner;

    @Before
    public void setUp() {
        cleaner = new Cleaner();
    }

    @Test
    public void isASCII() {
        assertEquals(true, cleaner.isASCII("abc123"));
        assertEquals(true, cleaner.isASCII("abc_-8+"));
        assertEquals(false, cleaner.isASCII("ابت"));
    }

    @Test
    public void isAlphaNumeric() {
        assertEquals(true, cleaner.isAlphaNumeric("abc123"));
        assertEquals(false, cleaner.isAlphaNumeric("abc_-8+"));
        assertEquals(false, cleaner.isAlphaNumeric("ابت"));
    }

    @Test
    public void removeNonASCII() {
        assertEquals("abc123", cleaner.removeNonASCII("abc123"));
        assertEquals("abc_-8+", cleaner.removeNonASCII("abc_-8+"));
        assertEquals("", cleaner.removeNonASCII("ابت"));
    }

    @Test
    public void removeNonAlphaNumeric() {
        assertEquals("abc123", cleaner.removeNonAlphaNumeric("abc123"));
        assertEquals("abc8", cleaner.removeNonAlphaNumeric("abc_-8+"));
        assertEquals("", cleaner.removeNonAlphaNumeric("ابت"));
    }

    @Test
    public void removeHTMLTags() {
        assertEquals("some long paragraph", cleaner.removeHTMLTags("<p class=\"long\">some long paragraph</p>"));
    }

}
