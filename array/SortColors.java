public class Solution {
    /*
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
        	return;
        }

        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i <= right) {
        	if (nums[i] == 0) {
        		swap(nums, left, i);
        		left++;
        		i++;
        	} else if (nums[i] == 1) {
        		i++;
        	} else {
        		swap(nums, i, right);
        		right--;
        	}

        }
    }
    private void swap(int[] arr, int i, int j){
    	int temp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = temp;
    }
}