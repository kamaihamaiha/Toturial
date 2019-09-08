#include <stdio.h>
//C语言的类型
//1.整数 char,short,int,long,long long
//2.浮点数 float,double,long double
//3.逻辑 bool
//4.指针
//5.自定义类型


//运算符：sizeof,可以计算出某个类型或变量在内存中所占据的字节数

int main(){
    
    float ff = 8.001;
    printf("sizeof(ff)=%ld\n",sizeof(ff));
    
    printf("sizeof(float)=%ld\n",sizeof(float));

    return 0;
}
