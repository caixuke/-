/*
1,只利用满足f(e)<c(e)的e或者满足f(e)>0的e对应的反向边rev(e),寻找一条s到t的路径；
2，如果不存在满足条件的路径，则结束，否则，沿着该路径尽可能地增加流量，返回第一步
 */
#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;
const int msize = 205;

int N, M; // N--路径数， M--结点数
int r[msize][msize];
int pre[msize];//记录结点i的前向结点为pre[i]
bool vis[msize];//记录结点i是否已被访问

//用BFS来判断从结点s到t的路径上是否还有delta
//即判断s,t之间是否还有增广路径，若有，返回1
bool BFS(int s, int t){
	queue<int> que;
	memset(pre, -1, sizeof(pre));
	memset(vis, false, sizeof(vis));

	pre[s] = s;
	vis[s] = true;
	que.push(s);

	int p;
	while(!que.empty()){
		p = que.front();//队列先进先出，从头部开始删除
		que.pop();
		for(int i = 1; i <= M; i++){//遍历从该结点出发的每一条路径
			if(r[p][i] > 0 && !vis[i]){
				pre[i] = p;
				vis[i] = true;
				if(i == t)//存在增广路径 终止条件判断
				{
					return true;
				}
				que.push(i);
			}
		}
	}
	return false;
}

int EK(int s, int t){
	int maxflow = 0, d;
	while(BFS(s, t)){
		d = INT_MAX;
		//若有增广路径，则找出最小的delta
		for(int i = t; i != s; i = pre[i])
			d = min(d, r[pre[i]][i]);//r[pre[i]][i]代表从i的前一个结点到i的流量
		//反向边
		for(int i = t; i != s; i = pre[i]){
			r[pre[i]][i] -= d;
			r[i][pre[i]] += d;
		}
		maxflow += d;
	}
	return maxflow;
}

int main(){
	while(cin >> N >> M){
		memset(r, 0, sizeof(r));
		int s, e, c;
		for(int i = 0; i < N; i++){
			cin >> s >> e >> c;
			r[s][e] += c;
		}
	cout << EK(1, M) <<endl;
	}
	return 0;
}
