package processor.driver;

import processor.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.*;
import java.util.*;

public class Driver {
  static Processor processor = new Processor();
  static String input;
  static String chosenBlocks = "";
  static Map<String, Block> validBlocks = new HashMap<>();

  public static void exceptionPrint(Throwable exception) {
    System.out.println(exception.getMessage());
  }

  public static void print(String message) {
    System.out.println(message);
  }

  public static void parseDefinedBlockFile(String fileName) {
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] blockDetails = line.split(" ");
        Block newBlock;
        String instanceName = blockDetails[0];
        Class<?> blockName = Class.forName(blockDetails[1]);
        Constructor<?> constructor;

        if (blockDetails.length > 2) {
          constructor = blockName.getConstructor(String.class);
          newBlock = (Block) constructor.newInstance(blockDetails[2]);
        } else {
          constructor = blockName.getConstructor();
          newBlock = (Block) constructor.newInstance();
        }
        validBlocks.put(instanceName, newBlock);
      }
    } catch (Throwable e) {
      exceptionPrint(new RuntimeException("ERROR: unable to process file " + fileName));
    }
  }

  public static void validateBlock(String blockName) {
    Block blockToAdd = validBlocks.get(blockName);
    if(blockToAdd != null) {
      chosenBlocks += blockName + " ";
      processor.addBlocks(blockToAdd);
      print(blockName + " added to processor");
    }
    else {
      print("ERROR: invalid block name " + blockName);
    }
  }

  public static void getInput() {
    Scanner in = new Scanner(System.in);
    print("Enter input to be processed:");
    input = in.nextLine();
    print("Your input was: " + input);

    print("Available blocks include: " + validBlocks.keySet());
    print("Enter 1 block, or 'exit' to quit:");
    String nextBlock = in.nextLine();
    while(!nextBlock.equals("exit")) {
      validateBlock(nextBlock);
      print("Enter 1 block, or 'exit' to quit:");
      nextBlock = in.nextLine();
    }
    in.close();

    print("Your blocks for processing are: " + chosenBlocks);
  }

  public static void main(String[] args) {
    parseDefinedBlockFile("predefinedBlocks.txt");
    parseDefinedBlockFile("userDefinedBlocks.txt");
    getInput();

    print("Your input was: " + input);
    print("Processed results are: " + processor.process(input));
  }
}
