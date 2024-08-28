package Control_Parent_To_Child;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Naukri_Regiteration_control_Parent_child {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();

		driver.findElement(By.id("register_Layer")).click();
		WebElement google = driver.findElement(By.name("google-register"));
		google.click();

		Set<String> w1 = driver.getWindowHandles();
		System.out.println(w1);

		Iterator<String> it = w1.iterator();
		String Parent_id = it.next();
		String Child_id = it.next();
		driver.switchTo().window(Child_id);
		Thread.sleep(2000);
		driver.close();

	}

}
