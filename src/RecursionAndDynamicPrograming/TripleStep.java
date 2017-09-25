package RecursionAndDynamicPrograming;

import java.util.HashMap;

public class TripleStep {
	private HashMap<Integer, Integer> map = new HashMap<>();
	private int calcPossibleWays(int numberOfSteps) {
		if(map.containsKey(numberOfSteps)) {
			return map.get(numberOfSteps);
		}
		if(numberOfSteps<1) {
			return 0;
		}
		if(numberOfSteps==1) {
			return 1;
		}
		map.put(numberOfSteps, 1+calcPossibleWays(numberOfSteps-1)+calcPossibleWays(numberOfSteps-2)+calcPossibleWays(numberOfSteps-3));
		return map.get(numberOfSteps);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numberOfSteps = 4;
		TripleStep tripleStep = new TripleStep();
		int numWays=tripleStep.calcPossibleWays(numberOfSteps);
		System.out.println(numWays);
	}

}
