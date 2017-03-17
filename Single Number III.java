//Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

// For example:

// Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

// Note:
// The order of the result is not important. So in the above example, [5, 3] is also correct.
// Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

public class Solution{
	public int[] singleNumber(int[] nums){
		int[] res = new int[2];
		int tmp = 0, tmp1 = 0, tmp2 = 0;
		int count = 0;
		for(int i = 0; i < nums.length; i++)
			tmp ^= nums[i];
		while(((tmp >> count) & 1) == 0)
			count++;
		for(int i = 0; i < nums.length; i++){
			if(((nums[i] >> count) & 1) == 0)
				tmp1 ^= nums[i];
			else tmp2 ^= nums[i];
		}
		res[0] = tmp1;
		res[1] = tmp2;
		return res;
	}
}
//Once again, we need to use XOR to solve this problem. But this time, we need to do it in two passes:

// In the first pass, we XOR all elements in the array, and get the XOR of the two numbers we need to find. Note that since the two numbers are distinct, so there must be a set bit (that is, the bit with value '1') in the XOR result. Find
// out an arbitrary set bit (for example, the rightmost set bit).
// In the second pass, we divide all numbers into two groups, one with the aforementioned bit set, another with the aforementinoed bit unset. Two different numbers we need to find must fall into thte two distrinct groups. XOR numbers in each group, we can find a number in either group.
// Complexity:
// Time: O (n)
// Space: O (1)
// A Corner Case:
// When diff == numeric_limits<int>::min(), -diff is also numeric_limits<int>::min(). Therefore, the value of diff after executing diff &= -diff is still numeric_limits<int>::min(). The answer is still correct.

public class Solution{
	public int[] singleNumber(int[] nums){
		//Pass 1:
		// Get the XOR of the two numbers we need to find
		int diff = 0;
		for(int num: nums)
			diff ^= num;
		//Get its last set bit
		diff &= -diff;
		//Pass 2:
		int[] rets = {0, 0};
		for(int num : nums){
			if((num & diff) == 0)//the bit is not set
				rets[0] ^= num;
			else
				ret[1] ^= num;
		}
		return rets;
	}
}