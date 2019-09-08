# include<stdio.h>
//找零计算器
 
void main(){

	printf("请输入金额：\n");

	int price;
	int bill;

	scanf("%d",&price);

	while(price <= 0){
		printf("价格输入不对，请重新输入！");

		scanf("%d",&price);
	}

	printf("请输入票面：\n");


	scanf("%d",&bill);

	while (bill - price < 0){
		printf("您给的钱不够！\n");
		
		scanf("%d",&bill);
	}
	
	printf("应该找您：%d元\n",(bill - price));
}
