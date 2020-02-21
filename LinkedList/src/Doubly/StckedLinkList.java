package Doubly;

public class StckedLinkList {

	protected Node top;
	protected int size;
	
	public StckedLinkList() {
		super();
		top = null;
		size = 0;
	}
	public boolean isEmpty(){
		return top == null;
	}
	public int getSize(){
		return size;
	}
	public void push(String data){
		Node ptr = new Node(data, null);
		if(top == null){
			top = ptr;
		}else{
			ptr.next = top;
			top = ptr;
		}
		size++;
	}
	public String pop(){
		return null;
	}
}
