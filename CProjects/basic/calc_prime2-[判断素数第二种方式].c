#include <stdio.h>
#include <stdbool.h>
//新的方式计算素数
/**
 *返回0不是素数，返回非0是素数
*/
int isPrime(int x,int primes[],int numberOfPrime);

int main () {
    int prime[100] = {2,};
    bool isP = false;
    printf("请输入一个数，我来判断是否是素数：\n");
    int inputNum;
    scanf("%d",&inputNum);
    while(inputNum <= 1){
	printf("请输入大于1的数！\n");
	scanf("%d",&inputNum);
    }
    int primeCount = 1;
    if(inputNum == 2){
	printf("%d是素数！\n",inputNum);
    } else {
	//遍历 3 - inputNum，让其中的素数除inputNum,
	for(int i = 3;i <= inputNum;i++){
	    if(isPrime(i,prime,primeCount)){
		prime[primeCount] = i;
		if (i == inputNum){
		    isP = true;
		}
		primeCount ++;
	    }
	}
    }

    if(isP){
	printf("%d是素数！\n",inputNum);
    } else{
    
	printf("%d不是素数！\n",inputNum);
    }

    //遍历素数数组
    for(int i = 0;i < primeCount;i ++){
	printf("%d",prime[i]);
	if (i % 5 == 0 && i != 0){
	    printf("\n");
	} else{
	    printf("\t");
	}
    }
}

int isPrime(int x,int primes[],int numberOfPrime){
    int result = 1;
    for(int i = 0;i < numberOfPrime;i++){
	if(x % primes[i] == 0){
	    //找到因数了
	    result = 0;
	    break;
	}
    }

    return result;
}
