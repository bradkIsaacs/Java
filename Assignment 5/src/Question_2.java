import java.util.Stack;

public class Question_2 {

	public static void main(String[] args) {
		System.out.println(sameABs("carb"));
	}

	public static boolean sameABs(String str) {
		Stack<Character> s = new Stack<Character>();
		int i = 0;
		while (i < str.length()) {
			if (str.charAt(i) == 'a') {
				s.push(str.charAt(i));
			} else if (str.charAt(i) == 'b') {
				if (!s.isEmpty()) {
					s.pop();
				} else {
					return false;
				}
			}
			i++;
		}
		return (s.empty());
	}
}