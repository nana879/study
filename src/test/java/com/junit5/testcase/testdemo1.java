package com.junit5.testcase;

import org.junit.jupiter.api.*;

@DisplayName("junit5测试")
public class testdemo1 {
    @BeforeAll
    public static void beforeAll(){
        System.out.println("beforeAll");
    }
    @BeforeEach
    public void beforeEach(){
        System.out.println("beforeEach");
    }
    @Test
    @DisplayName("test1测试方法")
    @RepeatedTest(5)
    void test1(){
        System.out.println("test1");
    }
    @Test
    @Disabled
    void test2(){
        System.out.println("test2");
    }
    @AfterEach
    public void afterEach(){
        System.out.println("afterEach");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("afterAll");
    }
}
