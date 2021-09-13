import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v91.fetch.Fetch;

public class NetworkMocking {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		devTools.addListener(Fetch.requestPaused(), request -> {
			if (request.getRequest().getUrl().contains("shetty")) {
				String mockUrl = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				System.out.println(mockUrl);
//				Map<String, Object> params = new HashMap<>();
//				params.put("requestId", request.getRequestId());
//				params.put("url", mockUrl);
//				params.put("method", request.getRequest().getMethod());
//				params.put("postData", request.getRequest().getPostData());
//				params.put("headers", request.getRequest().getHeaders());
//				driver.executeCdpCommand("Fetch.continueRequest", params);
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockUrl),
				Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty()));
			}
			else {
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()),
						Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty()));
			}
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink='/library']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
	}

}
