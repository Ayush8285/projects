package simpledotcomgame;

public class SimpleDotComGameArray {
	public static void main(String[] args) {
		int numOfGuesses = 0;
		GameHelper helper = new GameHelper();
		
		SimpleDotComWithArray theDotCom = new SimpleDotComWithArray();
		int random = (int)(Math.random()*5);
		int[] locations = {random,random+1,random+2};
	
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
