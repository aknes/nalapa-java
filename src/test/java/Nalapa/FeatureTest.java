package Nalapa;

/**
 * Created by ananta on 10/1/15.
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import Nalapa.Cleaner;

public class FeatureTest {

    private Feature feature;

    @Test
    public void isNumber() {
        assertEquals(true, Feature.isNumber("abc123"));
        assertEquals(false, Feature.isNumber("abc"));
        assertEquals(true, Feature.isNumber("abc1"));
        assertEquals(false, Feature.isNumber(""));
    }
    @Test
    public void isBeginCapital() {
        assertEquals(true, Feature.isBeginCapital("Abc"));
        assertEquals(true, Feature.isBeginCapital("ABc"));
        assertEquals(false, Feature.isBeginCapital("aBC"));
        assertEquals(false, Feature.isBeginCapital(""));
    }
    @Test
    public void isContainNotAlphanumeric() {
        assertEquals(false, Feature.isContainNotAlphanumeric("abc"));
        assertEquals(true, Feature.isContainNotAlphanumeric("@bc"));
        assertEquals(false, Feature.isContainNotAlphanumeric("abc1"));
        assertEquals(false, Feature.isContainNotAlphanumeric(""));
    }
    @Test
    public void isAllCapital(){
        assertEquals(true, Feature.isAllCapital("ABCD"));
        assertEquals(false, Feature.isAllCapital("Abcd"));
        assertEquals(false, Feature.isAllCapital("AbcD"));
        assertEquals(false, Feature.isAllCapital(""));
    }
    @Test
    public void isAllPunctuation(){
        assertEquals(true, Feature.isAllPunctuation("abcd;"));
        assertEquals(true, Feature.isAllPunctuation(";"));
        assertEquals(false, Feature.isAllPunctuation("abcd"));
        assertEquals(false, Feature.isAllPunctuation(""));
    }
}
