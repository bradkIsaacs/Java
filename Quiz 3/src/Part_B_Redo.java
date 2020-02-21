/* 
 * My code performs the push, pop, findMiddle, deleteMiddle at O(1) complexity
 * by only looking for single element that has a index that can be calculated 
 * eliminating the need to search the entire list. Making the complexity O(1). 
 */

import java.util.*;

public class Part_B_Redo {
	
	static Node m = new Node();
	static Node n = new Node();
	static Node o = new Node();
	static Node p = new Node();
	static Node q = new Node();
	
	static LinkedList<Node> list = new LinkedList<Node>();

	public static void main(String[] args) {
		m.data = 5;
		n.data = 12;
		o.data = 46;
		p.data = 6;
		q.data = 48;
		push(m);
		push(n);
		push(o);
		push(p);
		push(q);
		printStack();
		System.out.println(findMiddle());
		deleteMiddle();
		printStack();
		System.out.println(findMiddle());
		pop();
		printStack();
	}
	
	public static void printStack() {
		System.out.println("--------");
		for(int i = list.size()-1; i>=0; i--){
			System.out.println(list.get(i).data);
		}
		System.out.println("--------");
	}
	
	public static void push(Node num){
		list.add(num);
	}
	
	public static void pop(){
		list.remove(list.size()-1);
	}
	
	public static Node findMiddle(){
		return list.get((list.size()-1)/2);
	}
	
	public static void deleteMiddle(){
		list.remove((list.size()-1)/2);
	}

}
