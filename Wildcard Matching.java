public class Solution{
	public boolean isMatch(String s, String p){
		int a = 0, b = 0, match = 0, starIdx = -1;
		while(a < s.length()){
			// advancing both pointers
			if(b < p.length() && (p.charAt(b) == '?' || s.charAt(a) == p.charAt(b))){
				a++;
				b++;
			}
			// * found, only advancing pattern pointer
			else if(b < p.length() && p.charAt(b) == '*'){
				starIdx = b;
				match = a;
				b++;
			}
			// last pattern pointer was *, advancing string pointer
			else if(starIdx != -1){
				b = starIdx + 1;
				match++;
				a = match;
			}
			else return false;
		}
		while(b < p.length() && p.charAt(b) == '*')
			b++;
		return b == p.length();
	}
}

// Java DP solution using 2D table
public class Solution{
	public boolean isMatch(String s, String p){
		boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
		match[s.length()][p/length()] = true;
		for(int i = p.length() - 1; i >= 0; i--){
			if(p.charAt(i) != '*')
				break;
			else match[s.length()][i] = true;
		}
		for(int i = s.length() - 1; i >= 0; i--){
			for(int j = p.length() - 1; j >= 0; j--){
				if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
					match[i][j] = match[i+1][j+1];
				else if(p.charAt(j) == '*')
					match[i][j] = match[i+1][j] || match[i][j+1];
				else match[i][j] = false;
			}
		}
		return match[i][j];
	}
}