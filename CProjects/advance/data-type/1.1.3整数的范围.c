#include <stdio.h>

int main(){
    
    unsigned char c1 = 255;
    printf("无符号字符变量c1=%d\n",c1);
    char c2=255;
    printf("c2=%d\n",c2);
    
    //现在求 int无符号 类型的最大数
    printf("下面输入的结果是int的最大数\n");

     unsigned  int a = 0;
    //while(++a > 0);
    unsigned int b = a - 1;
    printf("%u\n",b);

    return 0;
}
