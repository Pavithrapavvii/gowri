package BigBasket;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.python.antlr.PythonParser.for_stmt_return;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenerio7 {
	@Test
	public void scenerio7() throws InterruptedException
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
		driver.findElement(By.xpath("//span[.='My Basket']"));
		
		
	}
	@Test
	public void java()
	{
		String a="Price: ₹265.5";
		String b = a.replace("Price: ₹", "");
		System.out.println(b);
		String p="₹200";
		String bb = p.replace("₹", "");
		System.out.println(bb);
	}

}
