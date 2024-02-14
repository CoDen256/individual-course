package utils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.params.provider.Arguments;
import java.lang.reflect.Field;
import java.util.Base64;

public class AnswerCheckUtils {
    private AnswerCheckUtils(){}

    static Object userAnswers;

    static {
        try {
            userAnswers = Class.forName("Answers").getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("You have no class named 'Answers'!!! Create one! \nclass Answers {\n}\n");
        }
    }


    public static void verifyCorrectAnswer(Question question) throws NoSuchFieldException, IllegalAccessException {
        String userAnswer = getUserAnswer(question.getQuestion(), userAnswers);
        String expected = new String(Base64.getDecoder().decode(question.getAnswer()));
        assertTrue(wrongAnswerMessage(question, userAnswer), expected.equals(userAnswer) );
    }

    public static String wrongAnswerMessage(Question question, String submission) {
        return String.format("Answer [%s] for question [%s] is wrong. Try again!", submission, question.getQuestion());
    }

    public static String getUserAnswer(String question, Object submission) throws NoSuchFieldException, IllegalAccessException {
        try {
            Class<?> userAnswers = submission.getClass();
            Field declaredField = userAnswers.getDeclaredField(question);
            declaredField.setAccessible(true);
            return declaredField.get(submission).toString();
        } catch (NoSuchFieldException e){
            fail(noAnswerMessage(question));
            throw new AssertionError("unreachable");
        }
    }

    private static String noAnswerMessage(String question) {
        return String.format("You have not provided an answer for question [%s]! Declare and define a field like this" +
                "\n\t\t\t\tString %s = \"<Your answer goes here>\";\n"
                , question, question);
    }

    public static Arguments question(String question, String answer){
        return Arguments.arguments(new Question(question, answer));
    }

}
