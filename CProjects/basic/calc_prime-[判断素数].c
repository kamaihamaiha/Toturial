# include <stdio.h>
//判断输入的数字是否为素数，列举素数
void main(){

	printf("请输入一个数，我来判断该数是否为素数！\n");
	int printNum;
	scanf("%d",&printNum);
	//判断输入的数字
	if (printNum < 2){
		printf("%d不是素数\n",printNum);
	} else if (printNum == 2){
		printf("%d是素数！\n",printNum);
	} else {
		//从2开始遍历，查找该数是否有因子
		int i;
		int isPrime = 0;
		int a;
		int b;
		for(i = 2;i < printNum;i++){
			if (printNum % i == 0){
				//找到因子了，就不是素数
				isPrime = 1;
	
				a = i;
				b = printNum / a;
				break;
			}
		}
		//输出判断结果
		if(isPrime == 0){
			printf("%d是素数！\n",printNum);
		} else {
			printf("%d不是素数！\n",printNum);
			printf("因为：%d = %d * %d\n",printNum,a,b);
		}
	}
	
}
