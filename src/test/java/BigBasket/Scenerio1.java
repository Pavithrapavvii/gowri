package BigBasket;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;
import jnr.ffi.Struct.int16_t;

public class Scenerio1 implements ITestListener{
	WebDriver driver;
	@Test
	public void scenerio1() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//img[@alt='banners']")).click();
		//driver.findElement(By.xpath("//h2[.='Best Sellers']/parent::div/descendant::a")).click();
		List<WebElement> banner1 = driver.findElements(By.xpath("//h2[.='Best Sellers']/parent::div/following-sibling::div/descendant::div[@class='owl-stage']/child::div/descendant::a[@class='ng-binding']"));
		int count1=banner1.size();
		System.out.println("first banner count is "+count1);
		for(int i=1;i<=9;i++)
		{
			WebElement next = driver.findElement(By.xpath("//h2[.='Best Sellers']/parent::div/following-sibling::div/descendant::div[@class='owl-nav']/child::div[@class='owl-next']"));
			next.click();
			Thread.sleep(500);
			for(int j=0;j<count1;j++) 
			{
				String title=banner1.get(j).getText();
					System.out.println((j+1)+" "+title);
			}
		} 
	
		
		
		System.out.println("---------2nd banner---------");
		//List<WebElement> banner2 = driver.findElements(By.xpath("//h2[.='Frequently Bought Items']/parent::div/following-sibling::div/descendant::div[@class='owl-stage']/child::div/descendant::a[@class='ng-binding']"));
		List<WebElement> banner2 = driver.findElements(By.xpath("//h2[.='Har Din Sasta Min 6%']/parent::div/following-sibling::div/descendant::div[@class='owl-stage']/child::div/descendant::a[@class='ng-binding']"));
		int count2=banner2.size();
		System.out.println("second banner count is "+count2);
		for(int i=1;i<=9;i++)
		{
			//WebElement next1 = driver.findElement(By.xpath("//h2[.='Frequently Bought Items']/parent::div/following-sibling::div/descendant::div[@class='owl-nav']/child::div[@class='owl-next']"));
			
			WebElement next1 = driver.findElement(By.xpath("//h2[.='Har Din Sasta Min 6%']/parent::div/following-sibling::div/descendant::div[@class='owl-nav']/child::div[@class='owl-next']"));
			next1.click();
			Thread.sleep(2000);
			for(int j=0;j<count2;j++)
			{
				String title1=banner2.get(j).getText();
				System.out.println(title1);
			}
		}
		System.out.println("--------------printing all items-------------");
		Thread.sleep(2000);
		int y = driver.findElement(By.xpath("//h2[.='Best Sellers']")).getLocation().getY();
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("window.scrollTo(0,"+y+")");
		Thread.sleep(1000);
		List<WebElement> allItems = driver.findElements(By.xpath("//div[@class='carousel-wrap owl-pd-wrap']/descendant::div[@class='owl-stage']/child::div/descendant::a[@class='ng-binding']"));
		int count3=allItems.size();
		System.out.println("total count of the items present in the page is "+count3);
		for(int i=1;i<=7;i++)
		{
//			WebElement next = driver.findElement(By.xpath("//div[@class='owl-next']"));
//			next.click();
			WebElement next1 = driver.findElement(By.xpath("//h2[.='Frequently Bought Items']/parent::div/following-sibling::div/descendant::div[@class='owl-nav']/child::div[@class='owl-next']"));
			next1.click();
			Thread.sleep(2000);
			for(int k=0;k<count3;k++)
			{
				String title1=allItems.get(k).getText();
				System.out.println(title1);
				//allItems.get(1).click();
			}
		}
//		for(int i=0;i<count3;i++)
//		{
//			String title1=allItems.get(i).getText();
//	     	System.out.println(title1);
//	     	if((i+1)%5==0)
//	     	{
//	     		WebElement next = driver.findElement(By.xpath("//div[@class='owl-next']"));
//				next.click();
//	     	}
//		}
		//allItems.get(1).click();
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
		File src = takescreenshot.getScreenshotAs(OutputType.FILE);
		File dst=new File("./screenshot/pavi.png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			
		}
	}
}
