package pl.edu.pk.olap.parsers.strategy;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pl.edu.pk.olap.utils.StringUtils;

/**
 * User: suowik
 * Date: 13.03.13
 * Time: 12:40
 */
public class ParseUtils {
    public static final String REDUNDANT_PATTERN = "NETBOOK|ULTRABOOK|NOTEBOOK";
    public static final String PRICE_OMIT = "["+ StringUtils.POLISH_LETTERS+"A-Za-z &;<>/]";
    static boolean contains(Element col, String word) {
        return col.html().contains(word);
    }

    static String extractValue(Element col) {
        Elements tds = col.children();
        return tds.get(1).text();
    }
}
