import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pong extends Applet implements Runnable, KeyListener{
	final int WIDTH = 700, HEIGHT = 500;
	Thread thread;
	HumanPaddle p1;
	Ball b;
	AI com;
	boolean gameStart;
	Graphics gfx;
	Image img;

	public void init() {
		this.resize(WIDTH, HEIGHT);
		this.addKeyListener(this);
		p1 = new HumanPaddle(1);
		b = new Ball();
		com = new AI(2, b);
		img = createImage(WIDTH, HEIGHT);
		gfx = img.getGraphics();
		thread = new Thread(this);
		thread.start();
	}

	public void paint(Graphics g) {
		gfx.setColor(Color.black);
		gfx.fillRect(0, 0, WIDTH, HEIGHT);
		if (b.getX() < -10 || b.getX() > 710){
			gfx.setColor(Color.white);
			gfx.drawString("Game Over", 350, 250);}
		else{
			p1.draw(gfx);
			b.draw(gfx);
			com.draw(gfx);
		if(!gameStart){
			gfx.setColor(Color.white);
			gfx.drawString("Pong", 340, 100);
			gfx.drawString("Press Enter To Start", 310, 130);}
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
				com.move();
			}
			b.checkCollision(p1, com);
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP){
			p1.setUpAccel(true);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			p1.setDownAccel(true);
		}
		else if(e.getKeyCode() == KeyEvent.VK_ENTER){
			gameStart = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP){
			p1.setUpAccel(false);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			p1.setDownAccel(false);
		}
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
