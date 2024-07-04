package simpledotcomgame;

import java.util.ArrayList;


public class SimpleDotComGameArrayList {
	public static void main(String[] args) {
		int numOfGuesses = 0;
		GameHelper helper = new GameHelper();
		
		SimpleDotComWithArrayList theDotCom = new SimpleDotComWithArrayList();
		int random = (int)(Math.random()*5);
		ArrayList<Integer> loc = new ArrayList<Integer>();
		for(int i=0 ; i<3;i++) {
			loc.add(random);
			random++;
		}
		ArrayList<String> locations = new ArrayList<String>();
		for(int i=0;i<3;i++) {
			locations.add(String.valueOf(loc.get(i)));
		}
		
		
//		String random1 = String.valueOf(random);   //Convert int into String
		
		theDotCom.setLocationCells(locations);
		
		boolean isAlive = true;
		
		while(isAlive == true) {
			String guess = helper.getUserInput("enter any number");
			String result = theDotCom.checkYourself(guess);
			numOfGuesses++;
			if(result.equals("kill")) {
				isAlive = false;
				System.out.println("you took "+numOfGuesses+" guesses");
			}
		}
		
	}
}
