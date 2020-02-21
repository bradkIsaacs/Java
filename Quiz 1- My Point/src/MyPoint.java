public class MyPoint {
	int x, y;

	public MyPoint() {
		int a = 0;
		int b = 0;
	}

	public MyPoint(int c, int d) {
		c = x;
		d = y;
	}

	public int[] getXY() {
		int[] xy = new int[2];
		xy[0] = this.x;
		xy[1] = this.y;
		return xy;
	}

	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double distance(int x, int y){
		double result;
		int xDir, yDir;
		xDir = this.x - x;
		yDir = this.y - y;
		result = Math.abs(Math.sqrt((xDir*xDir)+(yDir*yDir)));
		return result;
	}
	
	public double distance(MyPoint another){
		double result;
		int xDir, yDir;
		xDir = this.x - another.x;
		yDir = this.y - another.y;
		result = Math.abs(Math.sqrt((xDir*xDir)+(yDir*yDir)));
		return result;
	}
	
	public double distance(){
		double result;
		result = Math.abs(Math.sqrt((this.x*this.x)+(this.y*this.y)));
		return result;
	}
	
}
