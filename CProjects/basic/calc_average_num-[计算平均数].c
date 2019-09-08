# include<stdio.h>

//让用户输入一系列的正整数，最后输入 -1表示输入结束，
//然后程序计算出这些数字的平均数，输出输入的数字的
//个数和平均数

void main(){

	printf("请输入正整数，输入'-1'表示结束！\n");

	int inputNum = 0;
	int sumNum = 0;
	int count = 0;

	do {
		scanf("%d",&inputNum);
		if (inputNum > 0){
			count++;
			sumNum+=inputNum;
			printf("请继续输入...\n");
		}
					
	} while (inputNum != -1);

	printf("总共输入了%d个数字\n",count);
	printf("平均数是:%lf\n",sumNum * 1.0f / count);

}
