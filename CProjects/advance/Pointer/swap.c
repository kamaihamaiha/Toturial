#include <stdio.h>
//交换 2 个变量的值

void main(){
	
	int a = 1;
	int b = 2;
	swap(&a,&b);
	printf("交换后：\n");
	printf("a=%d,b=%d",a,b); 
} 

int swap(int *a,int *b){
	int temp_value = *a;
	*a = *b;
	*b = temp_value;
	return 0;
}
