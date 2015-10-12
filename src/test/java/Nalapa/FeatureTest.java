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
    }
    @Test
    public void isBeginCapital() {
        assertEquals(true, Feature.isBeginCapital("Abc"));
        assertEquals(true, Feature.isBeginCapital("ABc"));
        assertEquals(false, Feature.isBeginCapital("aBC"));
    }
}
