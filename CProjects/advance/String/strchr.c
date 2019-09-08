#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int main(int argc,char const *argv[]){
	
	char hello[] = "Hello Wrold,I am a coder.";
	char *p = strchr(hello,'I');
	char *front_str = (char*)malloc(strlen(hello) + 1);
	
	printf("%s\n",p);
	
	char temp = *p;
	*p = '\0';
	strcpy(front_str,hello);
	printf("the front str is : %s\n",hello);
	*p = temp;
	return 0;
}
