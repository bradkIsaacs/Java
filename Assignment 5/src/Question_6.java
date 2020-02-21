import java.util.*;

public class Question_6 {
	public static void main(String[] args){
		ArrayList<Student> test = new ArrayList<Student>();
		test.add(new Student("John", 85));
		test.add(new Student("Jane", 75));
		test.add(new Student("James", 89));
		test.add(new Student("Jade", 55));
		test.add(new Student("Andrew", 60));
		test.add(new Student("Max", 72));
		test.add(new Student("Kyle", 81));
		test.add(new Student("Ethan", 90));
		test.add(new Student("Chris", 88));
		test.add(new Student("Bradley", 77));
		//createSeperate(test);
		System.out.println("----Unsorted----");
		print(test);
		System.out.println("----Sorted----");
		Collections.sort(test);
		print(test);
	}
	public static void sortByScore(ArrayList<Student> test) {
		Collections.sort(test);
	}
	public static void print(ArrayList<Student> list) {
		for (int i = 0; i<list.size(); i++){
			System.out.println(list.get(i).getName()+" got a "+list.get(i).getScore());
		}
		
	}
}