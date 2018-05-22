Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 Notice
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

Have you met this question in a real interview? 
Example
Given the following triangle:

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

// traverse
public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    int minSum = Integer.MAX_VALUE;
    public int minimumTotal(int[][] triangle) {
        // write your code here
        int sum = 0;
        int x = 0;
        int y = 0;
    	helper(triangle, sum, x, y);
    	return minSum;
    }
    private void helper(int[][] triangle, int sum, int x, int y) {
    	// 递归的出口
    	// if (x >= triangle.length || y >= triangle[0].length) {
    	// 	return;
    	// }
    	if (x == triangle.length) {
    		minSum = Math.min(minSum, sum);
    		return;
    	}
    	// 递归的拆解
    	// if (minSum > sum) {
    	// 	minSum = sum;
    	// }
    	helper(triangle, sum + triangle[x][y], x + 1, y);
    	helper(triangle, sum + triangle[x][y], x + 1, y + 1);
    }
}

// divide & conquer
public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        int x = 0;
        int y = 0;
        return helper(triangle, x, y);
        
    }
    private int helper(int[][] triangle, int x, int y) {
    	if (x >= triangle.length) {
    		return 0;
    	}
    	int left = helper(triangle, x + 1, y);
    	int right = helper(triangle, x + 1, y + 1);
    	
    	int minSum = triangle[x][y] + Math.min(left, right);
    	
    	return minSum;
    }
}


// version 3： dynamic programming(递归)
// memorization： 解决重复问题（即问题之间有交集有联系）

public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimum;
    public int[][] hash;
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }
        hash = new int[triangle.length][triangle.length];
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle.length; j++) {
                hash[i][j] = Integer.MAX_VALUE;
            }
        }
        minimum = divideConquer(triangle, 0, 0);
        return minimum;
    }

    private int divideConquer(int[][] triangle, int x, int y){
        if (x == triangle.length) {
            return 0;
        }

        if (hash[x][y] != Integer.MAX_VALUE) {
            return hash[x][y];
        }
        int left = divideConquer(triangle, x + 1, y);
        int right = divideConquer(triangle, x + 1, y + 1);
        hash[x][y] = triangle[x][y] + Math.min(left, right);
        return hash[x][y];
    }
}

// dynamic programming
// Bottom-Up
// 思路：
// 状态定义
// f[i][j]表示从最后一层走到当前(i, j)位置的最小路径和
// 初始化，终点先有值
// for (int i = 0; i < n; i++) {
// 	f[n - 1][i] = arr[n - 1][i];
// }

// 循环递推求解
// for (int i = n - 2; i >= 0; i--) {
// 	for (int j = 0; j <= i; j++) {
// 		f[i][j] = Math.min(f[i + 1][j],f[i + 1][j + 1]) + arr[i][j];
// 	}
// }

// 求结果：起点
// f[0][0]
public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }
        
        // state: f[x][y] = minimum path value from x,y to bottom
        int n = triangle.length;
        int[][] f = new int[n][n];
        
        // initialize 
        for (int i = 0; i < n; i++) {
            f[n - 1][i] = triangle[n - 1][i];
        }
        
        // bottom up
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                f[i][j] = Math.min(f[i + 1][j], f[i + 1][j + 1]) + triangle[i][j];
            }
        }
        
        // answer
        return f[0][0];
    }
}






// version 4: dynamic programming(多重循环)
// top to bottom
// 空间换时间

// 思路
// 初始化：
// f[0][0] = arr[0][0];

// // 初始化三角形的左边和右边
// for (int i = 1; i < n; i++) {
// 	f[i][0] = f[i - 1][0] + arr[i][0];
// 	f[i][i] = f[i - 1][i - 1] + arr[i][i];
// }

// // top down

// for (int i = 1; i < n; i++) {
// 	for (int j = 1; j < i; j++) {
// 		f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - 1]) + arr[i][j];
// 	}
// }

// Math.min(f[n - 1][0], f[n - 1][1], f[n -1][2]....);
// top-down
public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }
        
        // state: f[x][y] = minimum path value from 0,0 to x,y
        int n = triangle.length;
        int[][] f = new int[n][n];
        
        // initialize 
        f[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][0] + triangle[i][0];
            f[i][i] = f[i - 1][i - 1] + triangle[i][i];
        }
        
        // top down
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - 1]) + triangle[i][j];
            }
        }
        
        // answer
        int best = f[n - 1][0];
        for (int i = 1; i < n; i++) {
            best = Math.min(best, f[n - 1][i]);
        }
        return best;
    }
}


