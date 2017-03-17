//部分和问题
//给定整数a1、a2、···、an，判断是否可以从中选出若干数，使其和为k
#include <cstdio>
using namespace std;
#define MAX_N 20
int a[MAX_N];
int n, k;
//已经从前i项得到了和sum，然后对于i项之后的项进行分支
bool dfs(int i, int sum){
	//如果前n项都计算过了，则返回sum和k是否相等
	if(i == n) return sum == k;
	//不加上a[i]的情况
	if(dfs(i + 1, sum)) return true;
		//加上a[i]的情况
	if(dfs(i + 1, sum + a[i])) return true;
	else return false;

}
int main(){	
	if(dfs(0, 0)) printf("Yes\n");
	else printf("No\n");
}

