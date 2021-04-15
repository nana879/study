package com.junit5.testcase;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class LoginAndBuyTest {
    private static HashMap<String,Object> dataMap = new HashMap<String, Object>();

    @Test
    void loginTest(){
//        dataMap.put("login","登录成功");
        dataMap.put("login","登录失败");
    }
// 1. 只有非静态嵌套类（即内部类）可以充当嵌套测试类
// 2. Nested执行时倒序执行（从下往上执行，先执行buyTest,再执行payTest
    @Nested
    class PayTest{
        @Test
        void payTest(){
            if (null!=dataMap.get("buy")){
                System.out.println("正在支付，请等待");
                System.out.println(dataMap.get("buy"));
            }else {
                System.out.println("你还没购买课程");
            }
        }
    }

    @Nested
    class BuyTest{
        @Test
        void buyTest(){
            if (dataMap.get("login").equals("登录成功")){
                System.out.println("登录成功了，可以购买了");
                dataMap.put("buy","购买了课程");
            }else {
                System.out.println("登录失败，请重新登录");
            }
        }
    }
}
