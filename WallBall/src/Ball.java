import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	double xVel, yVel, x, y;
	int count = 0;

	public Ball() {
		xVel = randomSpeed() * randomDirection();
		yVel = -Math.abs(randomDirection() * randomSpeed());
		x = 350;
		y = 250;
	}
	
	public double randomSpeed(){
		return Math.random()*1+2;
	}
	
	public int randomDirection(){
		int rand = (int) (Math.random()*2);
		if(rand == 1){return 1;}
		else{return -1;}
	}
	
	public void draw(Graphics g){
		g.setColor(Color.black);
		g.fillOval((int)x-10, (int)y-10, 20, 20);
	}
	
	public void checkCollision(Paddle p1){
		if (y >= 470){
			if (x >= p1.getX() && x <= p1.getX()+80){
				yVel = -yVel-.5;
				count++;
			}
		}
	}
	
	public void move(){
		x += (xVel+.1);
		y += (yVel+.1);
		if (y < 10){yVel = -yVel;} //top wall
		else if(x > 690){xVel = -xVel;} //right wall
		else if(x < 10){xVel = -xVel;} //left Wall
	}

	public int getX() {
		return (int)x;
	}
	
	public int getY() {
		return (int)y;
	}
	
	public void setY(int num){
		y = num;
	}
}
