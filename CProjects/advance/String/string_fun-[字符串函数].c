#include <stdio.h>
#include <string.h>

//字符串函数：string.h
//strlen,strcmp,strcpy,strcat,strchr,strrchr

int main(){
	
    //1.strlen,返回字符串长度
    //size_t strlen(const char *s);

    char str[] = "Hello";
    printf("调用strlen函数得到的字符串长度为：%lu\n",strlen(str));
    printf("调用sizeof函数得到的字符串床都为：%lu\n",sizeof(str));

    //2.strcmp,比较2个字符串
    //return 0 相等，return -n 第一个小于第二个字符串，return n  第一个大于第二个字符串

    //3.strcpy,把第二个参数的字符串复制到第一个参数上
    //char* strcpy(char *restrict dst,const char *restrict src);
    //restrict 表明 src 和 dst 不重叠(C99)
    //返回dst

    //4.strcat,把s2复制到s1的后面，连接成一个长的字符串，返回s1
    //char* strcat(char *restrict s1,const char *restrict s2);
    //s1必须有足够的空间

    //5.strchr,从字符串s中找到c第一次出现的位置，返回的是指针
    //char* strchr(const char *s,int c);
    
    //6.strrchr,从字符串s的右边开始找，找到c第一次出现的位置，返回的是指针
    //char* strrchr(const char *s,int c);


    //注意：strcmp,strcpy,strcat都不是安全的函数。下面是安全的版本
    //char* strncmp(const char *s1,const char *s2.size_t n);
    //char* strncpy(char *restrict dst,const char *restrict src,size_t n);
    //char* strncat(char *restrict s1,const char *restrict s2,size_t n);
    return 0;
}
