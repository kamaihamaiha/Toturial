#include <stdio.h>
//2�������������Ҫ֪���Ƿ�ɹ���ҲҪ֪������Ľ��

int main(){
	int a = 30;
	int b = 7;
	int result;
	
	if(divide(&a,&b,&result)){
		printf("a/b=%d",result);
	} else{
		printf("�������޷������");
	}
	
	return 0;
}

int divide(int *a,int *b,int* result){
	if(*b == 0){
		return 0;
	}
	*result = *a / *b;
	return 1;
}
