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
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day06_DropDown {
    //Create a class name : DropDown
    //Go to https://the-internet.herokuapp.com/dropdown
    //1.Create method selectByIndexTest and Select and Print Option 1 using index
    //2.Create method selectByValueTest and Select and Print Option 2 by value
    //3.Create method selectByVisibleTest and Select and Print Option 1 value by visible text
    //4.Create method printAllTest and Print all dropdown value
    //5.Create method printFirstSelectedOptionTest and Print first selected option
    //6.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 4 elements in the dropdown.
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @Test
    public void selectByIndexTest(){
        //Select1: Locating the dropdown element
        WebElement dropDownElement = driver.findElement(By.id("dropdown"));

        //Step 2: use Select class to control the dropdown object
        Select select = new Select(dropDownElement);

        //Step 3: I can now select any option by 3 different ways
        //selectByValue, selectByIndex, selectByVisibleText
        select.selectByIndex(1);



    }
    @Test
    public void selectByValueTest() throws InterruptedException {
        //2.Create method selectByValueTest and Select and Print Option 2 by value
        //Select1: Locating the dropdown element
        WebElement dropDownElement = driver.findElement(By.id("dropdown"));
        //Step 2: use Select class to control the dropdown object
        Select select = new Select(dropDownElement);
        Thread.sleep(5000);
        select.selectByValue("2");
        Thread.sleep(5000);
    }

    @Test
    public void selectByVisibleText() throws InterruptedException {
        //3.Create method selectByVisibleTest and Select and Print Option 1 value by visible text
        //Select1: Locating the dropdown element
        WebElement dropDownElement = driver.findElement(By.id("dropdown"));
        //Step 2: use Select class to control the dropdown object
        Select select = new Select(dropDownElement);
        Thread.sleep(5000);
        select.selectByVisibleText("Option 1");
        Thread.sleep(5000);
    }
    @Test
    public void printAll(){
        //4.Create method printAllTest and Print all dropdown value
        //Select1: Locating the dropdown element
        WebElement dropDownElement = driver.findElement(By.id("dropdown"));
        //Step 2: use Select class to control the dropdown object
        Select select = new Select(dropDownElement);

        List<WebElement> allOptions=select.getOptions();
        for (WebElement each: allOptions) {
            System.out.println(each.getText());
        }
    }
    @Test
    public void printFirstSelectedOptionTest(){
//5.Create method printFirstSelectedOptionTest and Print first selected option
        //Select1: Locating the dropdown element
        WebElement dropDownElement = driver.findElement(By.id("dropdown"));
        //Step 2: use Select class to control the dropdown object
        Select select = new Select(dropDownElement);
        String selectedOption = select.getFirstSelectedOption().getText();
//        select.getFirstSelectedOption();   returns selected option as webElement
        System.out.println(selectedOption);

    }
    @Test
    public void dropDownSizeTest(){
        //6.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 4 elements in the dropdown.
        //Select1: Locating the dropdown element
        WebElement dropDownElement = driver.findElement(By.id("dropdown"));
        //Step 2: use Select class to control the dropdown object
        Select select = new Select(dropDownElement);
        int numberOfOptions = select.getOptions().size();
        Assert.assertEquals("Expected Is Not Equal Actual",4, numberOfOptions);


    }


    @After
    public void tearDown(){
        driver.quit();
    }

    /*
    *FLOW
    * @Before -> selectByVisibleText ->
    * @Before -> selectByIndexTest -> @After ->
    * @Before -> selectByValue -> @After
     */
}
