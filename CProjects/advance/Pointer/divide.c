#include <stdio.h>
//2个整数相除，既要知道是否成功，也要知道相除的结果

int main(){
	int a = 30;
	int b = 7;
	int result;
	
	if(divide(&a,&b,&result)){
		printf("a/b=%d",result);
	} else{
		printf("俩个数无法相除！");
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
