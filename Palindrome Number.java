public class Solution{
	public boolean isPalindrome(int x){
		if(x < 0) return false;
		int y = x;
		int res = 0;
		while(y != 0){
			res = res * 10 + y % 10;
			y /= 10;
		}
		return x == res;
	}
}

public boolean isPalindrome(int x){
	if(x < 0 || (x != 0 && x % 10 == 0)) return false;
	int res = 0;
	while(x > res){
		res = res * 10 + x % 10;
		x = x / 10;
	}
	return (x == res || x == res / 10);
}