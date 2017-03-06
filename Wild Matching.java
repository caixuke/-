/*'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false*/
class Solution{
public:
	bool isMatch(string s, string p){
		int i = 0, j = 0, match = 0, startId = -1, ssize = s.size(), psize = p.size();
		while(i < ssize){
			if(j < psize && (p[j] == '?' || s[i] == p[j])){
				++i;
				++j;
			}else if(j < psize && p[j] == '*'){
				match = i;
				startId = j;
				j++;
			}else if(startId != -1){
				match++;
				i = match;
				j = startId + 1;
			}else{
				return false;
			}
		}
		while(j < psize && p[j] == '*'){
			j++;
		}
		return j == psize;
	}
}