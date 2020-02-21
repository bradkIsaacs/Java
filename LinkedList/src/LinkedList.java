public class LinkedList {
	Node head;
	
	public void addNodeInbetween(Node prevNode, String data){
		Node methods = new Node();
		methods.data = data;
		methods.next = null;
		if(prevNode == null){
			System.out.println("To this given posision this node cannot be insertesd");
			return;
		}
		methods.next = prevNode.next;
		prevNode.next = methods;
	}
	
	public Node insertNode(String data, int position){
		Node temp = new Node();
		temp.next = head;
		return null;
	}

	
	public static void main(String[] args){
		
	}
}