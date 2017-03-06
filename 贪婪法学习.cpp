//从第v 个顶点出发递归得深度优先遍历图G
void DFS(Graph G, int v)
{
	VisitFunction(v);
	for_each(vi:v的所有邻接点)
	{
		if(vi没有被访问过)
			DFS(G, vi);
	}
}

void BFS(Graph G, int v)
{
	for_each(vi:v的所有邻接点)
	{
		if(vi没有被访问过)
		{
			VisitFunction(vi);
			Enqueue(Q, vi);
		}
	}
	while(!QueueEmpty(Q))
	{
		Dequeue(Q, u);
		BFS(G, u);
	}
}

//贪婪法解决背包问题
//1.根据物品价值选择，每次选价值最高的物品
//2.根据物品质量选择，每次选重量最轻的物品
//3.定义价值密度，Si=Pi/Wi
typedef struct tagObject
{
	int weight;
	int price;
	int status;//0未选中；1已选中；2不可选
}OBJECT;
typedef struct tsgKnapsackProblem{
	std::vector<OBJECT> OBJS;
	int total;
}KNAPSACK_PROBLEM;

void GreedyAlgo(KNAPSACK_PROBLEM *problem, SELECT_POLICY spFunc)
{
	int idx;
	int ntc = 0;
	//spFunc 每次选最符合策略的那个物品，选后再检查
	while((idx = spFunc(problem->objs, problem->totalC - ntc))!=-1)
	{
		if((ntc + problem->objs[idx].weight)<= problem->totalC)
		{
			problem->objs[idx].status = 1;
			ntc += problem->objs[idx].weight;
		}
		else
		{
			problem->objs[idx].status = 2;
		}
	}
}
//spFunc函数是选择策略函数的借口
int Choosefun1(std::vector<OBJECT>& objs, int c)
{
	int index = 1;
	int mp = 0;
	for(int i = 0; i < static_cast<int>(objs.size()); i++)
	{
		if((objs[i].status == 0)&&(objs[i].price > mp))
		{
			mp = objs[i].price;
			index = i;
		}
	}
	return index;
}








