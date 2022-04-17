package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAssignment1 {

	public static void main(String[] args) {
		//open the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drag.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Perform Dragging
		WebElement findElement = driver.findElement(By.id("draggable"));
		//get the location
		int x = findElement.getLocation().getX();
		System.out.println(x);
		int y = findElement.getLocation().getY();
		System.out.println(y);
		//perform drag
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(findElement, 120, 120).perform();		
		
	}

}
