/*
交换二进制的奇数位和偶数位
我们可以将二进制的从最高位到最低位依次求出，也就是sum,同样的ret如果左移32次的话，就会将最高位丢失，所以让ret=0,先无用的左移一次也就是把ret=ret<<1放到赋值前面，移位并求出最高位的值后，我们就让第31位给到ret的最低位，然后再左移，再让第32位给到最低位。总共执行16次就可以将所有的二进制奇数位和偶数位互换。
 */
#include <stdio.h>
int exchange(int val){
	int sum = 0;
	int ret = 0;
	int i = 0;
	for(i = 16; i > 0; i--){
		ret = ret << 1;
		sum = (val >> (2 * i - 2) & 1);
		ret = sum | ret;
		ret = ret << 1;
		sum = (val >> (2 * i - 1) & 1);
		ret = ret | sum;
	}
	return ret;
}
int main(){
	int val = 14;
	int num = exchange(val);
	printf("%d", num);
	system("pause");
	return 0;
}