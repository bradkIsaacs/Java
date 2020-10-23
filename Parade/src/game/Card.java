package game;

public class Card {
	
	final int value;
	final String color;
	
	public Card(int value, String color) {
		this.value = value;
		this.color = color;
	}

	public int getValue() {
		return value;
	}

	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value+"_"+color;
	}
	
	
}
