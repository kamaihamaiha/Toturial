#include <stdio.h>

int max(int a,int b);

int main(int argv,char* argu[]){

	printf("Please intput two number!\n");
	int a;
	int b;
	scanf("%d",&a);
	scanf("%d",&b);
	int maxvalue = max(a,b);
	printf("The bigger one is:%d\n",maxvalue);
}
