#include <stdio.h>
//字符串是以字符数组的形式存在的

void main(){

    //1.以0结尾的一串字符
    //2.0或者'\0'是一样的，但是和'0'不同
    //3.0标志字符串的结束，但它不是字符串的一部分
    //4.计算字符串长度的时候不包含这个0
    //5.字符串以数组的形式存在，以数组或指针的形式访问
    //6.更多的是以指针的形式
    //7.string.h 里有很多处理字符串的函数

    char *str = "Hello";
    char world[] = "Hello";
    char line[10] = "Hello";

    //读取输入字符到字符数组,这样如果输入的不是空格、回车、换行符号的话，输入多少就会接收多少
    char input[8];
    scanf("%7s",input);
    printf("%s\n",input);

    //限制字符数串的个数
    scanf("%4s",input);
    printf("%s\n",input);

}
