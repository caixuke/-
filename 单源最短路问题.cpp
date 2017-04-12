//单源最短路问题（Bellman-Ford算法)
//从顶点from指向顶点to的权值为cost的边
struct edge{ int from, to, cost;};
edge es[MAX_E];

int d[MAX_V];//最短距离
int V, E;//V是顶点数，E是边数

// 求解从顶点s出发到所有点的最短距离
void shortest_path(int s){
	for(int i = 0; i < V; i++) d[i] = INF;
	d[s] = 0;
	while(true){
		bool update = false;
		for(int i = 0; i < E; i++){
			edge e = es[i];
			if(d[e.from] != INF && d[e.to] > d[e.from] + e.cost){
				d[e.to] = d[e.from] + e.cost;
				update = true;
			}
		}
		if(!uodate) break;
	}
}
//如果在图中不存在从s可达的负圈，那么最短路不会经过同一个顶点两次，while(true)的循环最多执行V-1次，因此复杂度是O(V*E)
//如果返回TRUE则存在负图
bool find_negative_loop(){
	memset(d, 0, sizeof(d));
	for(int i = 0; i < V; i++){
		for(int j = 0; j < E; j++){
			edge e = es[j];
			if(d[e.to] > d[e.from] + e.cost){
				d[e.to] = d[e.from] + e.cost;
				if(i == V - 1)
					return true;//如果第n次仍然更新了，则存在负图			
			}
		}
	}
	return false;
}

//单源最短路问题2（Dijkstra算法）
//（1）找到最短距离已经确定的顶点，从它出发更新相邻顶点的最短距离
//（2）此后不需要再关心1中的“最短距离已经确定的顶点”
int cost[MAX_V][MAX_V];//cost[u][v]表示边e=(u,v)的权值
int d[MAX_V];//顶点s出发的最短距离
bool used[MAX_V];//已经使用过的图
int V;//顶点数

//求从起点s出发到各个顶点的最短距离
void dijkstra(int s){
	fill(s, d + V, INF);
	fill(used, used + V, false);
	d[s] = 0;

	while(true){
		int v = -1;
		//从尚未使用过的顶点中选择一个距离最小的顶点
		for(int u = 0; u < V; u++){
			if(!used[u] && (v == -1 || d[u] < d[v]))
				v = u;
		}
		if(v == -1) break;
		used[v] = true;
		for(int u = 0; u < V; u++){
			d[u] = min(d[u], d[v] + cost[v][u]);
		}
	}
}










