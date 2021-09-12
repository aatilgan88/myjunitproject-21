package com.techproed;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day05_RadioButton {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");
    }
    @Test
    public void accountCreate() throws InterruptedException {
//        We can chain the methods
        driver.findElement(By.partialLinkText("Create New Account")).click();
//        WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
//        firstName.sendKeys("FakeName");
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("FakeName");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("FakeLast");
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("1234");

        //SELECT THE BIRTHDAY
        //Selecting months
        WebElement monthElement = driver.findElement(By.id("month"));
        Select month=new Select(monthElement);
        month.selectByVisibleText("Jan");

        //Selecting day
        WebElement dayElement = driver.findElement(By.id("Day"));
        Select day = new Select(dayElement);
        day.selectByValue("1");

        //Selecting year
        WebElement yearElement = driver.findElement(By.id("year"));
        Select year=new Select(yearElement);
        year.selectByVisibleText("1990");

//        SELECT GENDER
//        This is radio button
//        Identify the button element and click on it
        WebElement maleGender = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        if(!maleGender.isSelected()){
            maleGender.click();
        }

        Thread.sleep(5000);
        driver.findElement(By.name("websubmit")).click();
        Thread.sleep(5000);
    }
    @After
    public void tearDown(){
        driver.quit();
    }


}