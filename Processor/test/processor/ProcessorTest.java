package processor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProcessorTest {
  Processor processor;

  @BeforeEach
  public void setup() {
    processor = new Processor();
  }

  @Test
  public void processorWithNoBlocks() {
    var result = processor.process("abcd");

    assertEquals("abcd", result);
  }

  @Test
  public void processorWith1LowerCaseConverterBlock() {
    processor.addBlocks(new LowerCaseConverter());

    var result = processor.process("aBcD");

    assertEquals("abcd", result);
  }

  @Test
  public void processorWith1UpperCaseConverterBlock() {
    processor.addBlocks(new UpperCaseConverter());

    var result = processor.process("aBcD");

    assertEquals("ABCD", result);
  }

  @Test
  public void processorWith2Blocks() {
    processor.addBlocks(new UpperCaseConverter());
    processor.addBlocks(new CharacterBlocker("A"));

    var result = processor.process("aBcA");

    assertEquals("BC", result);
  }

  @Test
  public void processorWith3Blocks() {
    processor.addBlocks(new Multiplier());
    processor.addBlocks(new CharacterBlocker("a"));
    processor.addBlocks(new LowerCaseConverter());

    var result = processor.process("aBcA");

    assertEquals("bbccaa", result);
  }
}
