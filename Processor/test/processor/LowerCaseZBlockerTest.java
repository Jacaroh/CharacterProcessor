package processor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LowerCaseZBlockerTest {
  @Test
  public void zBlockerBlocks() {
    CharacterBlocker LowerCaseZBlocker = new CharacterBlocker("z");

    assertAll(
      () -> assertEquals("ab", LowerCaseZBlocker.convert("abz")),
      () -> assertEquals("ZbC", LowerCaseZBlocker.convert("ZbC")),
      () -> assertEquals("ac", LowerCaseZBlocker.convert("azzcz")),
      () -> assertEquals("", LowerCaseZBlocker.convert("")),
      () -> assertEquals("/", LowerCaseZBlocker.convert("/")),
      () -> assertEquals("1b", LowerCaseZBlocker.convert("z1b"))
    );
  }
}
