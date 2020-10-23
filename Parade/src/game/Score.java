package game;

public class Score {
	
	final String name;
	int score;
	
	public Score(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void addScore(int score) {
		this.score += score;
	}

	public String getName() {
		return name;
	}
	
	

}
