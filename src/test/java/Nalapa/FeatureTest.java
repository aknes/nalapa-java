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
