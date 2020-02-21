public class methods {
	static int a;
	static int b;
	static int c;
	static int d;
	static int f;
	static double[] list = new double[12]; 
	static int total;
	public static void sort(double d){
		if (d>=90){
			a++;
			int i = 0;
			list[i]=d;
			i++;
		}
		else if (d>=80 && d<90){
			b++;
		}
		else if (d>=70 && d<80){
			c++;
		}
		else if (d>=60 && d<70){
			d++;
		}
		else if (d>=60 && d<70){
			f++;
		}
	}
}
