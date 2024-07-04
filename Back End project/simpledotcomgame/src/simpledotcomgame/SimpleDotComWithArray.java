package simpledotcomgame;

//with array it have a bug
//so we use arraylist to remove that bug

public class SimpleDotComWithArray {
	int[] locationCells;
	int numOfHits = 0;
	
	public void setLocationCells(int[] locationCells) {
		this.locationCells = locationCells;
	}
	
	public String checkYourself(String stringGuess) {
		int guess = Integer.parseInt(stringGuess);
		String result = "miss";
		for(int cell : locationCells) {
			if(guess == cell) {
				result = "hit";
				numOfHits++;
				break;
			}
		}
		
		if(numOfHits == locationCells.length) {
			result = "kill";
		}
		System.out.println(result);
		return result;
	}
	
}
