#include <stdio.h>

int main(int argc,char const *argv[]){
	
	printf("�������ַ� ��\n");
	
	int ch;
	
	while ((ch = getchar()) != EOF ){
		putchar(ch);
	}
	
	printf("������ EOF\n"); 
	return 0;
}


