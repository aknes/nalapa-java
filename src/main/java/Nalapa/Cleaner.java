package Nalapa;

/**
 * Created by ananta on 10/1/15.
 */
public class Cleaner {

    public static boolean isASCII (String text) {
        return text.matches("\\A\\p{ASCII}*\\z");
    }

    public static boolean isAlphaNumeric (String text) {
        return text.matches("^[a-zA-Z0-9]*$");
    }

    public static String removeNonASCII (String text) {
        return text.replaceAll("[^\\x00-\\x7F]","");
    }

    public static String removeNonAlphaNumeric (String text) {
        return text.replaceAll("[^a-zA-Z0-9]","");
    }

    public static String removeHTMLTags (String text) {
        return text.replaceAll("<[^>]*>","");
    }
}
