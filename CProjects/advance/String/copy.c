#include <stdio.h>
#include <string.h>

//自己实现字符串复制函数


char* copy_str(char* dst,const char* src){
	
	while(*src != '\0'){
		*dst = *src;
		dst++;
		src++;
	}
	//最后一位 '\0',也要复制
	*dst = *src;
	return dst; 
}

int main(){
	
	char *data = "Hello";		
	char copy[10];

	copy_str(copy,data);
	
	return 0;
}
