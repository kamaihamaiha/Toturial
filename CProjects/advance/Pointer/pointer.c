#include <stdio.h>

//指针：就是保存地址的变量

int getP(int *p);
int change(int *p);

int main(){
    int a = 2;
    int b = 19;
    printf("a的地址是：%p\n",&a);

    //用函数获取变量的值
    int address = getP(&a);
    printf("变量的值为：%d\n",address);
    printf("下面要调用修改变量值的方法了！\n");
    change(&a);
    printf("修改后的变量值为：%d\n",a);
    
}

int getP(int *p){

    return *p;
}

int change(int *p){
    *p = 666;
    return 0;
}



