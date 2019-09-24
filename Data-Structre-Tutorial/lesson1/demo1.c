#include <stdio.h>
#include <math.h>
#include <time.h>
#include <stdlib.h>
#include <unistd.h>

//求最大子列和

int generate_random_array(int *nums,int num);

int sum1(int *sum,int *nums,int count);

int sum2(int *sum,int *nums,int count);

clock_t start,end;
double duration;
int main (int argc,char *argv[])
{
		printf("这个一个求最大子列和的程序. 请输入数列的项数:\n");	
		int num;
		scanf("%d",&num);
		if (num <=0){
				printf("项数不能小于 1 !\n");
				return -1;
		}
		int numbers[num];
		generate_random_array(numbers,num);

		//提示调用哪个方法
		int method_index = 0;
		printf("请选择你用的方法: 1 or 2 ?\n");
		do {
				scanf("%d",&method_index);
		} while (method_index != 1 && method_index != 2);
		
		//求解
		int max_sum = 0;
		int *sum = &max_sum;
		int a = 0;
//		printf("max_sum addr: %p\n",sum);
//
		//调用选中的方法
		if (method_index == 1){
				sum1(sum,numbers,num);
		} else if (method_index == 2) {
				sum2(sum,numbers,num);
		}
		printf("最大子列和: %d\n",*sum);
		printf("耗时: %lf\n",duration);
		return 0;
}

int generate_random_array(int *nums,int num)
{
		printf("-----------\n");
		//生成有符号的随机数,放到数组中
		srand((int) time(NULL));
		//int numbers[num];
		for (int i = 0; i < num; i++)
		{
				//随机数 (-100,100)
				nums[i] = rand() % 200 - 100;
				printf("%d\t",nums[i]);
				if (i > 0 && (i + 1) % 20 == 0)
				{
						putchar('\n');
				}
		}
		putchar('\n');
		return 0;
}

int sum1(int *max_sum,int *nums,int count)
{
		printf("-----------sum1:\n");
		start = clock();
		if (count <= 0)
				return -1;

		char default_char = '-';
		char bar[101] = {default_char};
		for (int i = 0;i < 100; i++){
				bar[i] = default_char;
		}
		bar[100] = '\0';
		char *lab = "-\\|/";
		int loop = count / 100;
		int loop_count = 0;
		
		for (int i = 0; i < count; i++)
		{
				for (int j = i; j < count; j++)
				{
						int sum = 0;
						for (int k = i ; k <= j; k++)
						{
								sum += nums[k];
						}
//						printf("sum = %d\n",sum);
						if (sum > *max_sum)
						{
								*max_sum = sum;
						}
				}
				//提示进度
				if (i % loop == 0){
						printf("[%-100s][%d%%][%c]\r",bar,loop_count + 1,lab[loop_count % 4]);	
						fflush(stdout);
						bar[loop_count++] = '#';
				}	
		}
		printf("\n");
		end = clock();
		duration = ((double)(end - start)) / CLOCKS_PER_SEC;
		printf("-----------sum1 over!\n");
		return 0;
}

//在线处理求法

int sum2(int *max_sum,int *nums,int count)
{
		printf("-----------sum2:\n");
		start = clock();
		int sum = 0;
		for (int i = 0; i < count; i++){
				sum += nums[i];
				if (*max_sum < sum){
						*max_sum = sum;
				}
				if (sum < 0){
						sum = 0;
				}
		}	
		end = clock();
		duration = ((double)(end - start)) / CLOCKS_PER_SEC;
		printf("-----------sum2 over!\n");

		return 0;
}
