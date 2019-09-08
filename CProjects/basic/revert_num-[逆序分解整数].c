#include <stdio.h>
//逆序分解一个整数：输入一个非负整数，正序输出它的每一位数字
//如输入：12345	输出： 5 4 3 2 1  
void main(){

	//1.接收输入的数，判断是否输入的是非负整数
	int inputNum;
	do {

		printf("请输入一个非负整数：\n");
		scanf("%d",&inputNum);
	}
	while(inputNum < 0);
	//开始分解输入的数
	int copy = inputNum;
	int bit = 1;
	while(copy > 9){
		copy /= 10;
		bit += 1;
	}
	for(;bit > 1;bit--){
		int bitValue = inputNum % 10;
		inputNum /= 10;
		printf("%d",bitValue);
		printf(" ");

	}
	printf("%d\n",inputNum);		
}
