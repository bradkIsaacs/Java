import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WallBall extends Applet implements Runnable, KeyListener{
	final int WIDTH = 700, HEIGHT = 500;
	Thread thread;
	Player p1;
	Ball b;
	boolean gameStart;
	boolean offMap = false;
	Graphics gfx;
	Image img;

	public void init() {
		this.resize(WIDTH, HEIGHT);
		this.addKeyListener(this);
		p1 = new Player();
		b = new Ball();
		img = createImage(WIDTH, HEIGHT);
		gfx = img.getGraphics();
		thread = new Thread(this);
		thread.start();
	}

	public void paint(Graphics g) {
		gfx.setColor(Color.orange);
		gfx.fillRect(0, 0, WIDTH, HEIGHT);
		if (b.getY() >= 500){
			offMap = true;
			gfx.setColor(Color.black);
			gfx.drawString("Game Over", 120, 140);
			if (b.count != 1) {
				gfx.drawString("You had " + b.count + " consecutive vollies", 120, 160);
			}else{
				gfx.drawString("You had " + b.count + " consecutive volly", 120, 160);
			}
		}
		else{
			p1.draw(gfx);
			b.draw(gfx);
		if(!gameStart){
			gfx.setColor(Color.black);
			gfx.drawString("Wall Ball", 120, 140);
			gfx.drawString("Hit the ball with your paddle as many times as you can", 120, 160);
			gfx.drawString("Press Enter To Start", 120, 180);
			gfx.drawString("Ball speeds up every time it hits the Pladdle", 120, 200);
			}
		}
		g.drawImage(img, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void run() {
		for(;;){
			
			if (gameStart) {
				p1.move();
				b.move();
			}
			b.checkCollision(p1);
			repaint();
			if (offMap){
				break;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			p1.setRightAccel(true);
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT){
			p1.setLeftAccel(true);
		}
		else if(e.getKeyCode() == KeyEvent.VK_ENTER){
			b.count = 0;
			gameStart = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			b.setY(500);
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			p1.setRightAccel(false);
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT){
			p1.setLeftAccel(false);
		}
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
