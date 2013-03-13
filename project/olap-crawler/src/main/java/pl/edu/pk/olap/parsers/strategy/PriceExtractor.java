package pl.edu.pk.olap.parsers.strategy;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: suowik
 * Date: 13.03.13
 * Time: 10:45
 */
public class PriceExtractor {

    private static final Logger LOGGER = Logger.getLogger(PriceExtractor.class);
    private static final String PRICE = "price-style";

    private PriceExtractor() {
    }

    public static int parse(Document document) {
        Elements htmlPrice = document.getElementsByClass(PRICE);
        String price = "";
        final Pattern pattern = Pattern.compile("p[0-9]");
        final Matcher matcher = pattern.matcher(htmlPrice.html());
        while (matcher.find()){
            String chunk = matcher.group().replace("p","");
            price += chunk;
        }
        try {
            return Integer.parseInt(price);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}
