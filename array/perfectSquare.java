Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

// DP tabulation
class Solution {
    public int numSquares(int n) {
        if (n == 0) {
        	return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        // initial
        for (int i = 1; i * i <= n; i++) {
        	dp[i * i] = 1;
        }
        for (int i = 2; i <= n; i++) {
        	if (dp[i] != 0) {
        		continue;
        	}
        	int res = Integer.MAX_VALUE;
        	for (int j = 1; j * j <= i; j++) {
        		res = Math.min(res, dp[i - j * j] + 1);
        	}
        	dp[i] = res;
        }
        return dp[n];
    }
}


// Memorization
class Solution {
	int[] dp;

    public int numSquares(int n) {
        if (n == 0) {
        	return 0;
        }
        dp = new int[n + 1];
        for (int i = 0; i * i <= n; i++) {
        	dp[i * i] = 1;
        }
        return helper(n);
    }
    private int helper(int n) {
    	if (n == 1) {
    		return 1;
    	}
    	if (dp[n] != 0) {
    		return dp[n];
    	}
    	int res = Integer.MAX_VALUE;
    	for (int i = 1; i * i <= n; i++) {
    		res = Math.min(res, helper(n - i * i) + 1);
    	}
    	dp[n] = res;
    	return res;
    }
}