// Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.// Your algorithm's runtime complexity must be in the order of O(log n).// If the target is not found in the array, return [-1, -1].// For example,// Given [5, 7, 7, 8, 8, 10] and target value 8,// return [3, 4].public class Solution{	public int[] searchRange(int[] nums, int target){		int start = Solution.firstGreaterEqual(A, target);		if(start == nums.length || nums[start] != target)			return new int[]{-1, -1};		return new int[]{start, Solution.firstGreaterEqual(A, target + 1) - 1};	}	//find the first number that is greater than or equal to target	private static int firstGreaterEqual(int[] A, int target){		int low = 0, high = A.length;		while(low < high){			int mid = low + ((high - low) >> 1);			//low <= mid < high			if(A[mid] < target)				low = mid + 1;			else high = mid;		}		return low;	}}