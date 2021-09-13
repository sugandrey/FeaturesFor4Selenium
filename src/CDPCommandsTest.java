import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v91.emulation.Emulation;

public class CDPCommandsTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		Map<String, Object> params = new HashMap<>();
		params.put("width", 600);
		params.put("height", 1000);
		params.put("deviceScaleFactor", 50);
		params.put("mobile", true);
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", params);
		driver.get("https://*");
		driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.linkText("Library")).click();
		//56 37

	}

}
