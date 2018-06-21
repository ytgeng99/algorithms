Given an unsorted integer array, find the first missing positive integer.
/**
 * @param A: An array of integers
 * @return: An integer
 */
const firstMissingPositive = function (A) {
    if (A === null || A.length === 0) {
    	return 1;
    }
    var hashset = new Set();
    for (let ele of A) {
    	hashset.add(ele);
    }
    var start = 1;
    for (let i = 0; i < A.length; i++) {
    	if (hashset.has(start)) {
    		start++;
    	} else {
    		result = start;
    		return result;
    	}
    }
    return start;
}



// java version
public class Solution {

    public int firstMissingPositive(int[] A) {
        if (A == null) {
            return 1;
        }

        for (int i = 0; i < A.length; i++) {
            while (A[i] > 0 && A[i] <= A.length && A[i] != (i+1)) {
                int tmp = A[A[i]-1];
                if (tmp == A[i]) {
                    break;
                }
                A[A[i]-1] = A[i];
                A[i] = tmp;
            }
        }

        for (int i = 0; i < A.length; i ++) {
                if (A[i] != i + 1) {
                    return i + 1;
                }
        }

        return A.length + 1;
    }
}