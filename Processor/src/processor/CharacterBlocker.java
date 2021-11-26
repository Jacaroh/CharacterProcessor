package processor;

public class CharacterBlocker implements Block {
  private final String characterToBlock;

  public CharacterBlocker(String toBeBlocked) {
    characterToBlock = toBeBlocked;
  }

  @Override
  public String convert(String input) {
    return input.replaceAll(characterToBlock, "");
  }
}