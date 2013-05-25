package pl.edu.pk.olap.parsers.strategy;

import org.jsoup.nodes.Document;
import pl.edu.pk.olap.db.dto.Computer;

/**
 * User: suowik
 * Date: 13.03.13
 * Time: 10:45
 */
public class SaturnParseStrategy extends MediaMarktParseStrategy {
    @Override
    public void parse(Document document, Computer computer) {
        super.parse(document, computer);
        computer.setSource(Computer.Source.SATURN);
    }
}
