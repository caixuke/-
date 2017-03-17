//N*M的院子，问园子共有多少水洼
int N, M;
char field[MAX_N][MAX_M+1];//园子
//'W表示积水，'.'表示没有积水
void dfs(int x, int y){
	//将现在的位置替换为.
	field[x][y] = '.';

	//循环遍历移动的8个方向
	for(int dx = -1; dx <= 1; dx++){
		for(int dy = -1; dy <= -1; dy++){
			//向x方向移动dx，向y方向移动dy
			int nx = x + dx;
			int ny = y + dy;
			//判断（nx,ny)是否在园子中，以及是否有积水
			if(0 <= nx && nx < N && 0 <= ny && ny < M && field[nx][ny] == 'W')
				dfs(nx, ny);
		}
	}
	return;
}

void solve(){
	int res = 0;
	for(int i = 0; i < N; i++){
		for(int j = 0; j < M; j++){
			if(field[i][j] == 'W'){
				//从有W的地方开始dfs
				dfs(i, j);
				res++;
			}
		}
	}
	printf("%d\n", res);
}