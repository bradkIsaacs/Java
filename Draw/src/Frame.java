import java.awt.*;
import javax.swing.JFrame;


public class Frame extends JFrame{
	
	int[] points = {0, 0, 400, 400};
	
	public Frame(){
		setTitle("Draw Me");
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g){
		g.drawLine(0, 30, 100, 300);
		g.drawLine(100, 300, 200, 200);
		g.drawLine(200, 200, 300, 300);
		g.drawLine(300, 300, 400, 400);
	}
	
	public static void main(String[] args){
		Frame f = new Frame();
	}
}
