import java.util.regex.Pattern;

public class Model {
    // numeric constant for occasions when user didnot enter "int min" and "int max"
    private static final int[] RANGE = {
        0,
        100
    };
    // container for user input
    public int[] inputRecorder = new int[RANGE[1]];
    public int[] accuracyRecorder = new int[RANGE[1]];
    private int targetNumber; // randomized number
    public int containerNumber = 0;
    private int parsedNumber = 0;
    public int ineedvariable;

    //this method sets range depending on user input
    public boolean rangeSetter(String userInput) {
        if (Pattern.matches("[0-9]+", userInput)) { // If contains only numbers
            this.parsedNumber = Integer.parseInt(userInput);
            if (this.parsedNumber > 1000) {
                ineedvariable = 5; //overflow
                return false;
            } else if (this.parsedNumber < inputRecorder[0]) {
                ineedvariable = 3; // min > max
                return false;

            } else if (this.parsedNumber == inputRecorder[0]) {
                if (this.parsedNumber == 0 || this.parsedNumber == 1000) {
                    this.inputRecorder[containerNumber] = this.parsedNumber;
                    this.containerNumber++;
                    return true;
                }

                ineedvariable = 4; //min == max
                return false;
            }
            this.inputRecorder[containerNumber] = this.parsedNumber;
            this.containerNumber++;
            return true;

        } else if ((userInput.equals(""))) { //if <enter>
            this.inputRecorder[containerNumber] = Model.RANGE[containerNumber];
            this.containerNumber++;
            return true;
        } else {
            return false;
        }
    }
    // this method creates random number
    public void targetNumber() {
        this.targetNumber = (int) Math.floor(Math.random() * ((this.inputRecorder[1] - 1) - (this.inputRecorder[0] + 1)) + this.inputRecorder[0] + 1);
    }

    // this method checks whether entered number is equal to target number
    public boolean correctnessProofer(int userInput) {
        if (userInput == this.targetNumber) {
            this.inputRecorder[containerNumber] = userInput;
            this.containerNumber++;
            return true; //win

        } else {
            this.inputRecorder[containerNumber] = userInput;
            this.accuracyRecorder[containerNumber] = isInRange(userInput) ? (int) calcAccuracy(userInput) : 0;
            this.containerNumber++;
            setRange(userInput);
            return false;
        }
    }

    public long calcAccuracy(double guess) {
        System.out.println(targetNumber);
        if (guess > targetNumber)
            return Math.round((100 * (guess - targetNumber)) / ((inputRecorder[1] - 1) - targetNumber));
        else {
            return Math.round((100 * (guess - (inputRecorder[0] + 1))) / (targetNumber - (inputRecorder[0] + 1)));
        }
    }

    public boolean isInRange(int userInput) {
        return userInput > inputRecorder[0] && userInput < inputRecorder[1];
    }

    private void setRange(int userInput) {
        if (!isInRange(userInput)) {
            ineedvariable = 2; //out of range
        } else if (this.targetNumber > userInput) {
            inputRecorder[0] = userInput;
            ineedvariable = 1; // higher
        } else if (this.targetNumber < userInput) {
            inputRecorder[1] = userInput;
            ineedvariable = 0; //lower
        }
    }
}