import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	double xVel, yVel, x, y;

	public Ball() {
		xVel = randomSpeed() * randomDirection();
		yVel = randomDirection() * randomSpeed();
		x = 350;
		y = 250;
	}
	
	public double randomSpeed(){return Math.random()*1+2;}
	
	public int randomDirection(){
		int rand = (int) (Math.random()*2);
		if(rand == 1){return 1;}
		else{return -1;}}
	
	public void draw(Graphics g){
		g.setColor(Color.white);
		g.fillOval((int)x-10, (int)y-10, 20, 20);
	}
	
	public void checkCollision(Paddle p1, Paddle p2){
		if (x <= 50){
			if (y >= p1.getY() && y <= p1.getY()+80){xVel = -xVel;}
		}
		else if (x >= 650){
			if (y >= p2.getY() && y <= p2.getY()+80){xVel = -xVel;}
		}
	}
	
	public void move(){
		x += xVel;
		y += yVel;
		if (y < 10){yVel = -yVel;}
		else if(y > 490){yVel = -yVel;}
	}

	public int getX() {
		return (int)x;
	}
	
	public int getY() {
		return (int)y;
	}

}
