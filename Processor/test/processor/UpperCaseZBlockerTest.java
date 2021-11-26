package processor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpperCaseZBlockerTest {
  @Test
  public void ZBlockerBlocks() {
    CharacterBlocker UpperCaseZBlocker = new CharacterBlocker("Z");

    assertAll(
      () -> assertEquals("ab", UpperCaseZBlocker.convert("abZ")),
      () -> assertEquals("zbC", UpperCaseZBlocker.convert("zbC")),
      () -> assertEquals("ac", UpperCaseZBlocker.convert("aZZcZ")),
      () -> assertEquals("", UpperCaseZBlocker.convert("")),
      () -> assertEquals("/", UpperCaseZBlocker.convert("/")),
      () -> assertEquals("1b", UpperCaseZBlocker.convert("Z1b"))
    );
  }
}
