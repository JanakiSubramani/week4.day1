package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {

	public static void main(String[] args) {
		// 1. Launch the URL https://www.chittorgarh.com/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// 2. Click on stock market
		driver.findElement(By.xpath("//a[text()='STOCK MARKET ']")).click();

		// 3. Click on NSE bulk Deals
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();

		//Get all the security names 
		System.out.println("Security names are");
		List<String> listText=new ArrayList<String>();
		List<WebElement> listSecurityNames = driver.findElements(By.xpath("(//table)[2]//tr//td[3]"));
		for (WebElement securityname : listSecurityNames) {
			listText.add(securityname.getText());
			System.out.println(securityname.getText());
		}
		int sizeListSN=listText.size();
		System.out.println(sizeListSN);
		//Ensure whether there are duplicate security names
		Set<String> snSet=new TreeSet<String>(listText);
		int sizSetSN=snSet.size();
		System.out.println(sizSetSN);
		int duplicateCount=sizeListSN-sizSetSN;
		if(sizSetSN!=sizeListSN)
			System.out.println("There are "+duplicateCount +" duplicate security name present");
	}
}