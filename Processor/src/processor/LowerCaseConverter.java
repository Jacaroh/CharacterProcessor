package processor;

public class LowerCaseConverter implements Block {
  @Override
  public String convert(String input) {
    return input.toLowerCase();
  }
}
