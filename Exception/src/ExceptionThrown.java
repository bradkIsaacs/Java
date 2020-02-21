public class ExceptionThrown {

	public static int dividebyZero(int a, int b) {
		int i = a / b;
		return i;
	}

	public static int computeDivision(int c, int d) {
		int result = 0;
		try {
			result = dividebyZero(c, d);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public static void main(String[] args) {
		int a = 20;
		int b = 0;
		try {
			computeDivision(a, b);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}