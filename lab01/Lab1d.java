import java.util.*; // imports the scanner for I/O
public class Lab1d {
	public static void main(String[] args) {
		// create random time-based seed
		Random randN = new Random(System.currentTimeMillis());
		int randNum = randN.nextInt(10);
		guess(randNum);
	}

	// snarky messages >:)
	static String[] snarkyMessages = {
		"Nice try, do you need a little push?",
		"A rock could guess better than you!",
		"Come on, you have a whopping ten percent chance!",
		"You would be bad at gambling.",
		"TRY HARDER!!",
		"We don't have all day...",
		"Zzzzzzzzz -_-",
		"What is this, your fifth try already??",
		"I'm waiting...",
		"No actually, do you need my help?",
		"FINALLY!!! Wait, I was wrong."
	};

	// check if the guess is equal to the random number
	public static boolean checkEquals(int userG, int randN) {
		if(userG == randN) { return true; }
		else { return false; }
	}

	// this method does the guessing algorithm
	public static void guess(int randN) {
		Scanner in = new Scanner(System.in);
		
		boolean guess = false;
		int numGuess = 1;
		Random randM = new Random(System.currentTimeMillis());
		
		// first guess
		System.out.print("Guess a number between 0 and 10: ");
		int userGuess = in.nextInt();
		guess = checkEquals(userGuess, randN);
		
		// guessing loop
		while(!guess){
			numGuess++;
			int rM = randM.nextInt(10);
			System.out.print(snarkyMessages[rM] + " Guess again: ");
			userGuess = in.nextInt();
			guess = checkEquals(userGuess, randN);
		}
		System.out.println("Right after " + numGuess + " guesses!");

		// make sure to close the input stream!
		in.close();
	}
}