package Nalapa;

import java.util.regex.Pattern;

/**
 * Created by Agnes on 12-Oct-15.
 */
public class Feature {
    public static boolean isNumber(String text){
        return text.matches("(.)*(\\d)(.)*");
    }
    public static boolean isBeginCapital(String text){
        return Character.isUpperCase(text.charAt(0));
    }
    public static boolean isEquals(String text, String text2){
        return (text==text2);
    }
    public static boolean isAmpersand(String text){
        return Feature.isEquals(text, "&");
    }
    public static boolean isDot(String text){
        return Feature.isEquals(text, ".");
    }
    public static boolean isComma(String text){
        return Feature.isEquals(text, ",");
    }
    public static boolean isContainsYear(String text){
        return Pattern.compile("^.*[0-9]{4}.*$").matcher(text).find();
    }
    public static boolean isContainsRoman(String text){
        return Pattern.compile("^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$").matcher(text).find();
    }
    public static boolean isContainsNumber(String text){
        return Pattern.compile(".*\\d+.*").matcher(text).find();
    }
}
