function maximumSubarrayII(arr) {
	if (arr === null || arr.length === 0) {
		return 0;
	}

	// firstly record the largest subarray sum from left to right
	var dpLeft = [];
	var dpRight = [];
	dpLeft[0] = arr[0];
	// var max = 0;
	for(let i = 1; i < arr.length; i++) {
		dpLeft[i] = Math.max(arr[i], dpLeft[i - 1] + arr[i]);
		// max = Math.max(dpLeft[i], max);
	}

	// record the largest subarray sum from right to left
	dpRight[arr.length - 1] = arr[arr.length - 1];
	for(let i = arr.length - 2; i >=0; i--) {
		dpRight[i] = Math.max(arr[i], arr[i] + dpRight[i + 1]);
	}


	// find the sum within dpLeft[], dpRight[] based on a separated point i;
	var max = -Infinity;
	for(let i = 0; i < arr.length - 1; i++) {
		let leftMaxSum = dpLeft[i];

		let rightMaxSum = -Infinity;
		for(let j = arr.length - 1; j > i; j--) {
			rightMaxSum = Math.max(max, dpRight[j]);
		}

		max = Math.max(max, leftMaxSum + rightMaxSum);
	}

	return max;
}

// java 
public class Solution {
    /*
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(List<Integer> nums) {
        // write your code here
        int[] left = new int[nums.size()];
        int[] right = new int[nums.size()];
        left[0] = nums.get(0);
        // int maxSum = Integer.MIN_VALUE;
        // int currentSum = 0;
        for (int i = 1; i < nums.size();i++) {
            left[i] = Math.max(nums.get(i), nums.get(i) + left[i - 1]);
        }

        right[nums.size() - 1] = nums.get(nums.size() - 1);
        for (int i = nums.size() - 2; i >= 0;i--) {
            right[i] = Math.max(nums.get(i), nums.get(i) + right[i + 1]);
        }
        
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size() - 1; i++) {
            int leftMaxSum = left[i];

            int rightMaxSum = Integer.MIN_VALUE;
            for(int j = nums.size() - 1; j > i; j--) {
            	rightMaxSum = Math.max(rightMaxSum, right[j]);
            }
            maxSum = Math.max(maxSum, leftMaxSum + rightMaxSum);
        }
        return maxSum;
    }
}