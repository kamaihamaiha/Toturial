#include <stdio.h>

void cheer(int i){
	printf("干杯 %d\n",i);
}
//调用函数，传递的参数类型不匹配。
//也可以执行，但是会损失精度。这是C语言传统上最大的漏洞，编译器会悄悄把
//类型转化了，但是这样不是开发者希望看到的。而C++/Java在这方面会很严格
int main(){
	cheer(3.1);
	return 0;
}
