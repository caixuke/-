// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
public class Solution{
	public boolean isValid(String s){
		Stack<Character> stack = new Stack<Character>();
		for(char c : s.toCharArray()){
			if(c == '(')
				stack.push(')');
			else if(c == '{')
				stack.push('}');
			else if(c == '[')
				stack.push(']');
			else if(stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
}

public class Solution{
	public boolean isValid(String s){
		Stack<Character> stack = new Stack<Character>();
		//Iterate through string until empty
		for(int i = 0; i < s.lengthg(); i++){
			//Push any open parentheses onto stack
			if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
				stack.push(s.charAt(i));
			else if(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(')
				stack.pop();
			else if(s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[')
				stack.pop();
			else if(s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{')
				stack.pop();
			else return false;
		}
		// return true if no open parentheses left in stack
		return stack.empty();
	}
}