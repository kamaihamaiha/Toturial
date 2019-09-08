#include <stdio.h>

int main (){
    int a[10];

    //分别查看地址
    printf("%p\n",&a);
    printf("%p\n",a);
    printf("%p\n",&a[0]);
    printf("%p\n",&a[1]);
}
