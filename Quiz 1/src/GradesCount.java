import java.util.*;

public class GradesCount {
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		double grade;
		do {
			System.out
					.print("Enter a grade in as a percent (-1 to exit): i.e 40, 60.25: ");
			grade = keyboard.nextDouble();
			methods.sort(grade);
		} while (grade != -1);
		System.out.println("Total number of grades ="+methods.a+methods.b+methods.c+methods.d+methods.f);
		System.out.println("Number of A = "+methods.a);
		System.out.println("Number of B = "+methods.b);
		System.out.println("Number of C = "+methods.c);
		System.out.println("Number of D = "+methods.d);
		System.out.println("Number of F = "+methods.f);
		System.out.print("The A grades are: ");
		for(int i = 0; i<methods.list.length; i++){
			System.out.print(methods.list[i]+", ");
		}
	}
}
