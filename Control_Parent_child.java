package Control_Parent_To_Child;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Control_Parent_child {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		WebElement e1 = driver.findElement(By.id("twotabsearchtextbox"));
		e1.sendKeys("shoes");

		e1.sendKeys(Keys.ENTER);
		WebElement shoe_45 = driver
				.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-tall-aspect'])[45]"));
		shoe_45.click();
		System.out.println(driver.getWindowHandles());
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> ids = s1.iterator();

		String parent_id = ids.next();
		String child_id = ids.next();
        //Here we switch control of parent class to child class and we know close() method close the parent window, here the 
		// control of parent window goes to the child and now child became parent and it will close.
		
		driver.switchTo().window(child_id);
		driver.close();

	}

}
