import static org.junit.Assert.assertTrue;

import org.junit.Test;
import java.util.Base64;

public class Tests {


  String a = "Mg==";
  String b = "NDogaWFkZA==";
  String c = "";
  Answers answers = new Answers();

  @Test
  public void a() {
    assertRightAnswer(a, answers.a);
  }

  @Test
  public void b() {
    assertRightAnswer(b, answers.b);
  }

  @Test
  public void c() {
    assertRightAnswer(c, answers.c);
  }

  public void assertRightAnswer(String expected, String origin){
    String expected2 = new String(Base64.getDecoder().decode(expected));
    assertTrue(expected2.equals(origin));
  }
}