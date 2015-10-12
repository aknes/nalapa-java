package Nalapa;

/**
 * Created by Agnes on 12-Oct-15.
 */
public class Feature {
    public static boolean isNumber(String text){
        return text.matches("(.)*(\\d)(.)*");
    }
    public static boolean isBeginCapital(String text){
        return Character.isUpperCase(text.charAt(0));}
}
