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

import java.util.concurrent.TimeUnit;

public class SignInHomework {
    //1. Create a class SignInHomework
    WebDriver driver;


    // 2. Go to http://automationpractice.com/index.
    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    // 3. Click on sign in button
    @Test
    public void clickOnSignIn() {
        driver.findElement(By.xpath("//a[@class='login']")).click();
        // 4. Send your email and click on create an account button
        WebElement sendEmail = driver.findElement(By.xpath("//input[@id='email_create']"));
        sendEmail.sendKeys("aliatilgan@gmail.com");
        driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
        // 5.Verify the Text : CREATE AN ACCOUNT
        WebElement creatAnAccount=driver.findElement(By.xpath("//h1[@class='page-heading']"));
        Assert.assertTrue(creatAnAccount.isDisplayed());
        // 6. Verify the Text : YOUR PERSONAL INFORMATION
        WebElement yourPersonalInformation=driver.findElement(By.xpath("//h3[@class='page-subheading']"));
        Assert.assertTrue(yourPersonalInformation.isDisplayed());
        // 7. Verify the Text : Title
        WebElement title =driver.findElement(By.xpath("//*[.='Title']"));
        Assert.assertTrue(title.isDisplayed());
        // 8. Select your title
        WebElement titleSelection = driver.findElement(By.xpath("(//input[@name='id_gender'])[1]"));
        if(!titleSelection.isSelected()){
            titleSelection.click();
        }
        // 9. Enter your first name
        WebElement firstNameElement=driver.findElement(By.xpath("//input[@id='customer_firstname']"));
        firstNameElement.sendKeys("Ali");
        // 10. Enter your last name
        WebElement lastNameElement=driver.findElement(By.xpath("//input[@id='customer_lastname']"));
        lastNameElement.sendKeys("Atilgan");
        // 11. Enter your email
        WebElement emailElement= driver.findElement(By.xpath("//input[@id='email']"));
        emailElement.sendKeys("aliatilgan@gmail.com");
        // 12. Enter your password
        WebElement passwordElement=driver.findElement(By.xpath("//input[@type='password']"));
        passwordElement.sendKeys("1234");
        // 13. ENTER DATE OF BIRTH
        WebElement birthDayElement=driver.findElement(By.xpath("//select[@id='days']"));
        Select select=new Select(birthDayElement);
        select.selectByValue("1");

        WebElement birthMonthElement = driver.findElement(By.xpath("//select[@id='months']"));
        Select selectMonth = new Select(birthMonthElement);
        selectMonth.selectByIndex(5);

        WebElement birthYearElement=driver.findElement(By.xpath("//select[@id='years']"));
        Select selectYear=new Select(birthYearElement);
        selectYear.selectByValue("1988");

//        // 14. Click on Sign up for our newsletter!
        WebElement newsLetterElement=driver.findElement(By.xpath("//div[@class='checker']"));
        if(!newsLetterElement.isSelected()){
            newsLetterElement.click();
        }
//        // 15. Enter your first name
        WebElement firstName = driver.findElement(By.xpath("//input[@id='firstname']"));
        firstName.sendKeys("Ali");
//        // 16. Enter your last lane
        WebElement lastName = driver.findElement(By.xpath("//input[@id='lastname']"));
        lastName.sendKeys("Atilgan");
//        // 17. Enter your company
        WebElement companyName = driver.findElement(By.xpath("//input[@id='company']"));
        companyName.sendKeys("Atilgan AS");
//        // 18. Enter your Address
        WebElement address = driver.findElement(By.xpath("//input[@id='address1']"));
        address.sendKeys("16613 LaPaloma Lane Edmond");
//        // 19. Enter your City
        WebElement cityName=driver.findElement(By.xpath("//input[@id='city']"));
        cityName.sendKeys("Oklahoma");
//        // 20. SELECT STATE
        WebElement stateList = driver.findElement(By.xpath("//select[@name='id_state']"));
        Select selectState = new Select(stateList);
        selectState.selectByVisibleText("Oklahoma");
//        // 21. Enter Postal Code22.
        WebElement zipCode = driver.findElement(By.xpath("//input[@name='postcode']"));
        zipCode.sendKeys("73012");
//        // DO NOT SELECT COUNTRY
        WebElement countryList = driver.findElement(By.xpath("//select[@name='id_country']"));
        Select selectCountry=new Select(countryList);
        selectCountry.selectByVisibleText("United States");

//        // 23. Enter additional information
        WebElement additional = driver.findElement(By.xpath("//textarea[@id='other']"));
        additional.sendKeys("I learnt how to do this");
//        // 24. Enter home phone
        WebElement homePhoneNumber =driver.findElement(By.xpath("//input[@name='phone']"));
        homePhoneNumber.sendKeys("455435");
//        // 25. Enter mobile phone
        WebElement mobilePhoneNumber=driver.findElement(By.xpath("//input[@name='phone_mobile']"));
        mobilePhoneNumber.sendKeys("5345666");
//        // 26. Enter reference name
        WebElement referenceName=driver.findElement(By.xpath("//input[@name='alias']"));
        referenceName.sendKeys("Sibel");
//        // 27. Click Register
        WebElement clickButton = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        clickButton.click();
        // 28. Then verify the error message CONTAINS ‘error’THEN YOU SHOULD SEE SOME ERROR MESSAGE.
        //Then verify the error message CONTAINS ‘error’
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
        System.out.println(errorMessage.getText());

        Assert.assertTrue(errorMessage.getText().contains("error"));

//        // TAKE A SCREENSHOT MANUALLY AND SHARE WITH FROM CHAT
//        // ====Be careful about putting some wait if needed
    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
