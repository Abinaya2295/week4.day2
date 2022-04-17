package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableAssignment4 {

	public static void main(String[] args) throws InterruptedException {
		//Launch http://www.leafground.com/pages/table.html
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Get the count of number of columns
		List<WebElement> columns = driver.findElements(By.xpath("//table//tr[2]/td"));
		System.out.println("Number of columns : "+columns.size());
		//Get the count of number of rows
		List<WebElement> rows = driver.findElements(By.xpath("//tr"));
		System.out.println("Number of Rows : "+rows.size());
		//Get the progress value of 'Learn to interact with Elements'
		int size = rows.size();
		for(int i=3; i<size; i++)
		{
			String text = driver.findElement(By.xpath("//table//tr["+i+"]/td[2]")).getText();
			System.out.println("Learn to interact with Elements : "+text);
		}
		//Check the vital task for the least completed progress.
		driver.findElement(By.xpath("//table//tr[6]/td/input")).click();
		Thread.sleep(3000);
		driver.close();
				
	}

}
