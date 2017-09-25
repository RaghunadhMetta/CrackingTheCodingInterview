package arryaAndStrings;

import java.util.HashSet;

public class MaximumSumSubArray {
	class Storage{
		int begin;
		int end;
		int maxValue;
		public Storage(int begin,int end,int maxValue) {
			this.begin=begin;
			this.end = end;
			this.maxValue = maxValue;
		}
	}
	public HashSet<Storage> map = new HashSet<>();
	public int kadaneAlgo(int[] nums) {
		int sum=0;
		int finalAnswer =0;
		for(int i=0;i<nums.length;i++) {
			if(sum+nums[i]>=0) {
				sum = sum+nums[i];
			}
			else {
				sum=0;
			}
			finalAnswer=Math.max(finalAnswer, sum);
		}
		return finalAnswer;
	}
	public int calcMaxSum(int[] array, int begin, int end) {
		if(begin==end) {
			return array[begin];
		}
		int mid = (begin+end)/2;
		int LS = calcMaxSum(array, 0, mid);
		int RS = calcMaxSum(array, mid+1, end);
		int rightSum =Integer.MIN_VALUE;
		int leftSum=Integer.MIN_VALUE;
		int sum =0;
		int finalAnswer=0;
		for(int i=mid+1;i<=end;i++) {
			sum =sum+array[i];
			rightSum = Math.max(sum, rightSum);
		}
		sum =0;
		for(int j=mid;j>=0;j--) {
			sum = sum+array[j];
			leftSum = Math.max(sum, leftSum);
		}
		finalAnswer = Math.max(RS, LS);
		finalAnswer = Math.max(finalAnswer, (leftSum+rightSum));
		return finalAnswer;
	}

	public static void main(String[] args) {
		int nums[] = {1};
		int i;
		int sum=Integer.MIN_VALUE;
		MaximumSumSubArray MSS = new MaximumSumSubArray();
		 for(i=0;i<nums.length;i++) {
			 if(nums[i]<0) {
				 sum = Math.max(sum, nums[i]);
			 }
			 else {
				 break;
			 }
		 }
	    if(i==nums.length) {
	    	System.out.println(sum);
	    }
	    else {
		int maxSum = MSS.kadaneAlgo(nums);
		System.out.println(maxSum);
	    }   
	}

}
