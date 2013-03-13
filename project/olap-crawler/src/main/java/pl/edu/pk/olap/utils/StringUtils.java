package pl.edu.pk.olap.utils;

/**
 * User: Paweł
 * Date: 10.03.13
 * Time: 15:25
 */
public class StringUtils {
    private StringUtils(){}

    public static final String POLISH_LETTERS = "ąśćńźżółęĄŚĆŃŹÓŁĘ";

    public static boolean isAnyEmpty(String... words){
        for (String word : words) {
            if(isEmpty(word)){
                return true;
            }
        }
        return false;
    }

    public static boolean isNotEmpty(String word){
        return !isEmpty(word);
    }

    private static boolean isEmpty(String word){
        return word == null || word.equals("");
    }
}
