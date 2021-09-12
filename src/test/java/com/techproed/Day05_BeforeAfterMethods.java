package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day05_BeforeAfterMethods {
    //Create a class: BeforeAfterMethods
    //Then create 3 different test methods using the following names. And Go to google.
    //titleTest =>Verify if google title = “Google”
    //imageTest => Verify if google image displays or not
    //gmailLinkTest => Verify if the Gmail link is displayed or not
    //Close the browser after each test

    //I need 3 different test case so I will use 3 @Test annotation
    //WHAT IS REPEATING BEFORE EACH TEST CASE
    //@Before for repeating steps before each test
    // Create driver at class level so it will be visible to all of the classes.
    WebDriver driver;

    @Before
    public void setup(){
        //        Setting up chrome driver
        WebDriverManager.chromedriver().setup();
//        Creating driver
        driver = new ChromeDriver();
//        maximizing window
        driver.manage().window().maximize();
//        putting 5 second wait on the driver. This will wait up to 5 seconds WHEN NEEDED
//        This will NOT wait IF NOT NEEDED
//        For example, if the page is slow, the driver will wait up to 5 seconds
//        IMPLICIT WAIT IS DYNAMIC WAIT AND WE SHOULD USE THIS.
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//       Thread.sleep(5000); //This will wait 5 seconds even if NOT NEEDED. It will always
//        put 5 seconds wait. THIS IS HARD WAIT THAT WE SHOULD NOT USE IN OUR CODE
//        USING Thread.sleep makes execution longer due to teh unnecessary extra waits
        driver.get("https://www.google.com");
    }

    @Test
    public void titleTest() throws InterruptedException {

        String expectedTitle="Google";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }
    @Test
    public void imageTest(){

        WebElement googleImage = driver.findElement(By.xpath("//img[@class='lnXdpd']"));
        Assert.assertTrue(googleImage.isDisplayed());

    }

    @Test
    public void gmailLinkTest(){

            WebElement gmailLink = driver.findElement(By.xpath("//a[@class='gb_f'][1]"));
            Assert.assertTrue(gmailLink.isDisplayed());

    }

    //Wghat is repeating after each method?
    //We use @After method to move those repeated codes
    @After
    public void tearDown(){
        driver.quit();
    }

}
