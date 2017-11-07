package com.odeoncinema.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage {

    public static By cinemaMenu = By.id("dropdownMenu1");
    public static By cinemaDropDownMenu=By.className("dropdown-menu");
    
    public void selectCinema(WebDriver driver, String cinema)
    {
    	driver.findElement(cinemaMenu).click();
    	//WebDriverWait wait = new WebDriverWait(driver, 15, 100);
    	//WebElement myElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(cinema)));
    	driver.findElement(cinemaDropDownMenu).findElement(By.partialLinkText(cinema)).click();
     
    	
    }
}