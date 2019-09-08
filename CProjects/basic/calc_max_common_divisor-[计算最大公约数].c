# include <stdio.h>
//计算2个数的最大公约数

void main(){

	int a;
	int b;
	printf("请输入2个数：\n");

	scanf("%d\r%d",&a,&b);
	//最大公约数肯定不大于这2个数的小的那个
	int min;
	if (a < b){
		min = a;
	} else {
		min = b;
	}

	//从1开始遍历到 min，寻找公约数。最后那个满足条件的就是最大公约数
	int i;
	int maxDivisor;
	for (i = 1;i <= min;i++){
		if (a % i == 0){
			if (b % i == 0){
				//找打一个公约数
				maxDivisor = i;
			}
		}
	}

	//走到这里，就可以找到最大的公约数了。
	printf("%d和%d的最大公约数是：%d\n",a,b,maxDivisor);
	
}
