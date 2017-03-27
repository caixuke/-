//Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

// For "(()", the longest valid parentheses substring is "()", which has length = 2.

// Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
public class Solution{
	public int longestValidParentheses(String s){
		Stack<Integer> st = new Stack<Integer>();
		int max = 0;
		int left = -1;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '(')
				st.push(i);
			else{
				if(st.isEmpty())
					left = i;//如果是‘）’，更新左边的index
				else{
					st.pop();
					if(st.isEmpty()) max = Math.max(max, i - left);//栈为空时
					else max = Math.max(max, i - st.peek());
				}
			}
		}
		return max;
	}
}

public class Solution{
	public int longestValidParentheses(String s){
		LinkedList<Integer> stack = new LinkedList<>();
		int result = 0;
		stack.push(-1);
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '(')
				stack.push(i);
			else{
				stack.pop();
				if(stack.empty())
					stack.push(i);
				else result = Math.max(result, i - stack.peek());
			}
		}
		return result;
	}
}

public class Solution{
	public int longestValidParentheses(String s){
		int maxans = 0;
		int dp[] = new int[s.length()];
		for(int i = 1; i < s.length(); i++){
			if(s.charAt(i) == ')'){
				if(s.charAt(i - 1) == '('){
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
				}else if(i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
					dp[i] = dp[i - 1] + ((i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0)) + 2;
				}
				maxans = Math.max(maxans, dp[i]);
			}
		}
		return maxans;
	}
}