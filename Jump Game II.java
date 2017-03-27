public class Solution{
	public int jump(int[] nums){
		int step_count = 0;// minimum steps for reaching e
		int last_jump_max = 0;// longest distance in current minimum step
		int current_jump_max = 0;// the distance which has reached
		for(int i = 0; i < nums.length - 1; i++){
			current_jump_max = Math.max(current_jump_max, i + nums[i]);
			if(i == last_jump_max){
				step_count++;
				last_jump_max = current_jump_max;
			}
		}
		return step_count;
	}
}