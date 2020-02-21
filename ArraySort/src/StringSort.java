import java.util.Arrays;

public class StringSort {
	public static void main(String[] args) {
		String[] test = {"Chuck","Dana","Beth","Brad"};
		sort(test);
	}
	private static void sort(String[] test) {
		Arrays.sort(test);
		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
		}
	}
}
