A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 7 x 3 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:

Input: m = 7, n = 3
Output: 28


// DP
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // initial state
        for (int i = 0; i < n; i++) {
        	dp[0][i] = 1;
        }

        for (int i = 0; i < m; i++) {
        	dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        	}
        }
        return dp[m - 1][n - 1];
    }
}

// Memorization
class Solution {
	int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        return helper(m, n, 0, 0);
    }
    private int helper (
    	int m,
    	int n,
    	int row,
    	int col) {

    	if (row == m - 1 && col == n - 1) {
    		return 1;
    	}
    	if (row >= m || col >= n) {
    		return 0;
    	}
    	if (dp[row][col] != 0) {
    		return dp[row][col];
    	}
    	int left = helper(m, n, row, col + 1);
    	int right = helper(m, n, row + 1, col);
    	int result = left + right;
    	dp[row][col] = result;
    	return result;
    }
}