#include <stdio.h>

//构建一个素数表，用户输入100，就会显示100以内的所有素数
//用数组实现

void main(){
    
    int inputNum;
    printf("请输入一个数：\n");
    scanf("%d",&inputNum);
    while(inputNum < 2){
	printf("不能小于2，请重新输入:\n");
	scanf("%d",&inputNum);
    }
    //定义一个数组,并且初始化所有的元素为 1，表示默认都是素数
    int prime[inputNum];
    for(int i = 0;i < inputNum;i++){
    
	prime[i] = 1;
    }
    //从2开始，所有2的倍数都标记为非素数即 0
    int n = 1;
    for (int j = 2;j <= inputNum;j ++ ){
	if (prime[j]){
	    //所有j的整数倍的数都不是素数
	    for(int i = 2;i * j <= inputNum;i++ ){
		prime[i * j] = 0;
	    }
	}
    }

    //遍历数组，所有不为0的元素的下标就是素数
    int count = 0;
    for(int i = 2;i <= inputNum;i++){
	if(prime[i]) {
	    printf("%d\t",i);

		count++;
	if (count % 5 == 0){
	    printf("\n");
	}

	}
    }
    printf("\n============================\n");

}
