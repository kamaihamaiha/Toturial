#include <stdio.h>
//���� 2 ��������ֵ

void main(){
	
	int a = 1;
	int b = 2;
	swap(&a,&b);
	printf("������\n");
	printf("a=%d,b=%d",a,b); 
} 

int swap(int *a,int *b){
	int temp_value = *a;
	*a = *b;
	*b = temp_value;
	return 0;
}
