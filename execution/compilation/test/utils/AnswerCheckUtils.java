package utils;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.params.provider.Arguments;
import java.lang.reflect.Field;
import java.util.Base64;

public class AnswerCheckUtils {
    private AnswerCheckUtils(){}

    public static void verifyCorrectAnswer(Question question, Object userAnswers) throws NoSuchFieldException, IllegalAccessException {
        String userAnswer = getUserAnswer(question.getQuestion(), userAnswers);
        String expected = new String(Base64.getDecoder().decode(question.getAnswer()));
        assertTrue(wrongAnswerMessage(question, userAnswer), expected.equals(userAnswer) );
    }

    public static String wrongAnswerMessage(Question question, String submission) {
        return String.format("Answer [%s] for question [%s] is wrong. Try again!", submission, question.getQuestion());
    }

    public static String getUserAnswer(String question, Object submission) throws NoSuchFieldException, IllegalAccessException {
        Class<?> userAnswers = submission.getClass();
        Field declaredField = userAnswers.getDeclaredField(question);
        declaredField.setAccessible(true);
        return declaredField.get(submission).toString();
    }

    public static Arguments question(String question, String answer){
        return Arguments.arguments(new Question(question, answer));
    }

}
