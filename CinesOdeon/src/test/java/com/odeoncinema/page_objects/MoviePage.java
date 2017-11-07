package com.odeoncinema.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoviePage {

    public static By sessionSelect=By.className("btn-select-arrow");
    
    public void selectSession(WebDriver driver, String date,String hour)
    {   //WARNING:This not works without the wait!
    	WebDriverWait wait = new WebDriverWait(driver, 15, 100);
        wait.until(ExpectedConditions.presenceOfElementLocated(sessionSelect));
    	driver.findElement(sessionSelect).click();
    	WebElement day=driver.findElement(By.xpath("//*[contains(text(), '"+date+"')]"));
    	day.click();
    	WebElement session=driver.findElement(By.cssSelector("div[class='LinksHoras0 Dia"+day.getAttribute("pos")+"'")).findElement(By.partialLinkText(hour));
    	session.click();
    }
}