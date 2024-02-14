package utils;

import static utils.AnswerCheckUtils.verifyCorrectAnswer;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AnswerCheckerTestTemplate {
    @ParameterizedTest
    @MethodSource("questions")
    void answers(Question expected) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        verifyCorrectAnswer(expected);
    }

    public abstract Stream<Arguments> questions();
}
