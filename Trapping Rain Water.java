//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
// For example, 
// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
import java.util.Stack;
public class Main{
	public static void main(String[] args){
		int[] height = {5,5,1,7,1,1,5,2,7,6};
		System.out.println(trap(height));
	}
	public static int trap(int[] height){
		Stack<Integer> st = new Stack<>();
		int rain = 0, top;
		if(height.length <= 1 || height == null) return 0;
		st.push(height[0]);
		for(int i = 1; i < height.length; i++){
			if(height[i] <= st.elementAt(0))
				st.push(height[i]);
			else{
				top = st.elementAt(0);
				while(st.size() > 1 && top >= st.peek()){					
					rain += (top - st.pop());
				}
				st.pop();
				st.push(height[i]);
			}
		}
		if(!st.isEmpty()){
			while(st.size() > 1 && st.elementAt(st.size() - 1) < st.elementAt(st.size() - 2))
				st.pop();
			top = st.pop();
			while(st.size() > 1){
				top = Math.max(top, st.peek());
				rain += top - st.pop();
			}
		}
		return rain;
	}
}

//别人的答案
public int trap(int[] A){
	int a = 0;
	int b = A.length - 1;
	int max = 0;
	int leftmax = 0;
	int rightmax = 0;
	while(a <= b){
		leftmax = Math.max(leftmax, A[a]);
		rightmax = Math.max(rightmax, A[b]);
		if(leftmax < rightmax){
			max += leftmax - A[a];
			a++;
		}else{
			max += rightmax - A[b];
			b--;
		}
	}
	return max;
}













