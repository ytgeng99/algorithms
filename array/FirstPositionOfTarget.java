class FirstPositionOfTarget {
	public int findFirstPositon(int[] arr, int target){
		// consider corner case
		if (arr == null || arr.length == 0) {
			return -1;
		}

		// using binary search to find the first position of target in the array
		int start = 0;
		int end = arr.length - 1;
		while (start + 1 < end) {
			int mid = (start + end) / 2;
			if (arr[mid] >= target) {
				end = mid;
			}
			if (arr[mid] < target) {
				start = mid;
			}
		}

		if (arr[start] == target) {
			return start;
		}

		if (arr[end] == target) {
			return end;
		}
		return -1;
	}
}