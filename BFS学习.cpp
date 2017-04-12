// Vs是起点
// Vd是终点
bool BFS(Node& Vs, Node& Vd){
	queue<node> Q;
	Node Vn, Vw;
	int i;
	//初始状态将起点放进队列Q
	Q.push(Vs);
	hash(Vw) = true;//设置节点已经被访问过了
	while(!Q.empty()){
		//取出队列的头Vn
		Vn = Q.front();
		//从队列中移除
		Q.pop();
		while(Vw = Vn通过某规则能够到达的节点){
			if(Vw = Vd){//找到终点了
				//记录路径
				return true;
			}
			if(isValid(Vw) && !visit[Vw]){
				//Vw是一个合法的节点并且未被访问
				Q.push(Vw);//加入队列Q
				hash(Vw) = true;//设置节点已被访问
			}
		}
	}
	return false；

//在搜索问题中，如果任意相邻的两个点之间移动的代价 (例如所需的时间、体力，等等)是相等的，那么广度优先搜 索可以保证找到一条花费最小代价的路径。这是因为它在检查 完所有离起点距离 X 步的点后，才会开始检查那些更远的，例 如离起点距离 X + 1 步的点。