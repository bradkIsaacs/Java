//Question #2
public class SetEqualPoints {
	static MyPoint[] points = new MyPoint[10];
	public static void main(String[] args){
		for (int i = 0; i < points.length; i++) {
			   points[i] = new MyPoint(i+1, i+1); // Allocate each of MyPoint instances
			}
		for(int i = 0; i<10; i++){
			System.out.println("X: "+points[i].getX()+" Y: "+points[i].getY());;
		}
	}
}
