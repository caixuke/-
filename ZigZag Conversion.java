/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".*/
public class Solution{
	public String convert(String s, int numRows){
		if(s == null || numRows <= 1) return s;
		int delta = 1;
		int row = 0;
		String[] res = new String[numRows];
		Arrays.fill(res, "");
		for(int i = 0; i < s.length(); i++){
			res[row] += s.charAt(i);
			row += delta;
			if(row >= numRows)
			{
				delta = -1;
				row -= 2;
			}
			else if(row < 0){
				delta = 1;
				row = 1;
			}
		}
		String ret = "";//Initialize
		for(int j = 0; j < numRows; j++){
			ret += res[i];
		}
		return ret;
	}
}

public class Solution{
	public String convert(String s, int nRows){
		int len = s.length();
		if(len == 0 || nRows < 2) return s;

		String ret = "";
		int lag = 2 * nRows - 2;
		for(int i = 0; i < nRows; i++){
			for(int j = i; j < len; j += lag){
				ret += s.charAt(j);

				if(i > 0 && i < nRows - 1){
					if(j + lag - 2 * i < len) ret += s.charAt[j + lag - 2 * i];
				}
			}
		}
	}
}




