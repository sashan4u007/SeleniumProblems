package testngclass;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MicAndCameraDesktopPermission {
	public static void main(String[] args) throws InterruptedException {
		  ChromeOptions op = new ChromeOptions();
		  op.addArguments("--incognito");
		
	    Map<String, Object> prefs = new HashMap<String, Object>();
	    Map<String, Object> profile = new HashMap<String, Object>();
	    Map < String, Object > contentSettings = new HashMap < String, Object > ();

	    // SET CHROME OPTIONS
	    // 0 - Default ( No action ), 1 - Allow , 2 - Block
	    contentSettings.put("media_stream", 1);  // This media_stream is used for mic and camera
	    profile.put("managed_default_content_settings", contentSettings);
	    prefs.put("profile", profile);
	    op.setExperimentalOption("prefs", prefs);
	    
	    WebDriver driver = new ChromeDriver(op);
	    driver.manage().window().maximize();
    
	    driver.get("https://www.vidyard.com/mic-test/"); // Open webpage in incognito mode
  		driver.findElement(By.xpath("//button[text()='Start mic Test']")).click(); // click on 'Start mic Test' button and then we get popup but it is handle at line#22
	  	Thread.sleep(20000);
		
		  driver.get("https://www.vidyard.com/cam-test/"); // Open webpage in incognito mode
		  driver.findElement(By.xpath("//button[text()='Start cam Test']")).click(); // click on 'Start cam Test' button and then we get popup but it is handle at line#22
		  Thread.sleep(20000);
		
		  driver.quit();
	}
}
