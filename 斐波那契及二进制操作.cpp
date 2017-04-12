long long Fibonacci(unsigned n){
	int result[2] = {0, 1};
	if(n < 2)
		return result[n];
	long long fibNMinusOne = 1;
	long long fibNMinusTwo = 0;
	long long fibN = 0;
	for(unsigned int i = 2; i <= n; i++){
		fibN = fibNMinusOne + fibNMinusTwo;
		fibNMinusTwo = fibNMinusOne;
		fibNMinusOne = fibN;
	}
	return fibN;
}
//斐波那契数列，把已经得到的数列中间项存起来
//用2*1的小矩形横着或竖着去覆盖更大的矩形
//用8个2*1的小矩形无重叠地覆盖一个2*8的大巨星，总共有多少种方法
//f(8) = f(7) + f(6)


//把一个整数减去1，都是把最右边的1变成0，如果它的右边还有0的话，所有的0都变成1，而它左边的所有位都保持不变
//把一个整数减去1，再和原整数做与运算，会把该整数最右边的一个1变为0，那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作
//统计二进制中1的个数
int NumberOf1(int n){
	int count = 0;
	while(n){
		++count;
		n = (n - 1) & n;
	}
	return count;
}
/*
1.用一条语句判断一个整数是不是2的整数次方
一个整数如果是2的整数次方，那么它的二进制表示中有且只有意为是1
因此，把这个整数减去1后再和它自己做与运算，这个整数中唯一的1就会变成0
 */
/*
2.输入两个整数m和n，计算需要改变m的二进制表示中的多少位才能得到n
第一步求两个数的异或，第二步统计结果中1的个数
 */

