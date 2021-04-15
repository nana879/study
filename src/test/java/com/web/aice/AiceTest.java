package com.web.aice;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @describe
 * @Author nana
 * @date 2021/4/13
 */
public class AiceTest {
    public static WebDriver webDriver;
    public static WebDriverWait webDriverWait;
    @BeforeAll
    public static void initDate(){
        System.setProperty("webdriver.chrome.driver", "/Users/gengxiaona/software/driver/chromedriver");
        webDriver = new ChromeDriver();
        // 隐式等待
        // 页面没有完全加载完成，元素有时会找不到，可以加入隐式等待，解决元素找不到问题
        // 设置一个等待时间，轮询查找（默认0.5秒）元素是否出现，如果没有出现就抛出异常
//        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //显示等待
        //在代码中定义等待条件，当条件发生时才继续执行代码
        //WebDriverWait配合unitl()方法，根据判断条件进行等待
        webDriverWait = new WebDriverWait(webDriver,5);
        //区别:显示等待可以针对于元素，隐式等待是针对于全局的
    }

    @Test
    public void login(){
        webDriver.get("http://home.testing-studio.com/");
        //指定元素点击
        webDriver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();

        webDriver.findElement(By.id("login-account-name")).clear();
        webDriver.findElement(By.id("login-account-name")).sendKeys("1137324155@qq.com");

        webDriver.findElement(By.id("login-account-password")).clear();
        webDriver.findElement(By.id("login-account-password")).sendKeys("Chengxuyuan890.");

        webDriver.findElement(By.id("login-button")).click();
    }

    @DisplayName("直接等待")
    @Test
    public void timeSleepTest(){
        webDriver.get("http://home.testing-studio.com/");
        try {
            //强制等待
            Thread.sleep(5000);
            webDriver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("显示等待")
    /**
     * Selenium在github上的地址：https://github.com/SeleniumHQ/selenium
     */
    @Test
    public void waitTest(){
        webDriver.get("http://home.testing-studio.com/");
        //第一种方法：匿名内部类的方法，可以做一些定制化的东西
//        WebElement loginEle = webDriverWait.until(new ExpectedCondition<WebElement>() {
//            public WebElement apply(WebDriver webDriver) {
//                return webDriver.findElement(By.xpath("//span[contains(text(),'登录')]"));
//            }
//        });
//        loginEle.click();

        //第二种方法：
        WebElement element = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'登录')]")));
        element.click();
    }

    @AfterAll
    public static void close(){
        webDriver.quit();
    }

}
