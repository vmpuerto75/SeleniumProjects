package com.odeoncinema.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CinemaPage {
     public static By dropdownPeliculasCuerpo=By.className("dropdownPeliculasCuerpo");
     public static By CapaSobreCartel=By.className("CapaSobreCartel");
    
    public void selectMovie(WebDriver driver, String title)
    {
    	WebElement movie=driver.findElement(dropdownPeliculasCuerpo).findElement(By.xpath("//*[contains(text(), '"+title+"')]/.."));
    	WebElement capa=movie.findElement(CapaSobreCartel);
    	//Scrolldown
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",movie);
    	Actions action = new Actions(driver);
    	WebDriverWait wait = new WebDriverWait(driver, 5, 100);
    	//Mouse over
    	action.moveToElement(movie).build().perform();
    	WebElement linkPases=capa.findElement(By.linkText("VER PASES"));
    	wait.until(ExpectedConditions.visibilityOf(linkPases));
    	action.moveToElement(linkPases).click().perform();
    }
}