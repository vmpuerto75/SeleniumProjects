package com.odeoncinema.page_objects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.odeoncinema.conditions.AdditionalConditions;

public class TicketsPage {

    public static By numberRowsId=By.id("NumFila");
    public static By cancelButton=By.id("BtnCancelar");
    public static By acceptButton=By.className("BtnAceptar");
    public static By emailInput=By.id("Email");
    public static By repEmailInput=By.id("RepEmail");
    public static By phoneInput=By.id("Telefono");
    public static By continueButton=By.linkText("Continuar");
    public static By bookAndContinueButton=By.xpath("//*[contains(@onclick, 'BotonReservarYSeguir')]");
    
    public void selectSeat(WebDriver driver, int num_row, int num_seat)
    { 
      int num_rows=Integer.parseInt(driver.findElement(numberRowsId).getText());
      //System.out.println("NumRows:"+num_rows);
      int internal_num_row=num_rows-num_row+1;
      WebElement selectedSeat=driver.findElement(By.xpath("//*[contains(@onclick, '"+internal_num_row+", "+num_seat+")')]"));
      selectedSeat.click();
      WebDriverWait wait = new WebDriverWait(driver, 15, 100);
      //Wait until is selected
      wait.until(AdditionalConditions.jQueryAJAXCallsHaveCompleted());
      wait.until(ExpectedConditions.attributeContains(selectedSeat.findElement(By.tagName("img")), "src", "seleccionado"));
      
      driver.findElement(continueButton).click();
      
    }
    
    public void ticketType(WebDriver driver)
    { 
      driver.findElement(bookAndContinueButton).click();
      
    }
    
    public void cancelPurchase(WebDriver driver)
    {  WebDriverWait wait = new WebDriverWait(driver, 15, 100);
       wait.until(ExpectedConditions.presenceOfElementLocated(cancelButton)).click();;
    }
    
    public void purchaseTicket(WebDriver driver, String email, String phoneNumber)
    {  WebDriverWait wait = new WebDriverWait(driver, 15, 100);
       wait.until(ExpectedConditions.presenceOfElementLocated(acceptButton));
       driver.findElement(emailInput).sendKeys(email);
       driver.findElement(repEmailInput).sendKeys(email);
       driver.findElement(phoneInput).sendKeys(phoneNumber);
       driver.findElement(acceptButton).click();
       Alert alert = driver.switchTo().alert();
       alert.accept();
    }
}