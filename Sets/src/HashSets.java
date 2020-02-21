import java.util.*;

public class HashSets {
	public static void main(String[] args){
		HashSet <String> hSet = new HashSet <String>();
		hSet.add("Aaaa");
		hSet.add("Bbbb");
		hSet.add("Cccc");
		hSet.add("Dddd");
		
		Iterator <String> itr = hSet.iterator();
		while (itr.hasNext()){
			System.out.println(itr.next());
		}
	}
	public void addHashMap(HashMap <Integer,String> hMap){
		hMap.put(1, "Aaaa");
		hMap.put(1, "Bbbb");
		hMap.put(1, "Cccc");
		Set set = hMap.entrySet();
		Iterator iset = set.iterator();
		while (iset.hasNext()){
			Map.Entry mentry = (Map, Entry) ((HashSet<String>) iset).iterator();
			System.out.println(mentry);
		}
		
	}
}

