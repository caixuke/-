//Write a function to find the longest common prefix string amongst an array of strings.
public class Solution{
	public String longestCommonPrefix(String[] strs){
		if(strs.length == 0 || strs == null) return "";
		String pre = strs[0];
		int i = 1;
		while(i < strs.length){
			while(strs[i].indexOf(pre) != 0)
				pre = pre.substring(0, pre.length() - 1);
			i++;
		}
		return pre;
	}
}