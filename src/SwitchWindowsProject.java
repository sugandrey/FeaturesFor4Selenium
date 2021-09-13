import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindowsProject {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> iterator = tabs.iterator();
			String parentWindowID = iterator.next();
			String childWindowID = iterator.next();
			driver.switchTo().window(childWindowID);
			driver.get("https://rahulshettyacademy.com");
			String courseName = driver.findElement(By.xpath("//a[text()='All-Access Membership-Complete Access to 25+ Courses (and counting!)']")).getText();
			driver.switchTo().window(parentWindowID);
			WebElement editBox = driver.findElement(By.cssSelector("[name='name']"));
			editBox.sendKeys(courseName);
			System.out.println(editBox.getRect().getDimension().getHeight());
			
			
	}

}
