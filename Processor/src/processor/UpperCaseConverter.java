package processor;

public class UpperCaseConverter implements Block {
  @Override
  public String convert(String input) {
    return input.toUpperCase();
  }
}
