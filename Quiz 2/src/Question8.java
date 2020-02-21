import java.util.ArrayList;

public class Question8 {
	
	public void highlyPaidWomen(ArrayList<String> couple, ArrayList<Integer> salary){
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> money = new ArrayList<Integer>();
		for(int i=0; i<couple.size(); i++){
			names.add(couple.get(i));
			money.add(salary.get(i));
		}
		for(int i=1; i<couple.size()+1; i+=2){
			if(money.get(i) > money.get(i+1)){
				System.out.println(" "+names.get(i)+" makes "+money.get(i));
			}
		}
	}
}
