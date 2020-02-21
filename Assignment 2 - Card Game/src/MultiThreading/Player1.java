package MultiThreading;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Player1 implements Runnable{
	// Keeps track of the players hand
	ArrayList<String> hand = new ArrayList<String>(); 
	// Keeps track of the players draw deck
	ArrayList<String> deck = new ArrayList<String>();
	// Keeps track of the players actions 
	ArrayList<String> actions = new ArrayList<String>();
	// Keeps track of the desired cards a.k.a strategy 
	int d0, d1;
	// Keeps track of the players discard
	private String discard;

	// Constructor that initializes the players starting hand and draw deck
	public Player1(String one, String two, String three, String four,
			String five, String six, String seven, String eight) {
		hand.add(one);
		hand.add(two);
		hand.add(three);
		hand.add(four);
		deck.add(five);
		deck.add(six);
		deck.add(seven);
		deck.add(eight);
	}
	
	public void run() {
		cardDrawn();
		discard();
		playerHand();
	}

	public void discard() {
		// Reset desired count to zero
		d0 = 0;
		d1 = 0;
		// If card is wanted
		if (deck.get(0).equals("0") || deck.get(0).equals("1")) {
			// Add drawn card to hand
			hand.add(deck.get(0));
			// Remove the drawn card from deck
			deck.remove(0);
			// recount desired
			desiredcount();
			// If desired cards in hand add to 5
			// discard the desired number you have less of
			if (d0 + d1 == 5) {
				// If there are more zeros than ones
				// Search and discard a one
				if (d0 > d1) {
					for (int i = 0; i < hand.size(); i++) {
						// If one found
						if (hand.get(i).equals("1")) {
							// Print discarded card
							System.out.println("Player 1 discarded a: "
									+ hand.get(i));
							// Add discard to p2 deck
							setDiscard(hand.get(i));
							// Remove said card from hand
							hand.remove(hand.get(i));
							// Break out of the loop
							break;
						}
					}
				}
				// If there are more ones than zeros
				// Search and discard a zero
				else {
					for (int i = 0; i < hand.size(); i++) {
						// If zero found
						if (hand.get(i).equals("0")) {
							// Print discarded card
							System.out.println("Player 1 discarded a: "
									+ hand.get(i));
							// Add discard to p2 deck
							setDiscard(hand.get(i));
							// Remove said card from hand
							hand.remove(hand.get(i));
							// Break out of the loop
							break;
						}
					}
				}
			}
			// If desired cards in hand don't add to 5
			// discard an undesired card
			else {
				// If card desired, search for a non desired card to discard
				for (int i = 0; i < hand.size(); i++) {
					// If non desired card found
					if (!hand.get(i).equals("0") && !hand.get(i).equals("1")) {
						// Print discarded card
						System.out.println("Player 1 discarded a: " + hand.get(i));
						// Set string discard to discarded card
						setDiscard(hand.get(i));
						// Remove discarded card card from hand
						hand.remove(hand.get(i));
						// Break out of the loop
						break;
					}
				}
			}
		}
		// Card is not desired
		else {
			// Print drawn card as discarded
			System.out.println("Player 1 discarded a: " + deck.get(0));
			// Set string discard to discarded card
			setDiscard(deck.get(0));
			// Remove card from deck
			deck.remove(0);
		}
		// add discard string to actions
		actions.add("discarded: " + getDiscard());
	}

	public void cardDrawn() {
		// Print Drawn card
		System.out.println("Player 1 drew a: " + deck.get(0));
		// add drew string to actions
		actions.add("drew: " + deck.get(0));
	}

	public void playerHand() {
		// Print players hand
		System.out.println("Player 1's hand: "+hand);
		// add hand string to actions
		actions.add("hand: "+hand);
	}

	// Utility method used to see if the player has won
	public boolean check() {
		if (hand.get(0).equals(hand.get(1)) && hand.get(0).equals(hand.get(2))
				&& hand.get(0).equals(hand.get(3))) {
			System.out.println("Player 1 wins");
			System.out.println("Player 1 exits");
			System.out.println("Game Over");
			// add win declaration to actions 
			actions.add("Win yes");
			// add hand string to actions
			actions.add("Hand: "+hand);
			// add draw pile string to actions
			actions.add("Drawpile: "+deck);
			return true;
		}else{
			return false;
		}
		
	}
	
	// Utility method used to keep track of desired cards
	public void desiredcount() {
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).equals("0")) {
				d0++;
			} else if (hand.get(i).equals("1")) {
				d1++;
			}
		}
	}

	// Utility method used to add a new card to the bottom of the draw deck
	public void addCard(String str) {
		deck.add(str);
	}

	// getter method used to get string discard 
	public String getDiscard() {
		return discard;
	}

	// setter method used to set the string discard
	public void setDiscard(String discard) {
		this.discard = discard;
	}
	
	//Utility method that writes a file of actions done by the player
	public void makeFile(){
		try {
			PrintWriter out = new PrintWriter("player1.actions");
			for(int i = 0; i<actions.size(); i++){
				out.write(actions.get(i)+"\n");
			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}