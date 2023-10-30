package Booking;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Bookingpage {
	WebDriver driver;
	
	By stays=By.xpath("//*[@id=\"accommodations\"]");
	
	
	
	By place=By.xpath("//*[@id=\":re:\"]");
	By calendar=By.xpath("//*[@id=\"b2searchresultsPage\"]/div[4]/div/div/div/form/div[1]/div[2]/div/div[1]/button[1]/span");
	By month=By.xpath("//*[@id=\"calendar-searchboxdatepicker\"]/div/div[1]/div/div[1]/h3");
	By arrow=By.xpath("//*[@id=\"calendar-searchboxdatepicker\"]/div/div[1]/button/span/span");
	By date=By.xpath("//*[@id=\"calendar-searchboxdatepicker\"]/div/div[1]/div/div[1]/table/tbody/tr/td/span");
	
	By search=By.xpath("//*[@id=\"b2searchresultsPage\"]/div[4]/div/div/div/form/div[1]/div[4]/button/span");
	By availability=By.xpath("//*[@id=\"search_results_table\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/a/span[1]");
	By guestreviews=By.xpath("//*[@id=\"basiclayout\"]/div[1]/div[1]/div/div[3]/div[1]/div/nav/div/ul/li[5]/a/div/span");
	By close=By.xpath("//*[@id=\"hp-reviews-sliding\"]/div/div[1]/i");
	
	public Bookingpage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void Bookingstay() {
		
		driver.navigate().refresh();
		
		driver.findElement(stays).click();
		
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(place).sendKeys("Munnar",Keys.ENTER);	
		
	}
	public void date()
	{
		driver.navigate().refresh();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(calendar).click();
		while(true)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			WebElement Month=driver.findElement(month);
					String m=Month.getText();
					if(m.equals("November 2023"))
					{
						System.out.println(m);
						break;
					}
					else
					{
						driver.findElement(arrow).click();
					}
		}
		List<WebElement>day=driver.findElements(date);
		for(WebElement dat:day)
		{
			String  d=dat.getText();
			if(d.equals("28"))
			{
				dat.click();
				break;
			}
		}	
	}
	public void search()
	{
		driver.findElement(search).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String parentwindow=driver.getWindowHandle();
		driver.findElement(availability).click();
		
		Set<String>allwindowhandles=driver.getWindowHandles();
		
		for(String handle:allwindowhandles)
		{
			if(!handle.equals(parentwindow))
			{
				driver.switchTo().window(handle);
			driver.findElement(guestreviews).click();
			
			 driver.findElement(close).click();
			}
			
			driver.switchTo().window(parentwindow);
			
		}
	}
}
	
   
