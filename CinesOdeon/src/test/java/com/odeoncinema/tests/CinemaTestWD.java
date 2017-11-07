package com.odeoncinema.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.odeoncinema.DriverFactory;
import com.odeoncinema.page_objects.CinemaPage;
import com.odeoncinema.page_objects.IndexPage;
import com.odeoncinema.page_objects.MoviePage;
import com.odeoncinema.page_objects.PaymentPage;
import com.odeoncinema.page_objects.TicketsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

import org.hamcrest.Matcher;

public class CinemaTestWD extends DriverFactory {

    @Test
    public void buyTicket() throws Exception {
    	String url_index= "http://www.odeonmulticines.com/Principal/index";
    	String cinema="TRES CANTOS";
        String movieTitle="THOR: RAGNAROK";
        String sessionDate="09/11/2017";
        String sessionHour="20:05";
        int sessionRow=15;
        int sessionSeat=2;
        String email="vmpuerto75@gmail.com";
        String phoneNumber="555123456";
        
        WebDriver driver=getDriver();
        driver.get(url_index);
    	IndexPage indxp=new IndexPage();
    	indxp.selectCinema(driver, cinema);
    	CinemaPage cinemap=new CinemaPage();
    	cinemap.selectMovie(driver, movieTitle);
    	MoviePage moviep=new MoviePage();
    	moviep.selectSession(driver, sessionDate, sessionHour);
    	TicketsPage ticketsp=new TicketsPage();
    	ticketsp.selectSeat(driver, sessionRow, sessionSeat);
    	ticketsp.ticketType(driver);
    	//ticketsp.cancelPurchase(driver);
    	ticketsp.purchaseTicket(driver, email, phoneNumber);
    	PaymentPage payp=new PaymentPage();
    	payp.selectIUPay(driver);
    	assertThat(driver.getTitle(), containsString("iupay"));
    	//assertThat(driver.findElement(By.xpath("/html/body/div[1]/nav/div/div[1]/a")).getText(), is(equalTo("OM - odeon-tres-cantos")));
    }
}