package BigBasket;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import jnr.ffi.Struct.int16_t;

public class Scenerio3 {
	WebDriver driver;
	ITestResult result;
	@Test
	public void scenerio6() throws InterruptedException
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
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[.='My Account']")).click();
		driver.findElement(By.xpath("//a[.='Customer Service']")).click();
		//h6[.='Regarding Orders']/parent::div/child::div/descendant::h6 
		List<WebElement> links = driver.findElements(By.xpath("//div[@class='uiv2-form uiv2-push-left uiv2-width-100 customer-self-service ng-scope']/descendant::h6[@class='ng-binding']"));
		int count=links.size();
		for(int i=0;i<count;i++)
		{
			String text=links.get(i).getText();
			System.out.println(text);
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='uiv2-left-nav-block']/child::ul/li/a[.='My Orders']")).click();
		 
		//String methodName = result.getMethod().getMethodName();
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
		File src = takescreenshot.getScreenshotAs(OutputType.FILE);
		File dst=new File("./screenshot/pavi3.png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			
		}
		int expData=10;
		SoftAssert a=new SoftAssert();
		a.assertTrue(count>expData, "count of the titles is more than 10");
		a.assertTrue(count<expData, "count of the titles is less than 10");
		a.assertAll();
		
	} 
	

}
