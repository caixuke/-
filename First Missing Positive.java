/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 */
//The key here is to use swapping to keep constant space and also make use of the length of the array, which means there can be at most n positive integers. So each time we encounter an valid integer, find its correct position and swap. Otherwise we continue.
public class Solution{
	public int firstMissingPositive(int[] nums){
		int i;
		for(i = 0; i < nums.length; i++){
			if(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]){
				swap(nums, i, nums[i] - 1);//nums[i]-1是nums[i]这个数应该在的数组位置。如果相等的话，一种情况是这个数字重复了，另一种情况这个数字就在其适合的位置上
				i--;//防止换过来的这个数不是在该在的位置上，因此减一以抵消for循环里的加一
			}
		}
		i = 0;
		while(i < nums.length && nums[i] == i + 1) i++;
		return i + 1;
	}
	private void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}