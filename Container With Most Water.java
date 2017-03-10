/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
*/
public class Solution{
	public int maxArea(int[] height){
		int left = 0, right;
		right = height.length - 1;
		int res = 0;
		if(right < 1) return 0;
		while(left < right)
		{
			int v = (right - left) * Math.min(height[left], height[right]);
			if(v > res) res = v;
			if(height[right] > height[left]) left++;
			else right--;
		}
		return res;
	}
}