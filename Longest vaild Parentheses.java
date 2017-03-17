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
			if(s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '('){
				stack.pop();
				result = Math.max(result, i - stack.peek());
			}else stack.push(i);
		}
		return result;
	}
}