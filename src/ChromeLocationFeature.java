import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;


public class ChromeLocationFeature {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		Map<String,Object> params = new HashMap<>();
		params.put("latitude", 3);
		params.put("longitude", 40);
		params.put("accuracy", 1);
		driver.executeCdpCommand("Emulation.setGeolocationOverride", params);
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		String title = driver.findElement(By.cssSelector(".our-story-card-title")).getText();
		
//		String title = driver.findElements(By.xpath("//div/h1")).get(0).getText();
	    System.out.println(title);
		
			
		

	}

}
