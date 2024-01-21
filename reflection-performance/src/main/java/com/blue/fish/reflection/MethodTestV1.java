package com.blue.fish.reflection;

import java.lang.reflect.Method;

/**
 * （1）直接下面代码测试：  3174
 * （2）添加虚拟机参数：-Djava.lang.Integer.IntegerCache.high=128   时长：1538
 *
 * @author BlueFish 2024/1/21 20:17
 */
public class MethodTestV1 {

    public static void target(int i){

    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.blue.fish.reflection.MethodTestV1");
        Method method = clazz.getMethod("target", int.class);
        long current = System.currentTimeMillis();
        // 0   3174
        for (int i = 0; i < 2_000_000_000; i++) {
            if (i % 1_000_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }
            method.invoke(null, 128);
        }
    }
}
