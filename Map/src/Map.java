import java.util.*;

public class Map {
	public static void main(String[] main) {
		HashMap<String, String> studentList = new HashMap<String, String>();
		studentList.put("Andrew", "1554");
		studentList.put("Lynda", "5254");
		studentList.put("Elise", "8472");
		studentList.put("Dan", "1861");
		Iterator irKey = studentList.keySet().iterator();
		Iterator irAll = studentList.entrySet().iterator();
		while (irKey.hasNext()) {
			System.out.println("Key is: " + irKey.next());
		}
		while (irAll.hasNext()) {
			System.out.println("Key is: " + irAll.next());
		}
	}

	public boolean searchElement(HashMap<String, String> studentList, String key) {
		return studentList.containsKey(key);
	}

}