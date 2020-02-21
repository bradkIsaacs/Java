import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;

public class Board extends JPanel implements ActionListener{
	private Timer timer;
	private Map m;
	private Player p;
	private String message = "";
	int walk = 2;
	
	public Board() {
		m =new Map();
		p = new Player();
		addKeyListener(new AL());
		setFocusable(true);
		timer = new Timer(25, this);
		timer.start();
	}

	public void actionPerformed(ActionEvent e) {
		if(m.getMap(p.getTileX(), p.getTileY()).equals("f")){
			message = "Winner";
		}
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		for(int y = 0; y < 14; y++){
			for(int x = 0; x < 14; x++){
				if(m.getMap(x, y).equals("g")){
					g.drawImage(m.getGrass(), x*32, y*32, null);					
				}
				if(m.getMap(x, y).equals("w")){
					g.drawImage(m.getWall(), x*32, y*32, null);					
				}
				if(m.getMap(x, y).equals("f")){
					g.drawImage(m.getFinish(), x*32, y*32, null);					
				}
			}
		}
		if (m.getMap(p.getTileX(), p.getTileY()).equals("f")){
			g.setColor(Color.red);
			g.drawString(message, 20, 20);
			}
		g.drawImage(p.getPlayer(), p.getTileX()*32, p.getTileY()*32, null);
	}
	
	public class AL extends KeyAdapter{

		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_UP){
				if(!m.getMap(p.getTileX(), p.getTileY()-1).equals("w")){
				p.move(0, -1);
				}
				else if(walk > 0){
				p.move(0, -1);
				walk--;
				}
			}
			if (key == KeyEvent.VK_DOWN){
				if(!m.getMap(p.getTileX(), p.getTileY()+1).equals("w")){
				p.move(0, 1);
				}
				else if(walk > 0){
				p.move(0, 1);
				walk--;
				}
			}
			if (key == KeyEvent.VK_RIGHT){
				if(!m.getMap(p.getTileX()+1, p.getTileY()).equals("w")){
				p.move(1, 0);
				}
				else if(walk > 0){
				p.move(1, 0);
				walk--;
				}
			}
			if (key == KeyEvent.VK_LEFT){
				if(!m.getMap(p.getTileX()-1, p.getTileY()).equals("w")){
				p.move(-1, 0);
				}
				else if(walk > 0){
				p.move(-1, 0);
				walk--;
				}
			}
		}

		public void keyReleased(KeyEvent e) {
		}

		public void keyTyped(KeyEvent e) {
		}
		
	}
}
