package com.application;
import com.data.Student;

public class Application {

	public static void main(String[] args){
		Student student = new Student("Brian", 186421645, 3.75);
		Student[] studList = new Student[10];
		//Store 2 Students in studList
		studList[0] = new Student("Brian", 112013151, 3.75);
		studList[1] = new Student("Lowel", 547986516, 3.2);
		studList[2] = new Student("Jenny", 879878478, 3.05);
		studList[3] = new Student("Lowel", 498749864, 3.2);
		studList[4] = new Student("Brian", 449879847, 3.75);
		studList[5] = new Student("Lowel", 157845846, 3.2);
		studList[6] = new Student("Brian", 186421645, 3.75);
		studList[7] = new Student("Lowel", 157845846, 3.2);
		studList[8] = new Student("Brian", 186421645, 3.75);
		studList[9] = new Student("Lowel", 157845846, 3.2);
		System.out.println("Name\tID\t\tGPA");
		for (int i = 0; i < studList.length; i++) {
			System.out.println(studList[i].getStudentName()+"\t"+studList[i].getStudentID()+"\t"+studList[i].getStudentGpa());
		}
	}
}
