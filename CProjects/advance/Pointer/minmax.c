#include <stdio.h>
//计算数组中的最大和最小值

void main(){
	int arr[] = {3,1,4,1,5,9,2,6};
	int min = arr[0];
	int max = arr[0];
	min_max(&min,&max,arr,sizeof(arr) / sizeof(arr[0]));
	printf("min=%d,max=%d",min,max);
} 

int min_max(int *min,int *max,int array[],int len){
	if(len == 1){
		return 0;
	}
	int i;
	for(i = 0;i < len;i++){
		if(*max < array[i]){
			*max = array[i];
		}
		if(*min > array[i]){
			*min = array[i];
		}
	}
	return 0;
}
