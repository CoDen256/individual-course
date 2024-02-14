import static utils.AnswerCheckUtils.question;

import org.junit.jupiter.params.provider.Arguments;
import utils.AnswerCheckerTestTemplate;
import java.util.stream.Stream;

public class AnswersTest extends AnswerCheckerTestTemplate {
    @Override
    public Stream<Arguments> questions() {
        return Stream.of(
                question("A", "Mg=="),
                question("B", "NDogaWFkZA=="),
                question("C", "NDogaWFkZA=="),
                question("D", "NDogaWFkZA==")
        );
    }
}