package login.test;

import java.util.*;

public class Screen {
	
	static Scanner keyboard;
	static char test;

	public static void main(String[] args) {
		keyboard = new Scanner(System.in);
		do {
			System.out.println("n create new user");
			test = keyboard.next().charAt(0);
			switch (test) {
			case 'n': createNew();
			//case 'v': viewUser();
			//break;
			default:
			}
		} while (test != 'q');
	}

	public static void createNew() {
		String username, password;
		ArrayList<String> list = new ArrayList<String>();
		char done = 0;
		Scanner keyboard = new Scanner(System.in);
		
		//Enter username
		System.out.println("please enter your desired username");
		username = keyboard.next();
		//Enter password
		System.out.println("please enter your desired password");
		password = keyboard.next();
		//Create List
		System.out.println("please enter your desired list");
		do{
			list.add(keyboard.next());
			//Ask finished
		}while(done != 'n');
		//Create Object
		Person user = new Person(username, password, list);
	}
}
