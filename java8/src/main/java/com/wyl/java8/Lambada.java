/**
 * @Author wangyl
 * @E-mail wangyl@dsgdata.com
 **/
package com.wyl.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @ClassName: Test1
 * @Function: TODO
 * @Date: 2019/11/25 21:08
 * @author wyl
 * @version V1.0
 */
public class Lambada {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //完全体
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        //1
        list.forEach(l -> {
            System.out.println(l);
        });
        //2
        list.forEach((Integer i) -> {
            System.out.println(i);
        });
        //3方法引用 函数式接口 可以使用方法引用的方式创建一个函数式接口的实例
        list.forEach(System.out::println);
    }
}
