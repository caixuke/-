/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/
import java.util.Scanner;

public class Hello {
	public static int reverse(int x){
		int[] num = new int[12];//-2^31~2^31-1  -2147483648~2147483647
		int i = 0, flag = 0;
		double ret = 0.0;
		if(x < 0) {
			flag = 1;
			x = -x;
		}
		while(x != 0){
			num[i] = x % 10;
			x = x / 10;
			i++;
		}
		for(int j = 0; j < i; j++){
			ret = ret * 10 + num[j];
		}
		if(flag == 1) ret = -ret;
		if(ret >= Math.pow(2, 31) - 1 || ret <= -Math.pow(2, 31)) return 0;
		else return (int)ret;
	}
	public static void main(String[] args ){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println(reverse(n));
	}
}
//别人的更加简练的解法，不需要额外的数组，不需要与int最大值和最小值的比较
//因为如果存在溢出，新的结果与之前的数将不一样
public int reverse(int x){
	int result = 0;

	while(x != 0)
	{
		int tail = x % 10;
		int newResult = result * 10 + tail;
		if((newResult - tail) / 10 != result)
			return 0;
		result = newResult;
		x = x / 10;
	}
	return result;
}






