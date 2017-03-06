/*Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.*/
public class Solution {
	    public int lengthOfLongestSubstring(String s) {
	        int maxlen = 0;//要考虑字符串为空的情况
	        if(!s.equals("")) maxlen = 1;//这里不能用s==“”，因为这个==比较的是地址，要用equals
	        for(int i = 0; i < s.length(); i++)
	        {
	            for(int j = i + 1; j < s.length(); j++)
	            {	       
	                if(s.substring(i,j).indexOf(s.charAt(j)) == -1){
	                	maxlen = java.lang.Math.max(maxlen, j - i + 1);
	                }
	                else break;
	            }
	        }
			return maxlen;
	    }
}

//the basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values, and keep two pointers which define the max substring. move the right pointer to scan through the string , and meanwhile update the hashmap. If the character is already in the hashmap, then move the left pointer to the right of the same character last found. Note that the two pointers can only move forward.

public int lengthOfLongestSubstring(String s)
{
	if(s.length() == 0) return 0;
	HashMap <Character, Interger> map = new HashMap<Character, Interger>;
	int max = 0;
	for(int i = 0, j = 0; i < s.length(); i++)
	{
		if(map.containsKey(s.charAt(i))){
			j = Math.max(j, map.get(s.charAt(i) + 1));
		}
		map.put(s.charAt(i), i);
		max = Math.max(max, i - j +1);
	}
	return max;
}









