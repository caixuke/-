/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
*/
public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(digits.length() == 0)
        	return ans;
        ans.add("");
        for(int i = 0; i < digits.length(); i++){
        	int x = Character.getNumericValue(digits.charAt(i));//得到所给字符数字的第i位的int形式
        	while(ans.peek().length() == i){//先前ans中已经add了“”，所以length为0，之后每次循环队列中的字符便会多一位
        		String t = ans.remove();
        		for(char c: map[x].toCharArray())
        			ans.add(t + c);//对队列中的每个字符与map[x]中的每个字符做拼接处理后，再重新加入到队列中去
        	}
        }
        return ans;
    }
}