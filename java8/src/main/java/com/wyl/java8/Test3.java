/**
 * @Author wangyl
 * @E-mail wangyl@dsgdata.com
 **/
package com.wyl.java8;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName: Test3
 * @Function: TODO
 * @Date: 2019/11/25 21:57
 * @author wyl
 * @version V1.0
 */
public class Test3 {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("wyl", "WYL!", "Wyl2", "WyL3");
        str.stream();
        str.parallelStream();
    }
}
