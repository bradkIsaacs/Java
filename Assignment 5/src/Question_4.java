public class Question_4 {

	public static void main(String[] args) {
		int[] arr = {1,3, 7, 10};
		System.out.println(lookup(arr, 3));
	}

	public static int lookup(int[] nums, int target) {
		int i = 0;
		while (i < nums.length && nums[i] != target) {
			i++;
		}
		if (i < nums.length && nums[i] == target){
			return i;
		} else {
			return -1;
		}
	}
}