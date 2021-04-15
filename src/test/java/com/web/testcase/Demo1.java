package com.web.testcase;

import org.junit.jupiter.api.Test;

/**
 * @describe 第1个示例
 * @Author nana
 * @date 2021/4/13
 */
public class Demo1 extends BaseTest {
    @Test
    void startSelenium(){
        //访问网址
        webDriver.get("http://home.testing-studio.com");
    }
}
