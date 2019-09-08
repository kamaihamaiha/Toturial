#include <stdio.h>
//写一个程序，输入数量不确定的[0,9]范围内的整数，统计每一种数字出现的次数，输入-1表示结束

void main(){
	//先申请一个10大小的数组
	const int count = 10;
	int numberContainer[count];
	printf("请输入数字(-1表示结束)：\n");
	int inputNum;
	scanf("%d",&inputNum);
	
	//初始化数组
	for(int i = 0;i < count;i++){
		numberContainer[i] = 0;
	}
	while(inputNum != -1){
		if (inputNum >=0 && inputNum <= (count - 1)){
			numberContainer[inputNum] ++;
			printf("请继续输入：\n");
			scanf("%d",&inputNum);

		}
	}

	//输出统计结果
	
	for(int i = 0;i < count;i++){
		printf("%d出现的次数：%d 次\n",i,numberContainer[i]);
	}
}
