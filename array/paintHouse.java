There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

All costs are positive integers.

 
Example
Given costs = [[14,2,11],[11,14,5],[14,3,10]] return 10

house 0 is blue, house 1 is green, house 2 is blue, 2 + 5 + 3 = 10

// DP - tabulation
public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        if (costs == null || costs.length == 0) {
        	return 0;
        }
        int n = costs.length;
        int[][] dp = new int[n][costs[0].length];
       	dp[0][0] = costs[0][0];
       	dp[0][1] = costs[0][1];
       	dp[0][2] = costs[0][2];
       	for (int i = 1; i < n; i++) {
       		for (int j = 0; j < 3; j++) {
       			dp[i][j] = Integer.MAX_VALUE;
       			// dp[i][0] = Math.min(dp[i - 1][1] + dp[i - 2][2]) + costs[i][j];
       			// dp[i][1] = Math.min(dp[i - 1][0] + dp[i - 2][2]) + costs[i][j];
       			// dp[i][2] = Math.min(dp[i - 1][0] + dp[i - 2][1]) + costs[i][j];
       			for (int k = 0; k < 3; k++) {
       				if (j != k) {
       					dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + costs[i][j]);
       				}
       			}
       		}
       	}
       	return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}


// Memorization
public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    int[][] dp;
    public int minCost(int[][] costs) {
        // write your code here
        if (costs == null || costs.length == 0) {
            return 0;
        }
    	dp = new int[costs.length][3];

    	int red = helper(costs, costs.length - 1, 0);
    	int blue = helper(costs, costs.length - 1, 1);
    	int green = helper(costs, costs.length - 1, 2);
    	return Math.min(red, Math.min(blue, green));
    }
    private int helper(int[][] costs, int numHouse, int color) {

    	if (numHouse == 0) {
    		return costs[0][color];
    	}
    	if (dp[numHouse][color] != 0) {
    		return dp[numHouse][color];
    	}
    	int result = Integer.MAX_VALUE;
    	for (int i = 0; i < costs[0].length; i++) {
    		if (i != color) {
    			result = Math.min(result, helper(costs, numHouse - 1, i)  + costs[numHouse][color]);
    		}
    	}
    	dp[numHouse][color] = result;

    	return result;
    }
}