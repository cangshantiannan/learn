/**
 * @Author wangyl
 * @E-mail wangyl@dsgdata.com
 **/
package com.wyl.java8;

@FunctionalInterface
interface MyInterface {
    void test();
}

public class Test2 {
    public void myTest2(MyInterface myInterface) {
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
    }

    public static void main(String[] args) {
        Test2 tesxt2 = new Test2();
        tesxt2.myTest2(new MyInterface() {
            @Override
            public void test() {
                System.out.println("test");
            }
        });
        //lambada 表达式不接口参数时候()不能省略
        tesxt2.myTest2( ()->{
            System.out.println("test lambada");
        });
        //lambada 是对象 不是函数  在这里 lambada赋值给一个对象
        MyInterface myInterface = ()->{
            System.out.println("lambada 2");
        };
        myInterface.test();
    }
}
