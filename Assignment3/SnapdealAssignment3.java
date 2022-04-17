package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapdealAssignment3 {

	public static void main(String[] args) throws InterruptedException, IOException {
		//Launch https://www.snapdeal.com/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));		
		//Go to Mens Fashion
		WebElement findElement = driver.findElement(By.xpath("//span[contains(text(),'Fashion')][@class='catText']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(findElement).perform();		
		//Go to Sports Shoes
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();		
		//Get the count of the sports shoes
		String getItems = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText().substring(1, 11);
		System.out.println("ount of sports shoes : "+getItems);	
		//Click Training shoes
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();		
		//Sort by Low to High
		Thread.sleep(3000);
		driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();
		//Check if the items displayed are sorted correctly
		String getSortedValue = driver.findElement(By.xpath("//div[@class='sort-selected']")).getText();
		System.out.println(getSortedValue);
		if(getSortedValue.contains("Low To High"))
		{
			System.out.println("Items displayed are sorted correctly");
		}
		else
		{
			System.out.println("Items displayed are not sorted correctly");
		}
		//Select the price range (500-1200)
		driver.findElement(By.xpath("//input[@class='input-filter'][@name='fromVal']")).clear();
		driver.findElement(By.xpath("//input[@class='input-filter'][@name='fromVal']")).sendKeys("500");
		driver.findElement(By.xpath("//input[@class='input-filter'][@name='toVal']")).clear();
		driver.findElement(By.xpath("//input[@class='input-filter'][@name='toVal']")).sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();		
		//Filter with color Navy 
		Thread.sleep(4000);
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']/span")).click();		
		//verify the all applied filters 
		String price = driver.findElement(By.xpath("//div[@class='filters-top-selected']//div[@class='navFiltersPill']/a")).getText();
		System.out.println(price);
		String color = driver.findElement(By.xpath("(//div[@class='filters-top-selected']//div[@class='navFiltersPill']/a)[2]")).getText();
		System.out.println(color);
		if(price.contains("Rs. 500 - Rs. 1200") && (color.contains("Navy")))
		{
			System.out.println("Filters are applied correctly");
		}
		else
		{
			System.out.println("Filters are not applied correctly");
		}		
		//Mouse Hover on first resulting Training shoes
		WebElement findElement2 = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(findElement2).perform();		
		//click QuickView button
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();		
		//Print the cost and the discount percentage
		String cost = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println("Cost : "+cost);
		String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("Discount : "+discount);
		//Take the snapshot of the shoes.
		File source = driver.getScreenshotAs(OutputType.FILE);
		//creating the physical file
		File destination = new File("./snaps/shoes.png");
		// - ./ refers to project folder
		//copy source to destination
		FileUtils.copyFile(source, destination);
		Thread.sleep(2000);
		//Close the current window
		driver.findElement(By.xpath("//div/i[@class='sd-icon sd-icon-delete-sign']")).click();		
		//Close the main window
		driver.close();
	}

}
