package com.web.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @describe 基类
 * @Author nana
 * @date 2021/4/14
 */
public class BaseTest {

    public static WebDriver webDriver;

    @BeforeAll
    public static void initDate(){

        String browserName = System.getenv("browser");

        if ("chrome".equals(browserName)){
            System.setProperty("webdriver.chrome.driver", "/Users/gengxiaona/software/driver/chromedriver");
            webDriver = new ChromeDriver();
//        }else if ("firefox".equals(browserName)){
//            System.setProperty("webdriver.gecko.driver", "/Users/gengxiaona/software/driver/chromedriver");
//            webDriver = new FirefoxDriver();
        }else if ("safari".equals(browserName)){
            webDriver = new SafariDriver();
        }
    }

    @AfterAll
    public static void close(){
        webDriver.quit();
    }
}
