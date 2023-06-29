package com.au.Models;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Planets {

    private  WebDriver driver;

    public Planets(WebDriver driver) {
        this.driver=driver;

    }
    public List<Planet> getPlanets()
    {
        List<Planet> planetList = new ArrayList<Planet>();

         List<WebElement> elements= driver.findElements(By.className("planet"));

       for(WebElement element:elements)
       {
           planetList.add(new Planet(element));
       }
       return planetList;
    }


    public String getPopUpMsg() {

        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.className("snackbar"))));

        return  driver.findElement(By.className("snackbar")).getText();


    }


    public Planet getPlanet(String planetName)
    {
        for(Planet planet:getPlanets())

        {
            if(planet.getName("earth").equalsIgnoreCase(planetName))
            {
                return  planet;
            }
        }
        throw new NotFoundException("not found");
    }

}
