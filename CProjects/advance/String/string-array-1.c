#include <stdio.h>

<<<<<<< HEAD
//字符串数组。应用：输入月份【数字】，输出对应的中文。
int main(){
	
	char monthes[] = {'Nothing','January','February','March','April','May',
	'June','July','Auguest','September','October','November','December'};
	printf("请输入月份：");
	int month;
	scanf("%d",&month);
	printf(monthes[month]);
	return 0;
}
=======
//�ַ�������.
void main(){
	char months[][10] = {"error","January","February","March","April","May","June","July","Auguest","September","October","November","December"};
	printf("�������·ݣ�\n");
	int month;
	scanf("%d",&month);
	int i = 1;
	
	for(i = 1;i <= sizeof(months); i++){
		if(month == i){
			printf("%s\n",months[i]);
			break;
		}
		
	} 
} 
>>>>>>> a61ff12850ecb04ecc639718700cabf873d601a7
