package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Template {
    //Khai báo 1 biến đại diện cho Selenium WebDriver
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {
//		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//		driver = new FirefoxDriver();

        System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");

        // Khởi tạo browser lên
        driver = new ChromeDriver();

        //Set thời gian chờ để tìm đc element
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        // Mở fb lên
     driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_01() {
        //Selenium locator (By class)

        //ID
        driver.findElement(By.id("email")).sendKeys("quanganh.plus@gmail.com");
        sleepInSecond(3);

        //Name
        driver.findElement(By.name("pass")).sendKeys("123456");
        sleepInSecond(3);
    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSecond(long second){
        try{
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}