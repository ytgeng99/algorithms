public class FirstBadVersion {
	public int findFirstBadVersion(int n){
		int start = 0, end = n;
		while(start + 1 < end){
			int mid = (start + end) / 2;
			if (SVNRepo.isBadVersion(mid)) {
				end = mid;
			} else {
				start = mid;
			}
		}

		if (SVNRepo.isBadVersion(start)) {
			return start;
		}
		return end;
	}
}