package Control_Parent_To_Child;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart_Auto_Suggestion {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		WebElement a1=driver.findElement(By.name("q"));
		a1.sendKeys("shoes");
		a1.sendKeys(Keys.ENTER);
		List<WebElement> shoes=driver.findElements(By.xpath("//div//ul/li"));
		shoes.get(4).click();
		
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> it=s1.iterator();
		String parentid=it.next();
		String childid=it.next();
		
		driver.switchTo().window(childid);
		Thread.sleep(2000);
		driver.close();
		
		
	}

}
