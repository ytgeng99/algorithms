Given two array of integers(the first array is array A, the second array is array B), now we are going to find a element in array A which is A[i], and another element in array B which is B[j], so that the difference between A[i] and B[j] (|A[i] - B[j]|) is as small as possible, return their smallest difference.

Have you met this question in a real interview? 
Example
For example, given array A = [3,6,7,4], B = [2,8,9,3], return 0


public class Solution {
    /**
     * @param A: An integer array
     * @param B: An integer array
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        int i = 0;
        int j = 0;
        int mini = Integer.MAX_VALUE;
        Arrays.sort(A);
        Arrays.sort(B);
        while (i < A.length && j < B.length) {
        	mini = Math.min(mini, Math.abs(A[i] - B[j]));
        	if (A[i] < B[j]) {
        		i++;
        	} else {
        		j++;
        	}
        }
        return mini;
    }
}