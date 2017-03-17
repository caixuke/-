//Implement strStr().
// Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
public class Solution{
	public int strStr(String haystack, String needle){
		for(int i = 0; ; i++){
			for(int j = 0; ; j++){
				//三个if语句的顺序不能变，如果第三句在前面，可能会导致数组下标越界，如果第二句在第一句前面，会导致needle为空时输出-1而不是0
			    if(j == needle.length())
					return i;
			    if(i + j == haystack.length())
					return -1;
				if(needle.charAt(j) != haystack.charAt(i + j)) break;
			}
		}
	}
}