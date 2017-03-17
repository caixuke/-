//字典序最小问题
#include <stdio.h>
#include <string.h>
//输入
#define MAX_N 100
int N;
char S[MAX_N+1];

void solve(){
	//剩余字符串为S[A],S[a+1],...,S[b]
	int a = 0, b = N - 1;
	while(a <= b){
		bool left = false;
		for(int i = 0; a + i <= b; i++){
			if(S[a + i] < S[b - i]){
				left = true;
				break;
			}else if(S[a + i] > S[b - i]){
				left = false;
				break;
			}
		}
		if(left) putchar(S[a++]);
		else putchar(S[b--]);
	}
	putchar('\n');
}
int main(){
	N = 6;
	strcpy(S,"ACDBCB");
	solve();
}

