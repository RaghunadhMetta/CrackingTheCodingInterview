package RecursionAndDynamicPrograming;

public class KadaneAlgorithm {
	public int maxProfit(int[] prices) {
        int maxValues[] = new int[prices.length];
        int highestValue=prices[prices.length-1];
        int maxProfit=Integer.MIN_VALUE;
        for(int i=prices.length-1;i>=0;i--){
            
            maxValues[i]=Math.max(prices[i],highestValue);
            highestValue =  maxValues[i];
        }
        for(int j=0;j<prices.length;j++){
            maxProfit = Math.max(maxProfit,(maxValues[j]-prices[j]));
        }
        return maxProfit;
    }
	public static void main(String[] args) {
		//assume atlease on positive number
		int array[]= {7,1,5,3,6,4};
		int sum=array[0];
		int finalAnswer=array[0];
		for(int i=1;i<array.length;i++) {
			sum = Math.max(sum, (sum+array[i]));
			finalAnswer = Math.max(sum, finalAnswer);
			
		}
		KadaneAlgorithm k = new KadaneAlgorithm();
		System.out.println(k.maxProfit(array));
		System.out.println(finalAnswer);
		
	}

}
