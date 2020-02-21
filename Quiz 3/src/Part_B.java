/* 
 * My code performs the push, pop, findMiddle, deleteMiddle at O(1) complexity
 * by only looking for single element that has a index that can be calculated 
 * eliminating the need to search the entire list. Making the complexity O(1). 
 */

import java.util.LinkedList;

public class Part_B {
	
	static LinkedList<Integer> list = new LinkedList<Integer>();

	public static void main(String[] args) {
		push(5);
		push(20);
		push(15);
		push(10);
		push(17);
		printStack();
		System.out.println(findMiddle());
		deleteMiddle();
		printStack();
		System.out.println(findMiddle());
		pop();
		printStack();
	}
	
	public static void printStack() {
		System.out.println("Bottom--------");
		for(int i = 0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
		System.out.println("Top--------");
	}
	
	public static void push(int data){
		list.add(data);
	}
	
	public static void pop(){
		list.remove(list.size()-1);
	}
	
	public static int findMiddle(){
		return list.get((list.size()-1)/2);
	}
	
	public static void deleteMiddle(){
		list.remove((list.size()-1)/2);
	}

}
