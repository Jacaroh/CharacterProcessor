package processor;

import java.util.ArrayList;
import java.util.List;

public class Processor {
  private List<Block> blocks = new ArrayList<>();

  public void addBlocks(Block blockToAdd) {
    blocks.add(blockToAdd);
  }

  public String process(String input) {
    var composedBlocks = blocks.stream()
      .reduce(text -> text,
        (block1, block2) -> text -> block2.convert(block1.convert(text)));

    return composedBlocks.convert(input);    
  }
}