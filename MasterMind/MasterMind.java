import java.util.*;

public class MasterMind {
	
	public static void main(String args[]){
		ArrayList<Integer> code = new ArrayList<Integer>();
		ArrayList<Integer> saveCode = new ArrayList<Integer>();
		ArrayList<Integer> myGuess = new ArrayList<Integer>();
		Random rand = new Random();
		int difficult = 4;
		Scanner keyboard = new Scanner(System.in);
		do {
			System.out.println("--------------------------------");
			int guesses = 12;
			//Create code
			for (int i = 0; i < difficult; i++) {
				code.add(rand.nextInt(9));
			}
			//Save copy of code in saveCode
			saveCode = (ArrayList<Integer>) code.clone();
			//Print codes //Used for testing
			//		System.out.println(code);
			//		System.out.println(saveCode);
			do {
				//Get code from user
				System.out.println("Guesses remaning " + guesses);
				System.out
						.print("Enter a "+difficult+" digit code seperated by spaces: ");
				//Create user code
				for (int i = 0; i < difficult; i++) {
					myGuess.add(keyboard.nextInt());
				}
				//Print user code //Used for testing
				//			System.out.println(myGuess);
				//Check digit correct placement
				int cPlace = cPlace(code, myGuess);
				System.out.println("Digits placed correctly: " + cPlace);
				if (cPlace == difficult) {
					System.out.println("You Won");
					System.out.println(saveCode);
					break;
				}
				//Print user code //Used for testing
				//			System.out.println(myGuess);
				//Print codes //Used for testing
				//			System.out.println(code);
				//Check digit incorrect placement
				int iPlace = iPlace(code, myGuess);
				System.out.println("Digits placed incorrectly: " + iPlace);
				//Print user code //Used for testing
				//			System.out.println(myGuess);
				//Print codes //Used for testing
				//			System.out.println(code);
				//Reset code
				code = (ArrayList<Integer>) saveCode.clone();
				//Clear myGuess
				myGuess.clear();
				guesses--;
				if (guesses == 0) {
					System.out.println("You Lost the correct code was");
					System.out.println(code);
				}
			} while (guesses != 0);
			System.out.print("Do you want to play again? y/n: ");
			code.clear();
			saveCode.clear();
			myGuess.clear();
			difficult++;
		} while (keyboard.next().toLowerCase().charAt(0) == 'y');
		System.out.println("Thanks for playing");
		System.exit(0);
	}

	public static int iPlace(ArrayList<Integer> code, ArrayList<Integer> myGuess) {
		int iPlace = 0;
		for(int i=0; i<myGuess.size(); i++){
			for(int j=0; j<code.size(); j++){
				if(myGuess.get(i) == code.get(j)){
					myGuess.set(i, 11);
					code.set(j, 10);
					iPlace++;
				}
			}
		}
		return iPlace;
	}

	public static int cPlace(ArrayList<Integer> code, ArrayList<Integer> myGuess) {
		int cPlace = 0;
		for(int i=0; i<myGuess.size(); i++){
			if(myGuess.get(i) == code.get(i)){
				myGuess.set(i, 11);
				code.set(i, 10);
				cPlace++;
			}
		}
		return cPlace;
	}

}
