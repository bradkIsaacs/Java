import java.util.*;

public class List {
	
	public static void main(String[] args){
		LinkedList<Integer> myList = new LinkedList<Integer>();
		myList.add(1);
		myList.add(2);
		myList.add(3);
		int count = count(myList, 2);
		System.out.println(count);
		int lastNode = getNth(myList, 2);
		System.out.println(lastNode);
		int a = pop(myList);
		System.out.println(a);
		int b = pop(myList);
		System.out.println(b);
		int c = pop(myList);
		System.out.println(c);
		int len = Length(myList);
		System.out.println("Length == "+len);
		ArrayList<Integer> emptyList = new ArrayList<Integer>();
		InsertNth(emptyList, 0, 13);
		System.out.println(emptyList);
		InsertNth(emptyList, 1, 42);
		System.out.println(emptyList);
		InsertNth(emptyList, 1, 5);
		System.out.println(emptyList);
	}
	//Method 1
	public static int count(LinkedList<Integer> myList, int num) {
		int mode = 0;
		for (int i = 0; i<myList.size(); i++){
			if (myList.get(i) == num){mode++;}
		}
		return mode;
	}
	//Method 2
	public static int getNth(LinkedList<Integer> myList, int num) {
		if (num > myList.size()-1){return -1;}
		return myList.get(num);
	}
	//Method 3
	public static int pop(LinkedList<Integer> myList) {
		int head = myList.get(0);
		myList.remove(0);
		return head;
	}
	public static int Length(LinkedList<Integer> myList) {
		return myList.size();
	}
	//Method 4
	public static void InsertNth(ArrayList<Integer> emptyList, int index, int data) {
		emptyList.add(index, data);
	}	
}