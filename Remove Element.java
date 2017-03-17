//1.Keep two pointers
public class Solution{
	public int removeElement(int[] nums, int val){
		int n = nums.length;
		int i = 0;
		for(int j = 0; j < n; j++){
			if(nums[j] != val)
				nums[i++] = nums[j];
		}
		return i;
	}
}

//Two Pointers - when elements to remove are rare
public int removeElement(int[] nums, int val){
	int i = 0;
	int n = nums.length;
	while(i < n){
		if(nums[i] == val)
			nums[i] == nums[n-1];
		//reduce array size by one
		n--;
	}else{
		i++;
	}
	return n;
}