package com.au.UItest;

import com.au.Models.Planets;
import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PlanetTests {
    public WebDriver driver;

    public WebElement element;



    @BeforeEach
    public void SetUp()
    {

        GetWebDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
    }






    @Test
    public void TestPlanet() {
        driver.findElement(By.cssSelector("[aria-label=planets]")).click();

        new Planets(driver).getPlanet("Earth").clickExplore();

       Assert.assertEquals("Exploring Earth",new Planets(driver).getPopUpMsg());


    }






//    public void TestPlanet() {
//        driver.findElement(By.cssSelector("[aria-label=planets]")).click();
//
//
//
//
//        driver.findElements(By.className("planet"))
//
//
//        for(WebElement option:driver.findElements(By.className("planet")))
//        {
//
//            if(option.findElement(By.className("name")).getText().equalsIgnoreCase("earth")) {
//
//                option.findElement(By.tagName("button")).click();
//
//            }
//
//
//        }
//
//
//
//
//    }
//




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

