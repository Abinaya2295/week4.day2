package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropAssignment1 {

	public static void main(String[] args) {
		//open the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drop.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//get the webelement
		WebElement findElement1 = driver.findElement(By.id("draggable"));
		WebElement findElement2 = driver.findElement(By.id("droppable"));
		//get Action class
		Actions builder = new Actions(driver);
		builder.dragAndDrop(findElement1, findElement2).perform();	
	}

}
