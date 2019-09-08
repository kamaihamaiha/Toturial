#include <stdio.h>
#include <stdlib.h>

int main(){
	int size;
	int* p;
	printf("please input array size:");
	scanf("%d",&size);
	printf("size=%d\n",size);
	p =(int*)malloc(size * sizeof(int));
	int i;
	for(i = 0;i < size;i++){
		printf("----%d\n",i);
	}
	free(p);	
	return 0;
	
}
