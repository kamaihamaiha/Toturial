#include <stdio.h>

//函数声明
int sum(int begin,int end);

int main(){
	int begin;
	int end;
	printf("请输入2个数，计算他们之间的数的和！\n");
	scanf("%d",&begin);

	printf("请输入第二个数：\n");
	do {
		printf("第二个数不能比第一个数小！\n");	
		scanf("%d",&end);

	}while (end < begin);
	sum(begin,end);
}

//具体的函数定义
int sum(int begin,int end){
	int i;
	int sum = 0;
	for (i = begin;i <= end;i++){

		sum += i;	
	}
	printf("%d到%d的和是：%d\n",begin,end,sum);
}
