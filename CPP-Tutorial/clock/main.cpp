#include <iostream>

using namespace std;

class A {

    //声明成员变量和函数
public:
    int i;
    A();
    ~A();
    void fun();
};

/**
 * 普通的一个函数
 */
void A::fun() {
    i = 10;
    cout << i << endl;
}

/**
 * 构造函数
 */
A::A(){
   cout << "this is constructor function" << endl;
}

/**
 * 析构函数
 */
A::~A() {
    cout << "this is destructor function" << endl;
}

int main() {
    std::cout << "Hello, World!" << std::endl;

    A a;
    a.fun();
    a.i = 20;
    cout << a.i << endl;
    a.fun();
    return 0;
}