package com.au.Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormClass {

   private WebDriver driver;


    public FormClass(WebDriver d) {
        driver=d;

    }

    public void typeName(String testName) {
        driver.findElement(By.id("name")).sendKeys(testName);
    }

    public void setEmail(String mail) {
        driver.findElement(By.id("email")).sendKeys(mail);
    }


}
