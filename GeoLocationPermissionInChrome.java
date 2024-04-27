package testngclass;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GeoLocationPopup {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--incognito");
		
		// INIT CHROME OPTIONS
	    Map<String, Object> prefs = new HashMap<String, Object>();
	    Map<String, Object> profile = new HashMap<String, Object>();
	    Map < String, Object > contentSettings = new HashMap < String, Object > ();

	    // SET CHROME OPTIONS
	    // 0 - Default ( No action ), 1 - Allow , 2 - Block
	    contentSettings.put("geolocation", 0);
	    profile.put("managed_default_content_settings", contentSettings);
	    prefs.put("profile", profile);
	    op.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();

		driver.get("https://www.coles.com.au/"); //Open webpage in incognito, you will get geolocation popup for permission and it is handled at line#22
		Thread.sleep(20000);
		driver.quit();
	}
}
