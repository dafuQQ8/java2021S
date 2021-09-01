package game;

public class View {
	// Text's constants
	public static final String WELCOMMING_MESSAGE =
		"Guess the Number v0.1.\n" +
		"\nGame description:\n" +
		"* Computer sets a pseudorandom integer within a known range.\n" +
		"* Player tries to guess the number.\n" +
		"* If the guess is incorrect, then computer tells player whether the guess was too high or too low.\n" +
		"* Eventually, player guesses the correct number.\n" +
		"* The player's score equals the number of guesses he made.\n";

	public static final String[] LIMIT_MESSAGE = {
		"\nSet minimum value for range, enter any number between 0 and 999.\n" +
		"Press<Enter> to skip. (It sets minimum range value to 0)",
		"Set maximum value for range, enter any number between 0 and 1000," +
		" but make sure it's greater then minimum number.\n" +
		"Press<Enter> to skip. (It sets maximum range value to 100)"
	};

	public static final String[] HIGH_INPUTS = {
		"Your guess is too high. Try lower!" +
		"\nUpdated range is: [%d, %d]",
		"Your guess is too low. Try higher!" +
		"\nUpdated range is: [%d, %d]",
		"Your guess is out of range. Try again!" +
		"\nCurrent range is: [%d, %d]"
	};

	public static final String[] LOW_INPUTS = {
		"Minimum value is greater then maximum," +
		" try greater one!",
		"Minimum value equals to maximum," +
		" try greater one!",
		"Your number breaks rules, try another one."
	};

	public static final String ACCURACY_MESSAGE = "Accuracy percentage: %d%%";

	public static final String LIMIT_ERROR = "You either entered the wrong data type or unexpected error happened, try once again.";
	public static final String GAME_STARTS = "\nGame starts!\n* Pseudorandom number is set!\n* Range: [%d, %d]\n";
	public static final String GOOD_LUCK = "* Good luck and may the Force be with you!";
	public static final String PROOFER_ERROR = "You either entered the wrong data type or unexpected error happened, try once again.";
	public static final String ARROWS = "\n>>>> ";
	public static final String PREVIOUS = "\nPrevious guess: %d\n";
	public static final String CONGRATULATION_MESSAGE =
		"\nThis calls for celebrating! Congratulations!" +
		"\nI knew it was only a matter of time. Well done!\n" +
		"\nStatistics:" +
		"\n* Score: ";

	public static final String STATS = "\n* Your attemps: [";

	public void printMessage(String message) {
		System.out.print(message);
	}

	public String mergeStrings(String...strings) {
		String finalString = "";

		for (String input: strings) {
			finalString += input;
		}
		return finalString;
	}
}