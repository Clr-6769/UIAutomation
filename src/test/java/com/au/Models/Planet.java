package com.au.Models;

import org.openqa.selenium.WebElement;



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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Planet {


    private WebElement element;


    public Planet(WebElement ele) {

        element=ele;

    }



    public String getName(String earth) {
        return element.findElement(By.className("name")).getText();
    }

    public void clickExplore() {
        element.findElement(By.tagName("button")).click();
    }



}
