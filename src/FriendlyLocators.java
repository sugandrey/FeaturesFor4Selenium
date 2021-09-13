import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class FriendlyLocators {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement editBox = driver.findElement(By.cssSelector("[name='name']"));
		// need to import manually withTagName() method
		System.out.println(driver.findElement(RelativeLocator.with(By.tagName("label")).above(editBox)).getText());
		WebElement label = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		System.out.println(label.getText());
		
		WebElement date = driver.findElement(RelativeLocator.with(By.className("form-control")).below(label));
		date.sendKeys("08/08/2021");
		File file = date.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("screenShot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		WebElement leftElement = driver.findElement(By.id("exampleCheck1"));
		System.out.println(driver.findElement(RelativeLocator.with(By.tagName("label")).toRightOf(leftElement)).getText()); 
		WebElement rightElement = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(RelativeLocator.with(By.tagName("label")).toLeftOf(rightElement)).getText());
		
	}

}
