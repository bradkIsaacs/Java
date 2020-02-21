import javax.swing.*;


public class Maze {

	public Maze() {
		JFrame f = new JFrame();
		f.setTitle("Maze Game");
		f.add(new Board());
		f.setSize(450, 475);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Maze();
	}

}
