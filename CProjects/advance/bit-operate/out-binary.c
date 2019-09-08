#include <stdio.h>

//input decimal num and then output binary num
int main(int argc,char* const argv[]){
	
	printf("Plese input a number:\n");
	int number;
	scanf("%d",&number);
	unsigned mask = 1u << 31;
	int firstBitMask = -1;
	for(;mask != 0;mask >>= 1){
		int curBit;
		curBit = mask & number ? 1 : 0;
		if(firstBitMask == -1 && curBit == 1){
			firstBitMask = 0;
			printf("0x");
		}
		if (firstBitMask == 0){
			printf("%d",curBit);
		}
		
	}
	printf("\n");
	return 0;
}
