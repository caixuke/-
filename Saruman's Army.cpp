// 直线上有N个点，从N个点中选出最少的点做上标记，使得对每一个点，其距离为R以内的区域里必须带有标记的点
int N, R;
int X[MAX_N];

void solve(){
	sort(X, X + N);
	int i = 0, ans = 0;
	while(i < N){
		//s是没有被覆盖的最左点的位置
		int s = X[i++];
		//一直向右前进直到距s的距离大于R的点
		while(i < N && X[i] <= s + R) i++;
		//p是新加上标记的点的位置
		int p = X[i - 1];
		//一直向右前进到距p的距离大于R的点
		while(i < N && X[i] <= p + R) i++;
		ans++;
	}
	printf("%d\n", ans);
}