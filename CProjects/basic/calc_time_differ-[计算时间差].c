# include<stdio.h>

//计算2个时间点的时间差，由于会出现借位操作，所以都转换为最小的时间单位做运算
void main(){

	int startHour;
	int startMinute;
	int endHour;
	int endMinute;

	int t1;
	int t2;

	printf("请输入开始时间(如：5 32)：\n");


	scanf("%d %d",&startHour,&startMinute);

	
	//增加输入校验
	while (startHour < 1 || startHour > 24 || startMinute < 1 || startMinute > 24){
		printf("时间输入不正确！，请重新输入!");

		scanf("%d %d",&startHour,&startMinute);
	}

	printf("请输入结束时间(如：7 32)：\n");

		
	scanf("%d %d",&endHour,&endMinute);

	//计算
	t1 = startHour * 60 + startMinute;
	t2 = endHour * 60 + endMinute;

	printf("时间差为：\t%d小时%d分钟\n",(t2 - t1) / 60,(t2 - t1) % 60);
	


}
