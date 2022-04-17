package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortableAssignment1 {

	public static void main(String[] args) {
		//open the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//switch to frame
		driver.switchTo().frame(0);
		//get webelement
		WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		WebElement item6 = driver.findElement(By.xpath("//li[text()='Item 6']"));
		WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		//Create an object for the class
		Actions builder = new Actions(driver);
		builder.dragAndDrop(item5, item2).perform();
		builder.dragAndDrop(item6, item3).perform();
	}

}
