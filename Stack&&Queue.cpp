//栈（Stack）支持push和pop LIFO ：Last In First Out
//队列（Queue）与栈一样支持push和pop操作， pop取出的是最低端的元素， FIFO(first in first out)
#include <stack>
#include <cstdio>
using namespace std;

int main(){
	stack<int> s;//声明存储int类型数据的栈
	s.push(1);
	s.push(2);
	s.pop();

	queue<int> que;
	que.push(1);
	que.push(2);
	que.pop();
}