#include <stdio.h>
//思考：在一组给定的数据中，如何找出某个数据是否存在？

int computeArrayLength(int *arr);

int search(int key,int arr[],int length);

int main(){
	
	//数组的集成初始化
	int a[] = {3,1,4,1,5,9,2,6,5,3,5};

	//集成初始化时的定位
	
	int b[10] = {[0] = 1,[3] = 2,4,6};
	//只有C99可以这样
	//用[n]在初始化数据中给出定位
	//没有定位的数据接在前面的位置后面
	//其他位置的值补零
	//也可以不给出数组的大小，让编译器自己计算
	//特别适合初始数据稀疏的数组

	int size = sizeof(b) / sizeof(b[0]);
	for (int i = 0;i < size;i++){
		printf("b[%d] = %d\n",i,b[i]);
	}

	int c[6] = {1,2,3,4,5,6,};
	int cLength = sizeof(c) / sizeof(c[0]);
	printf("请输入你想找的数：\n");
	int num;
	scanf("%d",&num);
	int result = search(num,c,cLength);
	if(result == -1){
		printf("对不起，没有找到！\n");
	} else{
		printf("在数组的第 %d 个位置\n",result + 1);
	}
	return 0;
}

//计算数组大小,目前这样计算不正确。尚不知道如何改正...
int computeArrayLength(int *arr){
	int size;
	size = sizeof(arr) / sizeof(arr[0]);
	return size;
}

//从数组中找到某个元素，然后返回这个元素的索引位置
int search(int key,int arr[],int length){
	int index = -1;
	int i;
	for (i=0;i < length;i++){
		if (arr[i] == key){
			index = i;
			break;
		}
	}
	return index;
}
