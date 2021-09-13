import java.util.Optional;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v91.network.Network;
import org.openqa.selenium.devtools.v91.network.model.Request;
import org.openqa.selenium.devtools.v91.network.model.Response;



public class NetworkLogActivity {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.addListener(Network.requestWillBeSent(), request -> {
			Request req = request.getRequest();
//			System.out.println(req.getUrl());
//			System.out.println(req.getHeaders().toString());
		});
		devTools.addListener(Network.responseReceived(), response -> {
			Response res = response.getResponse();
			if(res.getStatus().toString().startsWith("4")) {
				System.out.println(res.getStatus() + " is failed with status code " + res.getStatus());
			}
			//System.out.println(res.getUrl());
			//System.out.println(res.getStatus());
			
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink='/library']")).click();
	}

}
