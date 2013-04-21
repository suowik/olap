package pl.edu.pk.olap.parsers;

import org.jsoup.nodes.Document;
import pl.edu.pk.olap.db.dto.Computer;
import pl.edu.pk.olap.exceptions.DocumentParseException;
import pl.edu.pk.olap.parsers.strategy.ParseStrategy;

/**
 * User: Paweł
 * Date: 10.03.13
 * Time: 15:19
 */
public class NotebookParser {
    public static Computer parse(Document document, ParseStrategy strategy) throws DocumentParseException {
        Computer result = new Computer();
        strategy.parse(document,result);
        if (result.isFilledCorrectly()) {
            return result;
        }
        throw new DocumentParseException(result.toString());
    }
}
