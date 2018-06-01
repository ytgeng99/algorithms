public class Solution {
    /*
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
        	return 0;
        }

        int kthsmallest = 0;
        int left = 0;
        int right = nums.length - 1;
        int smallestIndex = 0;
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
        	if (smallest > nums[i]) {
        		smallestIndex = i;
        		smallest = nums[smallestIndex];
        	}
        }
        while (k >= 1 && left < right) {
        	if (smallest <= nums[left] && smallest <= nums[right] && nums[left] <= nums[right]) {
        		k--;
        		smallest = nums[left];
        		
        		right--;
        	} else {
        		k--;
        		smallest = nums[right];
        		
        		left++;
        	}
        }

        return smallest;
    }
}


// jiu zhang -- quick sort

    /**
     * 本参考程序来自九章算法，由 @九章算法 提供。版权所有，转发请注明出处。
     * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
     * - 现有的面试培训课程包括：九章算法班，系统设计班，算法强化班，Java入门与基础算法班，Android 项目实战班，
     * - Big Data 项目实战班，算法面试高频题班, 动态规划专题班
     * - 更多详情请见官方网站：http://www.jiuzhang.com/?source=code
     */ 

class Solution {
    /*
     * @param k an integer
     * @param nums an integer array
     * @return kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    public int quickSelect(int[] A, int start, int end , int k) {

        if (start == end)
            return A[start];
        
        int left = start, right = end;
        int pivot = A[(start + end) / 2];

        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }

            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                
                left++;
                right--;
            }
        }

        if (right >= k && start <= right)
            return quickSelect(A, start, right, k);
        else if (left <= k && left <= end)
            return quickSelect(A, left, end, k);
        else
            return A[k];
    }
};