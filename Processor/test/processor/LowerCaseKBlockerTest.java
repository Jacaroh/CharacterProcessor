package processor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LowerCaseKBlockerTest {
  @Test
  public void kBlockerBlocks() {
    CharacterBlocker LowerCaseKBlocker = new CharacterBlocker("k");

    assertAll(
      () -> assertEquals("ab", LowerCaseKBlocker.convert("abk")),
      () -> assertEquals("KbC", LowerCaseKBlocker.convert("KbC")),
      () -> assertEquals("ac", LowerCaseKBlocker.convert("akkck")),
      () -> assertEquals("", LowerCaseKBlocker.convert("")),
      () -> assertEquals("/", LowerCaseKBlocker.convert("/")),
      () -> assertEquals("1b", LowerCaseKBlocker.convert("k1b"))
    );
  }
}
