#include <stdio.h>
#include <time.h>

int fun1(int num);
int fun2(int num);

clock_t start, end;
double duration;
void main(){
	printf("请输入要循环打印的数：\n");
	int num = 0;
	scanf("%d",&num);
	start = clock();
	fun1(num);	
	end = clock();
	duration = ((double)(end - start)) / CLOCKS_PER_SEC;
	printf("耗时：%lf\n",duration);
	
}

int fun1(int num){
	for(int i = 1;i <= num; i++){
		printf("%d\n",i);
	}
	return 0;
}

int fun2(int num){
	if(num){
		fun2(num -1);
		printf("%d\n",num);
	}
	return 0;
}
