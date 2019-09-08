# include <stdio.h>
/**
*猜数字游戏。提示用户输入数字，然后提示输入的数字是
*大了还是小了。直到输入正确为止，并且统计猜的次数。
*/

void main(){

	printf("请输入一个数字！\n\n");

	int inputNum = 0;
	int guessNum = 0;
	int correctNum  = 1314;

	scanf("%d",&inputNum);
	guessNum++;
	//判断
	while(inputNum != correctNum){
	
		if(inputNum < correctNum){
			printf("小了点！\n\n");
		} else {
			
			printf("大了点！\n\n");
		}
		
		scanf("%d",&inputNum);
		guessNum++;
	}

	//走到这里就才对了！
	printf("恭喜你，猜对了！总共用了：%d 次。\n",guessNum);
}
