//有n个重量和价值分别为wi,vi的物品，从这些物品中挑选出总重量不超过W的物品，求所有挑选方案中价值总和的最大值
int n, W;
int w[MAX_N], v[MAX_N];
int dp[MAX_N +1][MAX_M + 1]

int rec(int i, int j){//j 表示剩余可装的空间，i表示第i件物品
	if(dp[i][j] >= 0)
		return dp[i][j];//已经计算过的话直接使用之前的结果
	int res;
	if(i == n)
		res = 0;
	else if(j < w[i]){//第i件物品重量大于可装的重量，跳过这一件寻找下一件
		res = rec(i + 1, j);
	}else{
		res = max(rec(i + 1, j), rec(i + 1, j - w[i]) + v[i]);
	}
	return dp[i][j] = res;
}
void solve(){
	memset(dp, -1, sizeof(dp));
	printf("%d\n", rec(0, W));
}

//二重循环
//dp[i][j]为从第i个物品开始挑选总重小于j时，总价值的最大值，dp[0][w]为所求的答案
//dp中关于i的循环是逆向进行的
void solve(){
	for(int i = n - 1; i >= 0; i--){//i从n-1开始！，从n的话没有物品可以选择
		for(int j = 0; j <= W; j++){
			if(j < w[i])
				dp[i][j] = dp[i + 1][j];
			else dp[i][j] = max(dp[i + 1][j], dp[i + 1][j - w[i]] + v[i]);
		}
	}
	printf("%d\n", dp[0][W]);
}

//dp[i+1][j]从前i个物品中选出总重量不超过j的物品时总价值的最大值
//dp[0][j] = 0
void solve(){
	for(int i = 0; i < n; i++){
		for (int j = 0; j <=W; j++){
			if(j < w[i])
				dp[i + 1][j] = dp[i][j];
			else dp[i + 1][j] = max(dp[i][j], dp[i][j - w[i]] + v[i]);
		}
	}
	printf("%d\n", dp[n][W]);
}

//除了运用递推方式逐项求解之外，还可以把状态转移想象成从“前i个物品中选取总重不超过j时的的状态”向“从前i+1个物品中选取总重不超过j”和“从前i+1个物品中选取总重不超过j+w[i]时的状态”的转移
void solve(){
	for(int i = 0; i < n; i++){
		for(int j = 0; j <= W; j++){
			dp[i + 1][j] = max(dp[i + 1][j], dp[i][j]);
			if(j + w[i] <= W){
				dp[i + 1][j + w[i]] = max(dp[i + 1][j + w[i]], dp[i][j] + v[i]);
			}
		}
	}
	printf("%d\n", dp[n][W]);
}















