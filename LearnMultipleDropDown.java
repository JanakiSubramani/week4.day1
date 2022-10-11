package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnMultipleDropDown {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// open the url
		driver.get("https://www.leafground.com/select.xhtml");
		// to maximize
		driver.manage().window().maximize();
		
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement findElement = driver.findElement(By.xpath("//Select[@Class='ui-selectonemenu']"));
		Select s = new Select(findElement);
		List<WebElement> options = s.getOptions();
		for(int i=0;i<=options.size();i++)
		{
			if(i==2||i==3)
			{
				options.get(i).click();
			}
		}
		WebElement findElement2 = driver.findElement(By.xpath("//Select[@Class='ui-selectonemenu']"));
		System.out.println(findElement2.getText());

	}

}
