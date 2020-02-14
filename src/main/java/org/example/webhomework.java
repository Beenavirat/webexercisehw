package org.example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


//import jdk.internal.jline.internal.TestAccessible;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class webhomework {
    @Before
    // open Browser
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver","src\\test\\java/org\\example\\chromedriver.exe ");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    // creating parameterized method for clicking an element
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }
    // create method for enter text/sendkey
    public void sendkey(By by,String text){
        driver.findElement(by).sendKeys(text);
    }
    // creating method for selectFromDropDownByValue
    public void selectFromDropDownByValue(By by,String text){
        Select select=new Select(driver.findElement(by));
        select.selectByValue(text);
    }
    // creating method for selectFromDropDownByVisible Text
    public void selectFromDropDownByVisibleText(By by,String text){
        Select select=new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }
    //creating method for selectFromDropDownByIndex
    public void selectFromDropDownByIndex(By by,int index) {
        Select select=new Select(driver.findElement(by));
        select.selectByIndex(index);
    }

    //Get text from element
    public String getTextfromElement(By by){
        return driver.findElement(by).getText();
    }
    //
    public String timestamp() {
        DateFormat dateFormat = new SimpleDateFormat("ddmmyy");
        Date date = new Date();
        return (dateFormat.format(date));
    }




    static protected WebDriver driver;
    @Test
    public void UserShouldBeAbleToRegisterSuccessfullyocado()
    {
        // Open url
        driver.get("https://www.ocado.com/");

        // clk Register
        clickOnElement(By.xpath("//*[@id=\"quickReg\"]"));
        // driver.findElement(By.xpath("//*[@id=\"quickReg\"]")).click();

        //select title
        sendkey(By.name("title"), "mrs");
        //  driver.findElement(By.name("title")).sendKeys("mrs");

        //Enter Firstname
        sendkey(By.id("firstName"), "abcd");
        // driver.findElement(By.id("firstName")).sendKeys("abcd");

        // Enter lastname
        sendkey(By.name("lastName"), "xyzz");
        // driver.findElement(By.name("lastName")).sendKeys("xyzz");

        //Enter email
        sendkey(By.id("login"), "test+" + timestamp() + "@test.com");
        // driver.findElement(By.id("login")).sendKeys("test@test.com");

        //Enter password
        sendkey(By.name("password"), "abcd12");
        //driver.findElement(By.name("password")).sendKeys("abcd12");

        // enter postcode
        sendkey(By.name("postcode"), "ab12xy");
        // driver.findElement(By.name("postcode")).sendKeys("ab12xy");

        //Clk Register
        clickOnElement(By.xpath("//*[@id=\"registration-submit-button\"]"));
        //   driver.findElement(By.xpath("//*[@id=\"registration-submit-button\"]")).click();

        String actual=driver.findElement(By.xpath("//h2[contains(text(),' there soon')]")).getText();
        String expected= "my registration is not successfully";
        Assert.assertEquals("fail",expected,actual);
    }

    @Test

    public void UserShouldBeAbleToRegisterSuccessfullypizza(){


        driver.get("https://www.dominos.co.uk/");

        //Clk on register
        // clickOnElement (By.xpath("//*[@id=\"account-overlay\"]/ul/li[2]/a)."));

        driver.findElement(By.xpath("//*[@id=\"account-overlay\"]/ul/li[2]/a")).click();

        try{
            Thread.sleep(4000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        // WebDriverWait wait=new WebDriverWait(driver,70);
        // wait.until(ExpectedConditions.elementToBeClickable(By.id("register-button")));
        //  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"account-overlay\"]/ul/li[2]/a")));


        //Enter Firstname

        sendkey(By.name("FirstName"),"abcd");


        // Enter Password

        sendkey(By.xpath("//*[@id=\"registerPanel\"]/div/form/div[2]/div[1]/div/input"),"abcd12");

        //Enter contact no

        // sendkey(By.xpath("//*[@id=\\\"registerPanel\\\"]/div/form/div[1]/div[2]/input\""),"123456");
        driver.findElement(By.xpath("//*[@id=\"registerPanel\"]/div/form/div[1]/div[2]/input")).sendKeys("07912345678");

        // Enter email
        sendkey(By.name("Email"),"test12+"+timestamp()+"@test.com");

        //Enter Postcode
        sendkey(By.name("PostcodeLookup"),"ab12cd");

        //Clk on Register
        clickOnElement(By.xpath("//*[@id=\"registerPanel\"]/div/form/div[3]/button"));


    }
    @Test
    public void userShouldBeAbleToRegisterSuccessfullynopcomm (){

        driver.get("https://demo.nopcommerce.com/");
        // Clk on register
        clickOnElement(By.linkText("Register"));
        //  waitForClickable(By);
        try{
            Thread.sleep(4000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        // Enter first name
        sendkey(By.id("FirstName"),"abcd");

        //Enter lastname
        sendkey(By.id("LastName"),"xyz");

        // selectDropDownfrom for date of birth
        selectFromDropDownByValue(By.name("DateOfBirthDay"),"30");
        selectFromDropDownByIndex(By.name("DateOfBirthMonth"), 2);
        selectFromDropDownByVisibleText(By.name("DateOfBirthYear"),"1977");

        //Enter Email
        sendkey(By.id("Email"),"test12+"+timestamp()+"@test.com");
        //Enter Password
        sendkey(By.id("Password"),"abc123");
        // Enter Confirm password
        sendkey(By.id("ConfirmPassword"),"abc123");
        //clk on Register
        clickOnElement(By.id("register-button"));

      // enter Assert method
        String actual=driver.findElement(By.className("result")).getText();
        String expected="My Registration successfully";
        Assert.assertEquals("failed",expected,actual);

    }
}























