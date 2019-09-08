#include <stdio.h>
//pointer compute

int main(){
	int num1;
	int num2;
	int *p1 = &num1;
	int *p2 = &num2;
	
	printf("p1 address is:%p\n",p1);
	printf("p2 address is:%p\n",p2);
	printf("p2+1 address is:%p\n",p2+1);
	printf("p2-p1 is:%d\n",p2-p1);
}
