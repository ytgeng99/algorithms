
// version 1
public class Solution {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        if (nums.length == 0) {
        	return 0;
        }
        
        Arrays.sort(nums);

        int len = 0;
        int i = 0;
        while (i < nums.length) {
        	if (nums[i] != nums[len]) {
        		nums[++len] = nums[i];
        	}

        	i++;
        }

        return len + 1;
    }
}


public class Solution {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        // Write your code here
        HashSet<Integer> mp = new HashSet<Integer>();
        for (int i = 0; i < nums.length; ++i)
            mp.add(nums[i]);

        int result = 0;
        Iterator<Integer> it = mp.iterator();
        while (it.hasNext()) {
        	nums[result++] = it.next();
        }
           
        return result;
    }
}

// Iterator<> it = mp.iterator();
// Solution.java:15: error: incompatible types
// nums[result++] = it.next();
// ^
// required: int
// found: Object
// 1 error


// solution: Iterator<> it = mp.iterator();

// Version 2:
public class Solution {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        // Write your code here
        HashMap<Integer, Boolean> mp = new HashMap<Integer, Boolean>();
        for (int i = 0; i < nums.length; ++i)
            mp.put(nums[i], true);

        int result = 0;
        for (Map.Entry<Integer, Boolean> entry : mp.entrySet())
            nums[result++] = entry.getKey();
        return result;
    }
}
