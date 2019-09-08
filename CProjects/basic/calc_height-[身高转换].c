# include <stdio.h>

void main(){
	printf("请分别输入身高的英尺和英寸，\n如： 5 7 表示5英尺7英寸\n\n");
	
	int foot;
	int inch;

	//键盘录入数据
	scanf("%d %d",&foot,&inch);

	printf("***********************\n身高是：%f米。\n",(foot + inch / 12.0) * 0.3048);
}
