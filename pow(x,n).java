//计算pow（x,n)
//不能用for循环，考虑到n可能为小数
//要考虑边界情况，n为MIN_VALUE
public class Solution{
	public double myPow(double x, int n){
		if(n == 0)
			return 1;
		if(n < 0){
			if(n == Integer.MIN_VALUE) 
				return 1.0 / (myPow(x, Integer.MAX_VALUE) * x);
			else{
				n = -n;
				x = 1 / x;
			}
		}
		return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
	}
}