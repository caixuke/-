//Given an array of integers, every element appears twice except for one. Find that single one.
//所有元素进行异或
public class Solution{
	public int singleNumber(int[] nums){
		if(nums.length == 0) return 0;
		int res = nums[0];
		int i;
		for(i = 1; i < nums.length; i++){
			res ^= nums[i];
		}
		return res;
	}
}