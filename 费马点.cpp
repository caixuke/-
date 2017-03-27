//给n个点，找出一个点，使这个点到其他所有点的距离之和最小，也就是求费马点。
#include <iostream>
#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <math.h>

#define N 1005
#define eps 0.000000001
#define INF 10000000000
#define delta 0.98
#define 	T 100

using namespace std;

int dx[4] = {0, 0, -1, 1};
int dy[4] = {-1, 1, 0, 0};//上下左右四个方向

struct Point{
	double x, y;
};
Point p[N];
double dist(Point A, Point B){
	return sqrt((A.x - B.x) * (A.x - B.x) + (A.y - B.y) * (A.y - B.y));
}
double GetSum(Point p[], int n, Point t){
	double ans = 0;
	while(n--)
		ans += dist(p[n], t);
	return ans;
}
double Search(Point p[], int n){
	Point s = p[0];
	double t = T;
	double ans = INF;
	while(t > eps){
		bool flag = 1;
		while(flag){
			flag = 0;
			for(int i = 0; i < 4; i++){
				Point z;
				z.x = s.x + dx[i] * t;
				z.y = s.y + dy[i] * t;
				double tp = GetSum(p, n, z);
				if(ans > tp){
					ans = tp;
					s = z;
					flag = 1;
				}
			}
		}
		t *= delta;
	}
	return ans;
}

int main()
{
	int n;
	while(scanf("%d", &n) != EOF)
	{
		for(int i = 0; i < n; i++){
			scanf("%lf %lf", &p[i].x, &p[i].y);
		}
		printf("%.01f\n", Search(p, n));
	}
	return 0;
}