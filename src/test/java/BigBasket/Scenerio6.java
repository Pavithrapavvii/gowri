package BigBasket;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.types.resources.Difference;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import jnr.ffi.Struct.int16_t;
import jnr.ffi.Struct.off_t;

public class Scenerio6 {
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
		
		driver.findElement(By.xpath("//div[@class='grid grid-flow-col place-content-start gap-x-6 lg:py-1 xl:pb-2 xl:pt-3']//*[name()='svg' and @class='CategoryMenu___StyledArrowDown-sc-d3svbp-3 iwTeGC']")).click();
		 WebElement bevarage = driver.findElement(By.xpath("//div[@class='CategoryMenu___StyledMenuItems-sc-d3svbp-4 cAslOa']/descendant::a[.='Beverages']"));
		Actions a=new Actions(driver);
		Thread.sleep(500);
		a.moveToElement(bevarage).perform();
		Thread.sleep(500);
		 List<WebElement> items = driver.findElements(By.xpath("//div[@class='CategoryMenu___StyledMenuItems-sc-d3svbp-4 cAslOa']/descendant::a[.='Beverages']/ancestor::ul/following-sibling::ul/li"));
		 int count=items.size();
		 System.out.println("the count of the items is "+count);
		 for(int i=0;i<items.size();i++)
		 {
			 String bitems = items.get(i).getText();
			 System.out.println(bitems);
		 } 
//		WebElement coffee = driver.findElement(By.xpath("//div[@class='CategoryMenu___StyledMenuItems-sc-d3svbp-4 cAslOa']//ul[position()>1]/li/a[contains(text(),'Coffee')]"));
//		 if(items.equals(coffee)) {
//			 items.get(count).click();
//		 }
		 items.get(0).click();
		 Thread.sleep(500);
		 driver.findElement(By.xpath("//li[@class='FilterByCategory___StyledLi-sc-c0pkxv-3 LRJmo']/child::a[.='Ground Coffee']")).click();
		 driver.findElement(By.xpath("//button[@class='Button-sc-1dr2sn8-0 FilterToggler___StyledButton-sc-1mipihj-0 ijLqoc fWJrvH']")).click();
		 driver.findElement(By.xpath("//ul[@class='mt-5 grid gap-6 grid-cols-12']/li[1]")).click();
		 Thread.sleep(5000);
		 String currentwindow = driver.getWindowHandle();
		 Set<String> windows = driver.getWindowHandles();
		 for(String wh:windows)
		 {
			// String title = driver.getTitle();
			 if(!currentwindow.equals(windows))
			 {
				 driver.switchTo().window(wh);
			 }
		 }
		 //driver.findElement(By.xpath("//section[@class='grid grid-cols-2 gap-6 pb-10 border-b border-dashed border-silverSurfer-400']/descendant::button[@class='Button-sc-1dr2sn8-0 PdCartCTA___StyledButton-sc-mq73zq-1 kYQsWi TvAgf group false group false']//section[@class='grid grid-cols-2 gap-6 pb-10 border-b border-dashed border-silverSurfer-400']/descendant::div[@class='pr-6.5']")).click();
//		 String mrp = driver.findElement(By.xpath("//table/tr[@class='flex items-center mb-1 text-md text-darkOnyx-100 leading-md p-0']/child::td[@class='line-through p-0']")).getText();
//		 System.out.println("mrp of the product is  "+mrp);
		 String price = driver.findElement(By.xpath("//tr[@class='flex items-center justify-start mb-1 text-base font-bold text-darkOnyx-800']/td[@class='Description___StyledTd-sc-82a36a-4 fLZywG']")).getText();
		 System.out.println("price of the product is "+price);
		 price.split(price);
		 String aprice = price.replace("Price: ₹", "");
		 System.out.println(aprice);
//		 String aMrp = mrp.replace("₹", "");
//		 System.out.println(aMrp);
		 
//		 Double conMRP = Double.parseDouble(aMrp);
//		 Double conPrice =Double.parseDouble(aprice);
//		 Double difference = conMRP-conPrice;
//		 System.out.println(difference);
//		Assert.assertEquals(conMRP, conPrice);
//		 System.out.println("equal");
		 
	}
	
	//div[@class='relative place-content-end grid grid-flow-col gap-x-6']/descendant::span[.='Select Location']
	//section[@class='grid grid-cols-2 gap-6 pb-10 border-b border-dashed border-silverSurfer-400']/descendant::button[@class='Button-sc-1dr2sn8-0 PdCartCTA___StyledButton-sc-mq73zq-1 kYQsWi TvAgf group false group false']
	
	
	
	
	////div[@class='CategoryMenu___StyledMenuItems-sc-d3svbp-4 cAslOa']/descendant::a[.='Beverages']/ancestor::ul/following-sibling::ul/li

}
