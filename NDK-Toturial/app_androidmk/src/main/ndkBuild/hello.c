#include <jni.h>

int greet (){

    return 2019;
}

jint Java_com_kk_app_1androidmk_Hello_greet(){
    return greet();
}

