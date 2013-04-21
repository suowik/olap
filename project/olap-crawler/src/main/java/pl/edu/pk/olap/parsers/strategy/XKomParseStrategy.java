package pl.edu.pk.olap.parsers.strategy;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import pl.edu.pk.olap.db.dto.Computer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: suowik
 * Date: 13.03.13
 * Time: 12:12
 */
public class XKomParseStrategy implements ParseStrategy {
    private static final Logger LOGGER = Logger.getLogger(XKomParseStrategy.class);
    @Override
    public void parse(Document document, Computer computer) {
        Pattern pattern = Pattern.compile("<b>(.+?)</b>");
        String modelDiv = document.getElementById("show_prod").child(0).html();
        Matcher matcher = pattern.matcher(modelDiv);
        matcher.find();
        String model = matcher.group();
        LOGGER.info(model);
    }
}
