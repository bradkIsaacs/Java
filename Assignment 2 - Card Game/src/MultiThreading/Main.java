/*
 * This card game initially reads a 32 card deck from a file and deals 4 hands one for each player
 * and a draw deck of 4 cards for each player. Players take turns drawing the top card of designated deck
 * and discard to the bottom of the next players draw deck appropriately. The game continues until one player
 * has a hand of the same denomination.  
 * @author  Bradley Isaacs
 * @version 1.0
 * @since   2017-10-30 
 */
package MultiThreading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> deck = new ArrayList<String>();
		Scanner s = null;
		try {
			s = new Scanner(new BufferedReader(new FileReader("deck.txt")));
			for (int i = 0; i < 32; i++) {
				deck.add(s.next());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (s != null) {
				s.close();
			}
		}
		// Shuffle Deck
		deck = shuffle(deck);
		// Create Player Objects
		Player1 p1 = new Player1(deck.get(0), deck.get(4), deck.get(8),
				deck.get(12), deck.get(16), deck.get(20), deck.get(24),
				deck.get(28));
		Player2 p2 = new Player2(deck.get(1), deck.get(5), deck.get(9),
				deck.get(13), deck.get(17), deck.get(21), deck.get(25),
				deck.get(29));
		Player3 p3 = new Player3(deck.get(2), deck.get(6), deck.get(10),
				deck.get(14), deck.get(18), deck.get(22), deck.get(26),
				deck.get(30));
		Player4 p4 = new Player4(deck.get(3), deck.get(7), deck.get(11),
				deck.get(15), deck.get(19), deck.get(23), deck.get(27),
				deck.get(31));
		// Create Threads from player objects
		Thread player1 = new Thread(p1);
		Thread player2 = new Thread(p2);
		Thread player3 = new Thread(p3);
		Thread player4 = new Thread(p4);
		// Start Game Loop // Run until a player has reported they have won
		while (!p1.check() || !p2.check() || !p3.check() || !p4.check()) {
			// Player 1 execute turn
			player1.run();
			// Place player 1's discard at the bottom of player 2's draw deck
			p2.addCard(p1.getDiscard());
			printBreak();
			// If player 1 has reported they have won break out of the game loop
			if (p1.check()) {
				break;
			}
			try {
				player1.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Player 2 execute turn
			player2.run();
			// Place player 2's discard at the bottom of player 3's draw deck
			p3.addCard(p2.getDiscard());
			printBreak();
			// If player 2 has reported they have won break out of the game loop
			if (p2.check()) {
				break;
			}
			try {
				player2.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Player 3 execute turn
			player3.run();
			// Place player 3's discard at the bottom of player 4's draw deck
			p4.addCard(p3.getDiscard());
			printBreak();
			// If player 3 has reported they have won break out of the game loop
			if (p3.check()) {
				break;
			}
			try {
				player3.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Player 4 execute turn
			player4.run();
			// Place player 4's discard at the bottom of player 1's draw deck
			p1.addCard(p4.getDiscard());
			printBreak();
			// If player 4 has reported they have won break out of the game loop
			if (p4.check()) {
				break;
			}
			try {
				player4.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//Write player1.actions file
		p1.makeFile();
		//Write player2.actions file
		p2.makeFile();
		//Write player3.actions file
		p3.makeFile();
		//Write player4.actions file
		p4.makeFile();
	}
	
	public static ArrayList<String> shuffle(ArrayList<String> deck) {
		Random rand = new Random();
		ArrayList<String> shuffle = new ArrayList<String>();
		for (int i = 0; i < deck.size(); i++) {
			int ran = rand.nextInt(deck.size());
			shuffle.add(deck.get(ran));
		}
		return shuffle;
	}
    
	// Utility method that simply prints a visual separator 
	public static void printBreak(){
		System.out.println("------------------------------------------------");
	}
}