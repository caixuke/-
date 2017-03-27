// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
// You are given a target value to search. If found in the array return its index, otherwise return -1.
// You may assume no duplicate exists in the array.
// Subscribe to see which companies asked this question.
public class Solution{
	public int search(int[] nums, int target){
		int lo = 0, hi = nums.length - 1;
		//find the index of the smallest value using binary search
		//Loop will terminate since mid < hi
		while(lo < hi){
			int mid = (lo + hi) / 2;
			if(nums[mid] > nums[hi]) lo = mid + 1;
			else hi = mid;
		}
		//lo == hi is the index of the smallest value and also the number of places rotated.
		int rot = lo;
		lo = 0;
		hi = nums.length - 1;
		while(lo <= hi){
			int mid = (lo + hi) / 2;
			int realmid = (mid + rot) % nums.length;
			if(nums[realmid] == target) return realmid;
			if(nums[realmid] < target) lo = mid + 1;
			else hi = mid - 1;
		}
		return -1;

	}
}

public class Solution{
	public int search(int[] nums, int target){
		int start = 0;
		int end = nums.length - 1;
		while(start < end){
			int mid = (start + end) / 2;
			if(nums[mid] == target)
				return mid;
			if(nums[start] <= nums[mid]){
				if(target < nums[mid] && target >= nums[start])
					end = mid - 1;
				else
					start = mid + 1;
			}
			if(nums[mid] <= nums[end]){
				if(target > nums[mid] && target <= nums[end])
					start = mid + 1;
				else
					end = mid + 1;
			}
		}
		return -1;
	}
}