package processor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplierTest {
  @Test
  public void multiplierReturnsDoubledCharacters() {
    Multiplier multiplier = new Multiplier();

    assertAll(
      () -> assertEquals("aa", multiplier.convert("a")),
      () -> assertEquals("aabbcc", multiplier.convert("abc")),
      () -> assertEquals("11", multiplier.convert("1")),
      () -> assertEquals("", multiplier.convert("")),
      () -> assertEquals("//", multiplier.convert("/")),
      () -> assertEquals("aaBB22", multiplier.convert("aB2"))
    );
  }
}
