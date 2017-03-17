/*
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
//求数字串以字典序排列的下一个排列，从后往前搜索最长的后缀逆序数列，搜索到之后得到该数列前的的一个数字，然后从后往前搜索比这个数字大的数字中最小的那个，然后交换两者，最后将这个数字后的逆序数列转为顺序数列
public class Solution{
	public void nextPermutation(int[] nums){
		int i = nums.length - 2;
		while(i >= 0 && nums[i + 1] <= nums[i])
			i--;
		if(i >= 0){
			int j = nums.length - 1;
			while(j >= 0 && nums[j] <= nums[i])
				j--;
			swap(nums, i, j);
		}
		reverse(nums, i + 1);
	}
	private void reverse(int[] nums, int start){
		int i = start, j = nums.length - 1;
		while(i < j){
			swap(nums, i, j);
			i++;
			j--;
		}
	}
	private void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}