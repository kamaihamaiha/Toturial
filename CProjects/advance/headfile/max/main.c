#include <stdio.h>
#include "max.h"
int main(int argv,char* argu[]){

	printf("Please intput two number!\n");
	int a;
	int b;
	scanf("%d",&a);
	scanf("%d",&b);
	int maxvalue = max(a,gAll);
	printf("The bigger one is:%d\n",maxvalue);
}
