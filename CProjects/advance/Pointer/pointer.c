#include <stdio.h>

//ָ�룺���Ǳ����ַ�ı���

int getP(int *p);
int change(int *p);

int main(){
    int a = 2;
    int b = 19;
    printf("a�ĵ�ַ�ǣ�%p\n",&a);

    //�ú�����ȡ������ֵ
    int address = getP(&a);
    printf("������ֵΪ��%d\n",address);
    printf("����Ҫ�����޸ı���ֵ�ķ����ˣ�\n");
    change(&a);
    printf("�޸ĺ�ı���ֵΪ��%d\n",a);
    
}

int getP(int *p){

    return *p;
}

int change(int *p){
    *p = 666;
    return 0;
}



