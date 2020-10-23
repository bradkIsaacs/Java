package game;

import java.util.ArrayList;

public class Majority {
	
	ArrayList<Integer> index;
	final int max;
	final String color;
	
	public Majority(ArrayList<Integer> index, int max, String color) {
		this.index = index;
		this.max = max;
		this.color = color;
	}

	public ArrayList<Integer> getIndex() {
		return index;
	}

	public void addIndex(int index) {
		this.index.add(index);
	}

	public int getMax() {
		return max;
	}
	
	public String getColor() {
		return color;
	}
}
