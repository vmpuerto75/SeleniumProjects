package com.odeoncinema.tests;


import org.openqa.selenium.WebDriver;
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


public class CinemaTestWD extends DriverFactory {
	public static String url_index= "http://www.odeonmulticines.com/Principal/index";
	public static String cinema="TRES CANTOS";
	public static String movieTitle="THOR: RAGNAROK";
	public static String sessionDate="09/11/2017";
	public static String sessionHour="20:05";
	public static int sessionRow=15;
	public static int sessionSeat=4;
	public static String email="vmpuerto75@gmail.com";
	public static String phoneNumber="555123456";
    
	@Test
    public void buyTicket() throws Exception {
    	
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
    	payp.waitPage(driver);
    	assertThat(driver.getTitle(), containsString("BBVA TPV Virtual"));
    }
}