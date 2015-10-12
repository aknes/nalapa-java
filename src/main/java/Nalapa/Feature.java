package Nalapa;

/**
 * Created by Agnes on 12-Oct-15.
 */
public class Feature {
    public static boolean isNumber(String text){
        return text.matches("(.)*(\\d)(.)*");
    }
    public static boolean isBeginCapital(String text){
        if(text == "") return false;
        else return Character.isUpperCase(text.charAt(0));}

    public static boolean isAllCapital(String text){
        return text.matches("^[A-Z]+$");
    }

    public static boolean isContainNotAlphanumeric(String text) {
        if(text == "") return false;
        else return (!text.matches("^[0-9a-zA-Z]+$"));
    }

    public static boolean isAllPunctuation(String text){
        return text.matches("^.*[\\.\\,\\;\\[\\]\\-\\_\\:\\}\\{\\/\\>\\<\\=\\+\\)\\(\\*]+.*$");
    }
}
