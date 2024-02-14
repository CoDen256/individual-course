import static utils.AnswerCheckUtils.question;

import org.junit.jupiter.params.provider.Arguments;
import utils.AnswerCheckerTestTemplate;
import java.util.stream.Stream;

public class AnswersTest extends AnswerCheckerTestTemplate {
    @Override
    public Stream<Arguments> questions() {
        return Stream.of(
                question("A", "Mw=="),
                question("B", "NQ=="),
                question("C", "NA=="),
                question("D", "Mg=="),
                question("E", "MQ=="),
                question("F", "Mg=="),
                question("G", "Mg=="),
                question("H", "MQ=="),
                question("I", "Mg=="),
                question("J", "Miw0"),
                question("K", "NA==")
        );
    }
}