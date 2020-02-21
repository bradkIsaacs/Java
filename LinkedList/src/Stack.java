
public class Stack {

	int[] stack = new int[10];
	int sTop;
	int numEl = 0;
	
	public void stackPush(int el){
		if(numEl == stack.length){
			System.out.print("Stack is full");
		}else{
			stack[sTop] = el;
			sTop++;
		}
	}
	
	public int stackPop(){
		if(numEl > 0){
			return stack[sTop];
		}else{
			System.out.print("Stack is empty");
			return 0;
		}
	}
}
