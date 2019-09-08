#include <stdio.h>

int main(int argc,char const *argv[]){
	
	printf("ÇëÊäÈë×Ö·û £º\n");
	
	int ch;
	
	while ((ch = getchar()) != EOF ){
		putchar(ch);
	}
	
	printf("¶Áµ½ÁË EOF\n"); 
	return 0;
}


