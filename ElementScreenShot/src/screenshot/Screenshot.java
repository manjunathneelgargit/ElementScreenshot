package screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot 
{

	public static void main(String[] args) throws Exception 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php");
		
		//Identify webElement
		WebElement username = driver.findElement(By.name("user_name"));
		
		/*Method 1*/
		
		//take screenshot of element by webelement.getScreenshotAs() method
		File src = username.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("./Screenshot/username.png");
		
		FileUtils.copyFile(src, dest);
		
		
		/*Method 2*/
		//by type casting element to TakesScreenShot interface
		TakesScreenshot ts = (TakesScreenshot)username;
		
		File src2 = ts.getScreenshotAs(OutputType.FILE);		
		File dest2 = new File("./Screenshot/username.png");
		
		FileUtils.copyFile(src2, dest2);
	}
	

}
