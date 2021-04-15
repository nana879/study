package com.junit5.demo;

import com.utils.Calculator;
import org.junit.jupiter.api.RepeatedTest;

/**
 * @describe 并发场景测试
 * @Author nana
 * @date 2021/4/13
 */
public class ParallelDemo {
    @RepeatedTest(10)
    void countTest() throws InterruptedException {
        int result = Calculator.count(1);
        long name = Thread.currentThread().getId();
        System.out.println("线程号" + name + ",result" + result);
    }

    @RepeatedTest(10)
    void syncountTest() throws InterruptedException {
        int result = Calculator.synCount(1);
        long name = Thread.currentThread().getId();
        System.out.println("线程号" + name + ",result" + result);
    }
}
