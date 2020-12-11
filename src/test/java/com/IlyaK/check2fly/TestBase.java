package com.IlyaK.check2fly;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;


public class TestBase {
    static WebDriver wd;


    @BeforeSuite
    public void setUp() {
        String browser =
                System.getProperty("browser", BrowserType.CHROME);
        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.SAFARI)) {
            wd = new SafariDriver();
        }

        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        openSite("https://staging.check2fly.co.il/auth");
    }

    @AfterSuite
    public void tearDown() {
        wd.quit();
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void Type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void openSite(String url) {
        wd.get(url);
    }

    public void ClickSignUpNewUser() {
        click(By.xpath("//button[contains(text(),'Sign Up (new user)')]"));
    }
    public void InputFirstName() {
        Type(By.name("firstName"), "Leonard");
    }
    public void InputLastName() {
        Type(By.name("lastName"), "Cohen");
    }
    public void InputPhone() {
        Type(By.id("phone"), "543514868");
    }
    public void InputEmail(){
        Type(By.cssSelector("[ng-reflect-name='email']"), "Leonard.Cohen@gmail.com");
    }
    public void InputPassword(){
        Type(By.name("password"), "12345Qw@");
    }
    public void InputConfirmPassword(){
        Type(By.cssSelector("[ng-reflect-name='confirmPassword']"), "12345Qw@");
    }

    public void SelectCheckboxes(){
            selectCheckbox(By.cssSelector("#agreeToPromotional"));
            selectCheckbox(By.cssSelector("#agreeToTerms"));
        }
        protected void selectCheckbox(By locator) {
            WebElement element = wd.findElement(locator);
            Actions act = new Actions(wd);
            act.moveToElement(element, 5, 5).click().perform();
        }

    public void ClickSignUp(){click(By.xpath("//button[contains(text(),'Sign-up')]"));

    }
}
