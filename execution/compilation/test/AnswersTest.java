import static utils.AnswerCheckUtils.question;
import static utils.AnswerCheckUtils.verifyCorrectAnswer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Question;
import java.util.stream.Stream;

public class AnswersTest {

  @ParameterizedTest
  @MethodSource("questions")
  void answers(Question expected) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
    verifyCorrectAnswer(expected);
  }

  public static Stream<Arguments> questions(){
    return Stream.of(
           question("A", "Mg=="),
           question("B", "NDogaWFkZA=="),
           question("C", "NDogaWFkZA=="),
           question("D", "NDogaWFkZA==")
    );
  }
}