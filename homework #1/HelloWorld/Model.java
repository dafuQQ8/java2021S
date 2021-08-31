import java.util.Arrays;

public class Model {
    // 0 - 1, 1 - 2...
    private static String[] TARGET_WORDS = {
        "hello",
        "world!"
    };

    private String[] input = new String[TARGET_WORDS.length];
    public String keyword;
    private String concatOutput;
    private int containerNumber = 0;
    // program logic 
    // this method assigns userInput to input
    public void input(String userInput) {
        this.input[containerNumber] = userInput;
        this.containerNumber++;
    }
    // this method concatenates strings
    public String output() {
        concatOutput = Arrays.toString(input);
        return concatOutput;
    }
    // this method returns TARGET_WORDS.length
    public int searchLength() {
        return TARGET_WORDS.length;
    }
    // this method checks whether word is appropriate
    public boolean proofer(String string) {
        if (TARGET_WORDS[containerNumber].equalsIgnoreCase(string)) {
            this.keyword = string;
            return true;
        }
        else {
            return false;
        }
    }
}