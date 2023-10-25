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

public class Scenerio5 {
	@Test
	public void scenerio5() throws InterruptedException
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
		driver.findElement(By.xpath("//span[.='My Account']")).click();
		driver.findElement(By.xpath("//a[.='Customer Service']")).click();
		driver.findElement(By.id("id_q")).sendKeys("tomato",Keys.ENTER);
		driver.findElement(By.xpath("//div[@class='grid grid-cols-6 gap-x-6 gap-y-5']/child::button[.='Show more +']")).click();
//		List<WebElement> title = driver.findElements(By.xpath("//div[@class='grid grid-cols-6 gap-x-6 gap-y-5']/child::button"));
//		for(int i=0;i<title.size();i++)
//		{
//			String text=title.get(i).getText();
//			System.out.println(text);
//		}
		
		List<WebElement> title1 = driver.findElements(By.xpath("//h3[@class='block m-0 line-clamp-2 font-regular text-base leading-sm text-darkOnyx-800 pt-0.5 h-full']"));
		for(int i=0;i<title1.size();i++)
		{
			String text=title1.get(i).getText();
			System.out.println(text);
		}
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
		File src = takescreenshot.getScreenshotAs(OutputType.FILE);
		File dst=new File("./screenshot/pavi5.png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			
		}
		driver.close();
	}

}
