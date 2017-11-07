package com.odeoncinema.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TicketsPage {

    public static By numberRowsId=By.id("NumFila");
    
    public void selectSeat(WebDriver driver, int num_row, int num_seat)
    { 
      int num_rows=Integer.parseInt(driver.findElement(numberRowsId).getText());
      //System.out.println("NumRows:"+num_rows);
      int internal_num_row=num_rows-num_row+1;
      WebElement selectedSeat=driver.findElement(By.xpath("//*[contains(@onclick, '"+internal_num_row+", "+num_seat+")')]"));
      selectedSeat.click();
      WebDriverWait wait = new WebDriverWait(driver, 15, 100);
      //Wait until is selected
      wait.until(ExpectedConditions.attributeContains(selectedSeat.findElement(By.tagName("img")), "src", "seleccionado"));
      
      driver.findElement(By.linkText("Continuar")).click();
      
    }
    
    public void ticketType(WebDriver driver)
    { 
      driver.findElement(By.xpath("//*[contains(@onclick, 'BotonReservarYSeguir')]")).click();
      
    }
    
    public void cancelPurchase(WebDriver driver)
    { 
      driver.findElement(By.id("BtnCancelar")).click();
      
    }
}