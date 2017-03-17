public class Solution{
	public int divide(int dividend, int divisor){
		if(divisor == 0)
			return 0;
		boolean neg = (dividend < 0) ^ (divisor < 0);//^按位异或
		long m = Math.abs((long)dividend);
		long n = Math.abs((long)divisor);
		long result = 0;
		while(m >= n){
			int shift = 0;
			while(m > (n << shift + 1))//注意这里shift是先加一，这样此时比较的与最后得到的shift之间不会差一
				shift++;
			m -= n << shift;
			result += (1 << shift);//这两句语句应该放在while循环里，因为一次循环可能不够，result不一定是2的倍数
		}
		result = (neg)? ~(result - 1): result;
		result = Math.min(Integer.MAX_VALUE, result);
		result = Math.max(Integer.MIN_VALUE, result);
		return (int)result;
	}
}