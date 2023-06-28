package com.au.UItest;

import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import java.util.Set;

public class ElementTest {
    private WebDriver driver;

    @BeforeEach
    public void SetUp()
    {

        GetWebDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
    }

    @Test
    public void TestOne() {
        driver.findElement(By.id("forename")).sendKeys("TestName");
        driver.findElement(By.id("submit")).click();
     // String data= driver.findElement(By.xpath("//h1[@class='display-1 mb-3']")).getText();
        String data= driver.findElement(By.className("display-1")).getText();
        System.out.println(data);
        Assert.assertEquals("Web Playground",data);
    }



    @Test
    public void TestClickMeDownText() {

        driver.findElement(By.cssSelector("[role=button]")).click();



         new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//a[contains(@class,'transition-y')]")),"CLICK ME UP!"));
        driver.findElement(By.xpath("//a[contains(@class,'transition-y')]")).click();

        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("[role=button]")),"CLICK ME DOWN!"));
    }





    @AfterEach
    public void Close()
    {
        driver.quit();
    }

    private void GetWebDriver()
    {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(options);

    }
}