import java.util.*;

public class ArrayManiulation {
	public Customer[] inputCustomer(Customer[] custlist, Scanner scn) {
		String id, name;
		int i = 0;
		while (scn.hasNext()) {
			System.out.print("Enter your ID:");
			id = scn.next();
			System.out.print("Enter your Name:");
			name = scn.next();
			custlist[i] = new Customer(id, name);
			i++;
		}
		return custlist;
	}
}