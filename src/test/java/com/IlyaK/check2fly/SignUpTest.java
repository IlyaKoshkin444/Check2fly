package com.IlyaK.check2fly;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignUpTest extends TestBase {

    @Test
    public void openCheck2FlyTest() throws InterruptedException {

        ClickSignUpNewUser();
        InputFirstName();
        InputLastName();
        InputPhone();
        InputEmail();
        InputPassword();
        InputConfirmPassword();
        SelectCheckboxes();
        ClickSignUp();
        Thread.sleep(5000);//just that would be comfortable you to look  the eyes of


    }


}