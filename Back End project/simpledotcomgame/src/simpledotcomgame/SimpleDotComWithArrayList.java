package simpledotcomgame;

import java.util.ArrayList;

public class SimpleDotComWithArrayList {
	private ArrayList<String> locationCells;

	public void setLocationCells(ArrayList<String> locations) {
		this.locationCells = locations;
	}
	
	public String checkYourself(String userInput) {
		String result = "miss";
		
		int index = locationCells.indexOf(userInput);    //if not present then indexOf return -1
		
		if(index >= 0) {
			
			locationCells.remove(index);
			
			if(locationCells.isEmpty()) {
				System.out.println("kill");
				return "kill";
			}else {
				System.out.println("hit");
				return "hit";
			}
		}
		System.out.println("miss");
		return result;
	}
	
	
}
