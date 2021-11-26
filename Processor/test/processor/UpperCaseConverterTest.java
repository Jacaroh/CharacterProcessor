package processor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UpperCaseConverterTest {

  @Test
  public void canary() {
    assertTrue(true);
  }

  @Test
  public void upperCaseConversions() {
    UpperCaseConverter upperCaseConverter = new UpperCaseConverter();

    assertAll(
      () -> assertEquals("ABC", upperCaseConverter.convert("abc")),
      () -> assertEquals("ABC", upperCaseConverter.convert("aBc")),
      () -> assertEquals("", upperCaseConverter.convert("")),
      () -> assertEquals("/", upperCaseConverter.convert("/")),
      () -> assertEquals("A1B", upperCaseConverter.convert("a1b"))
    );
  }
}
