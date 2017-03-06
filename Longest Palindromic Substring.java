/*Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"*/
public class Solution {
    public static String longestPalindrome(String s){
		if(s.isEmpty()){
			return null;
		}
		if(s.length() == 1) return s;
		String longest = s.substring(0, 1);
		for(int i = 0; i < s.length(); i++){
			String tmp = calculate(s, i, i);//两种情况
			if(tmp.length() > longest.length())
				longest = tmp;
			tmp = calculate(s, i, i+1);
			if(tmp.length() > longest.length())
				longest = tmp;
		}
		return longest;
	}
	public static String calculate(String s, int begin, int end){
		while(begin >= 0 && end <= s.length() - 1  && s.charAt(begin) == s.charAt(end)){//判定数组下标是否出线的要放在前面
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}








	
}