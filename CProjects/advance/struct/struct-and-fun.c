#include <stdio.h>

//定义结构体
struct point {
	int x;
	int y;
};

//定义结构体函数
struct point* getPoint(struct point*);

void output(struct point);

void print(struct point*);

int main(int args, char const *argv[]){
		
	struct point p = {0,0};
	getPoint(&p);
	output(p);
	print(&p);
	
}

//实现函数

struct point* getPoint(struct point* p){

	scanf("%d",&p->x);
	scanf("%d",&p->y);
	return p;
}

void output(struct point p){
	printf("x=%d,y=%d\n",p.x,p.y);
}

void print(struct point* p){
	printf("x=%d,y=%d\n",p->x,p->y);
}
