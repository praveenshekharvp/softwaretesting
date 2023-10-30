package Bookingtest;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Booking.Bookingpage;

public class test {
	
	WebDriver driver;
	@BeforeTest
	public void set()
	{
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void urlloading()
	{
		driver.get("https://www.booking.com/");
	}
	@Test
	public void testpage()
	{
		Bookingpage obj= new Bookingpage(driver);
		driver.manage().window().maximize();
		obj.Bookingstay();
		obj.date();
		obj.search();
	}

}
