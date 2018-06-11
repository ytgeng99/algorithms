public class Solution {
    /*
     * @param nums: an integer array
     * @return: 
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
        	return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
        	for (int j = i; j < nums.length - 1; j++) {
	        	if (nums[j] == 0) {
	    			int tem = nums[j];
	    			nums[j] = nums[j + 1];
	    			nums[j + 1] = tem;	
	        	}
	        }
        }
        
    }
}



// version 2
    /**
     * 本参考程序来自九章算法，由 @九章算法 提供。版权所有，转发请注明出处。
     * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
     * - 现有的面试培训课程包括：九章算法班，系统设计班，算法强化班，Java入门与基础算法班，Android 项目实战班，
     * - Big Data 项目实战班，算法面试高频题班, 动态规划专题班
     * - 更多详情请见官方网站：http://www.jiuzhang.com/?source=code
     */ 

public class Solution {
    /**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
    public void moveZeroes(int[] nums) {
        // Write your code here
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }
}