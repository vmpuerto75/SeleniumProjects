package com.odeoncinema.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {

    public static By sessionSelect=By.className("btn-select-arrow");
    public static By iupaySelector=By.id("iupay-field");
    public static By acceptbutton=By.name("boton");
    
    public void selectIUPay(WebDriver driver)
    {   //WARNING:This not works without the wait!
    	WebDriverWait wait = new WebDriverWait(driver, 15, 100);
        wait.until(ExpectedConditions.presenceOfElementLocated(iupaySelector));
    	driver.findElement(iupaySelector).click();
    	driver.findElement(acceptbutton).click();	
    }
}