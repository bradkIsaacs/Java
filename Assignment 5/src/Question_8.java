public class Question_8 {

	static int[] test1 = { -1, 2, 3, 3 };
	static int[] test2 = { -7, 3, 99, -10, 0, 0, 43, 10, 20, 30, 5 };
	static int[] test3 = { 3, 2, 1 };
	static int[] test4 = { 32 };
	static int[] test5 = {};

	public static void main(String[] args) {
		System.out.println(sortedSequenceLength(test1));
		System.out.println(sortedSequenceLength(test2));
		System.out.println(sortedSequenceLength(test3));
		System.out.println(sortedSequenceLength(test4));
		System.out.println(sortedSequenceLength(test5));
	}

	public static int sortedSequenceLength(int[] list) {
		if (list.length == 0) {
			return 0;
		}
		int max = 1;
		int count = 1;
		for (int i = 1; i < list.length; i++) {
			if (list[i] >= list[i - 1]) {
				count++;
			} else {
				count = 1;
			}
			if (count > max) {
				max = count;
			}
		}
		return max;
	}
}