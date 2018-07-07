Give you an array of 01. Find the minimum number of flipping steps so that the array meets the following rules:
The back of 1 can be either1 or 0, but0 must be followed by 0.

// DP - tabulation
public class Solution {
    /**
     * @param nums: the array
     * @return: the minimum times to flip digit
     */
    public int flipDigit(int[] nums) {
        // Write your code here
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
    	int[][] dp = new int[nums.length + 1][2];
    	// initial
    	dp[0][0] = 0;
    	dp[0][1] = 0;

    	for (int i = 1; i <= nums.length; i++) {
    		if (nums[i - 1] == 0) {
    			dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
    			dp[i][1] = dp[i - 1][1] + 1;
    		}
    		if (nums[i - 1] == 1) {
    			dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
    			dp[i][1] = dp[i - 1][1];
    		}
    	}

    	return Math.min(dp[nums.length][0], dp[nums.length][1]);
    }
}


// Memorization
public class Solution {
    /**
     * @param nums: the array
     * @return: the minimum times to flip digit
     */
    int[][] dp;
    public int flipDigit(int[] nums) {
        // Write your code here
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
    	dp = new int[nums.length][2];
    	for (int i = 0; i < nums.length; i++) {
    		for (int j = 0; j < 2; j++) {
    			dp[i][j] = -1;
    		}
    	}
    	int left = helper(nums, nums.length - 1, 0);
    	int right = helper(nums, nums.length - 1, 1);
    	
    	return Math.min(left, right);
    }
    private int helper (int[] nums, int idx, int digit) {
    	if (idx < 0) {
    		return 0;
    	}

    	if (dp[idx][digit] != -1) {
    		return dp[idx][digit];
    	}	
    	int result = 0;
    	if (digit == 0) {
    		if (nums[idx] == 1) {
    			result = Math.min(helper(nums, idx - 1, 0), helper(nums, idx - 1, 1)) + 1;
    		} else {
    			result = Math.min(helper(nums, idx - 1, 0), helper(nums, idx - 1, 1));
    		}
    	} else {
    		if (nums[idx] == 0) {
    			result = helper(nums, idx - 1, 1) + 1;
    		} else {
    			result = helper(nums, idx - 1, 1);
    		}
    	}
    	dp[idx][digit] = result;
    	return result;
    }
}