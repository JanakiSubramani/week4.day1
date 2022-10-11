package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTML{
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> data = driver.findElements(By.xpath("//div[@class='render']//tr"));
		int rows = data.size();
		System.out.println("no of the rows in table"+rows);
		for (WebElement each : data) {
			String text = each.getText();
			System.out.println(text);
		}
		List<WebElement> data2 = driver.findElements(By.xpath("//div[@class='render']//th"));
		int columns = data2.size();
		System.out.println("no of the columns in table"+columns);
		for (WebElement each : data2) {
			String text = each.getText();
			System.out.println(text);
		}
		
}
}