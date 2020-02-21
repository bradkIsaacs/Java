import java.awt.Color;
import java.awt.Graphics;


public class Player implements Paddle{
	double x, xVel;
	boolean leftAccel, rightAccel;
	int player, y;
	final double GRAVITY = 0.94;
	
	
	public Player() {
		leftAccel = false;
		rightAccel = false;
		x = 310;
		xVel = 0;
		y=480;
	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x, y, 80, 20);
	}

	public void move() {
		if (leftAccel){ xVel -= 2;}
		else if (rightAccel){ xVel += 2;}
		else if (!leftAccel && !rightAccel){ xVel *= GRAVITY;}	
		if (xVel >= 5){ xVel = 5;}
		else if (xVel <= -5){ xVel = -5;}
		x += xVel;
		if (x < 0){x=0;}
		else if (x > 620){x=620;}
		
	}
	
	public void setRightAccel(boolean input){
		rightAccel = input;
	}
	
	public void setLeftAccel(boolean input){
		leftAccel = input;
	}

	public int getX() {
		return (int)x;
	}
}
