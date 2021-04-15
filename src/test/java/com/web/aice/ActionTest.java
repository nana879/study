package com.web.aice;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.util.concurrent.TimeUnit;

/**
 * @describe action测试
 * @Author nana
 * @date 2021/4/14
 */
public class ActionTest {
    public static WebDriver webDriver;
    public static Actions actions;
    @BeforeAll
    public static void initDate(){
        System.setProperty("webdriver.chrome.driver", "/Users/gengxiaona/software/driver/chromedriver");
        webDriver = new ChromeDriver();
        // 隐式等待
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actions = new Actions(webDriver);
    }

    @Test
    void clickTest(){
        webDriver.get("http://home.testing-studio.com/");
        actions.click(webDriver.findElement(By.xpath("//span[contains(text(),'登录')]")));
        actions.doubleClick(webDriver.findElement(By.xpath("//span[contains(text(),'登录')]")));
        actions.contextClick(webDriver.findElement(By.xpath("//span[contains(text(),'登录')]")));
        actions.perform();
    }

    @Test
    void movetest(){
        try {
            webDriver.get("https://www.baidu.com");
            actions.moveToElement(webDriver.findElement(By.id("s-usersetting-top")));
            actions.perform();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void scorllTest(){
        try {
            webDriver.get("https://www.baidu.com");
            webDriver.findElement(By.id("kw")).sendKeys("霍格沃兹测试学院");
            TouchActions actions = new TouchActions(webDriver);
            actions.click(webDriver.findElement(By.id("su")));

            JavascriptExecutor js = (JavascriptExecutor)webDriver;
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

            webDriver.findElement(By.xpath("//a[@class='n']")).click();

            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void close(){
        webDriver.quit();
    }
}
