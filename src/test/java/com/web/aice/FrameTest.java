package com.web.aice;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @describe 多frame切换
 * @Author nana
 * @date 2021/4/14
 */
public class FrameTest {
    public static WebDriver webDriver;
    @BeforeAll
    public static void initDate(){
        System.setProperty("webdriver.chrome.driver", "/Users/gengxiaona/software/driver/chromedriver");
        webDriver = new ChromeDriver();
        // 隐式等待
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    void switchWindowTest() throws InterruptedException {
        webDriver.get("https://www.runoob.com/try/try.php?filename=jqueryui-api-droppable");

        webDriver.switchTo().frame("iframeResult");
        System.out.println(webDriver.findElement(By.id("draggable")).getText());

        webDriver.switchTo().parentFrame();
        System.out.println(webDriver.findElement(By.id("submitBTN")).getText());
    }


    @AfterAll
    public static void close(){
        webDriver.quit();
    }

}
