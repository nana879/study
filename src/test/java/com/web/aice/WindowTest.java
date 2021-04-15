package com.web.aice;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @describe 多窗口
 * @Author nana
 * @date 2021/4/14
 */
public class WindowTest {
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
        webDriver.get("https://www.baidu.com");

        //将窗口最大化
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("//*[@id='u1']/a[last()]")).click();
        //1.先获取到当前的窗口句柄
        String baiduWin = webDriver.getWindowHandle();
        webDriver.findElement(By.xpath("//a[@class='pass-reglink pass-link']")).click();

        //2.再获取到所有的窗口句柄
        for (String win:webDriver.getWindowHandles()){
        //3.判断是否是想要操作的窗口，如果是，就可以对窗口进行操作，如果不是，跳转到另外一个窗口，对另一个窗口进行操作
            if (!win.equals(baiduWin)){
                webDriver.switchTo().window(win);
                webDriver.findElement(By.id("TANGRAM__PSP_4__userName")).sendKeys("aaaa");
                webDriver.findElement(By.id("TANGRAM__PSP_4__phone")).sendKeys("aaaa");

                webDriver.switchTo().window(baiduWin);
                webDriver.findElement(By.id("TANGRAM__PSP_11__footerULoginBtn")).click();
                webDriver.findElement(By.id("TANGRAM__PSP_11__userName")).sendKeys("aaa");
                webDriver.findElement(By.id("TANGRAM__PSP_11__password")).sendKeys("aaa");
                Thread.sleep(3000);
            }
        }
    }

}
