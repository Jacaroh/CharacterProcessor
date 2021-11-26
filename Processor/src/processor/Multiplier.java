package processor;

import static java.util.stream.Collectors.joining;

public class Multiplier implements Block {
  public String convert(String input) {
    return input.chars()
      .mapToObj(Character::toString)
      .map(ch -> ch + ch)
      .collect(joining(""));
  }
}
