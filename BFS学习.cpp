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
}