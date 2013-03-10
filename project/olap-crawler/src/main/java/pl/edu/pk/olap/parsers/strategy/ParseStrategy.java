package pl.edu.pk.olap.parsers.strategy;

import org.jsoup.nodes.Document;
import pl.edu.pk.olap.dto.Computer;

/**
 * User: Paweł
 * Date: 10.03.13
 * Time: 15:32
 */
public interface ParseStrategy {
    void parse(Document document, Computer computer);
}
