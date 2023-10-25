package BigBasket;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import jnr.ffi.Struct.int16_t;

public class Scenerio4 {
	@Test
	public void scenerio4() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[.='Login/ Sign Up']")).click();
		driver.findElement(By.id("multiform")).sendKeys("paviprajju94@gmail.com");
		driver.findElement(By.xpath("//button[.='Continue']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[.='Verify & Continue']")).click();
		
		driver.findElement(By.xpath("//button[@class='MemberDropdown___StyledMenuButton-sc-ce95dd-1 ezacJo']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[.='My Account']")).click();
		driver.findElement(By.xpath("//a[.='Customer Service']")).click();
		driver.findElement(By.id("id_q")).sendKeys("icecreams");
		List<WebElement> autosugg = driver.findElements(By.xpath("//div[@class='uiv2-product-rightlist-column']/descendant::li/a"));
		int count=autosugg.size();
		for(int i=0;i<count;i++)
		{
			String text=autosugg.get(i).getText();
			System.out.println(text);
			Thread.sleep(2000);
			
		}
		autosugg.get(1).click();
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
		File src = takescreenshot.getScreenshotAs(OutputType.FILE);
		File dst=new File("./screenshot/pavi4.png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			
		}
		
		
//		System.out.println();
//		List<WebElement> autosuggestions = driver.findElements(By.xpath("//div[@class='uiv2-search-product-list']/ul/li/a[@class='uiv2-img-product-name']"));
//		int count1=autosuggestions.size();
//		for(int i=0;i<count1;i++)
//		{
//			String item=autosuggestions.get(i).getText();
//			System.out.println(item);
//		}
		
		//div[@class='uiv2-search-product-list']/ul/li/a[@class='uiv2-img-product-name']
	}

}
