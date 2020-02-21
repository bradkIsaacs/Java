import java.util.ArrayList;

public class Question7 {
	
	public int mode(ArrayList<String> list){
		int tempCount = 0, mode = 0;
		if(list.size() == 0){
			return 0;
		}
		//Find mode of each index
		for(int i = 0; i<list.size(); i++){
			for(int j = 0; j<list.size(); j++){
				//if there is a match 
				if(list.get(i).equals(list.get(j))){
					tempCount++;
					//If tempCount > mode, mode = tempCount
					if(tempCount > mode){
						mode = tempCount;
					}
				}
			}
		}
		if(mode == 0){
			return 1;
		}
		else{
			return mode;
		}
	}

}
