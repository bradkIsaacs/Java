package game;

import java.util.*;

public class Player {
	
	final String name;
	ArrayList<Card> hand;
	ArrayList<Card> palette;
	
	public Player(String name, ArrayList<Card> hand, ArrayList<Card> palette) {
		this.name = name;
		this.hand = hand;
		this.palette = palette;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void addToHand(Card c) {
		this.hand.add(c);
	}

	public ArrayList<Card> getPalette() {
		return palette;
	}

	public void addToPalette(Card c) {
		this.palette.add(c);
	}

	public String getName() {
		return name;
	}
	
}
