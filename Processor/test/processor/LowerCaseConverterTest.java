package processor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LowerCaseConverterTest {
  @Test
  public void upperCaseConversions() {
    LowerCaseConverter lowerCaseConverter = new LowerCaseConverter();

    assertAll(
      () -> assertEquals("abc", lowerCaseConverter.convert("ABC")),
      () -> assertEquals("abc", lowerCaseConverter.convert("AbC")),
      () -> assertEquals("", lowerCaseConverter.convert("")),
      () -> assertEquals("/", lowerCaseConverter.convert("/")),
      () -> assertEquals("a1b", lowerCaseConverter.convert("A1B"))
    );
  }
}
