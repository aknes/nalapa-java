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
    @Test
    public void isEquals() {
        assertEquals(true, Feature.isEquals("haihai", "haihai"));
        assertEquals(false, Feature.isEquals("haihai", "hoihoi"));
    }
    @Test
    public void isAmpersand() {
        assertEquals(true, Feature.isAmpersand("&"));
        assertEquals(false, Feature.isAmpersand("hahahaha"));
    }
    @Test
    public void isDot() {
        assertEquals(true, Feature.isDot("."));
        assertEquals(false, Feature.isDot("hahahaha"));
    }
    @Test
    public void isComma() {
        assertEquals(true, Feature.isComma(","));
        assertEquals(false, Feature.isComma("hahahaha"));
    }
    @Test
    public void isContainsYear() {
        assertEquals(true, Feature.isContainsYear("1985"));
        assertEquals(true, Feature.isContainsYear("1985haihai"));
        assertEquals(true, Feature.isContainsYear("hoho1985haihai"));
        assertEquals(false, Feature.isContainsYear("hoho"));
        assertEquals(false, Feature.isContainsYear("666"));
        assertEquals(false, Feature.isContainsNumber(""));
    }
    @Test
    public void isContainsRoman() {
        assertEquals(true, Feature.isContainsRoman("I"));
        assertEquals(true, Feature.isContainsRoman("V"));
        assertEquals(true, Feature.isContainsRoman("X"));
        assertEquals(true, Feature.isContainsRoman("D"));
        assertEquals(true, Feature.isContainsRoman("C"));
        assertEquals(true, Feature.isContainsRoman("M"));
        assertEquals(true, Feature.isContainsRoman("MCMXCII"));
        assertEquals(false, Feature.isContainsRoman("MCMXCIIPOPO"));
        assertEquals(false, Feature.isContainsNumber(""));
    }
    @Test
    public void isContainsNumber() {
        assertEquals(true, Feature.isContainsNumber("1"));
        assertEquals(true, Feature.isContainsNumber("hehe1"));
        assertEquals(true, Feature.isContainsNumber("1hehe"));
        assertEquals(true, Feature.isContainsNumber("he1he"));
        assertEquals(false, Feature.isContainsNumber("hehe"));
        assertEquals(false, Feature.isContainsNumber(""));
    }
}
