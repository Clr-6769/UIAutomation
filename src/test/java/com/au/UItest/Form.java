package com.au.UItest;

import com.au.Models.FormClass;
import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;

public class Form {
    public WebDriver driver;



    @BeforeEach
    public void SetUp()
    {

        GetWebDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
    }




    @Test
    public void FillForm() {

        driver.findElement(By.cssSelector("[aria-label=forms]")).click();

        FormClass form=new FormClass(driver);
        form.typeName("TestName");
        form.setEmail("t.t@t.com");
//        form.selectSate("nsw");
//        form.checkAgree();
//        form.submit();

       // driver.findElement(By.cssSelector("[aria-label=forms]")).click();
//        driver.findElement(By.id("name")).sendKeys("TestName");
//        driver.findElement(By.id("email")).sendKeys("testemail@e.com");
        driver.findElement(By.className("v-select__selections")).click();
        //driver.findElements(By.cssSelector(".v-list-item__title"));

        new WebDriverWait(driver,Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector("[role=option]"))));
        for(WebElement option:driver.findElements(By.cssSelector("[role=option]")))
        {
            System.out.println("firs"+option.getText());
            if(option.getText().equalsIgnoreCase("nsw"))
            {
                option.click();
                //System.out.println(option.getText());
            }

        }
        driver.findElement(By.cssSelector("[for=agree]")).click();

        for(WebElement op:driver.findElements(By.cssSelector(".v-btn__content")))
        {
            System.out.println(op.getText());
            if(op.getText().equalsIgnoreCase("submit"))
            {
                op.click();
            }
        }

        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector(".snackbar"))));

         System.out.println(driver.findElement(By.cssSelector(".snackbar")).getText());
         Assert.assertEquals("Thanks for your feedback TestName",driver.findElement(By.cssSelector(".snackbar")).getText());
    }






    @AfterEach
    public void Close()
    {
       // driver.quit();
    }

    public void GetWebDriver()
    {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(options);

    }
}
