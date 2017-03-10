/*
链接：<a href="https://www.nowcoder.com/questionTerminal/fb511c3f1ac447309368d7e5432c6c79">https://www.nowcoder.com/questionTerminal/fb511c3f1ac447309368d7e5432c6c79</a>
来源：牛客网

如果一个数字能表示为p^q(^表示幂运算)且p为一个素数,q为大于1的正整数就称这个数叫做超级素数幂。现在给出一个正整数n,如果n是一个超级素数幂需要找出对应的p,q。

输入描述:
输入一个正整数n(2 ≤ n ≤ 10^18)


输出描述:
如果n是一个超级素数幂则输出p,q,以空格分隔,行末无空格。
如果n不是超级素数幂，则输出No
*/
#include <iostream>
#include <math.h>
#include <vector>

using namespace std;

double prime(long long n)
{
	for(long long i = 2; i <= sqrt((double)n); i++){
		if(n % i == 0) return 0;
	}
	return 1;
}

int main(){
	long long n,cur;
	double i = 2;
	int flag = 0;
	cin >> n;
	do{
		cur = ceil(pow((double)n, (double)(1.0/i)));
		if(prime(cur) && (pow(cur, i) == n)){
			flag = 1;
			break;
		}
		i++;
	}while(cur > 2);
	if(flag) cout<<cur<<" "<<i<<endl;
	else cout<<"No"<<endl;

	return 0;
} 