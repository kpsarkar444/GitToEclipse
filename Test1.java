package CrossBrowser;
import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {
	
WebDriver driver;
	
	String url="http://www.facebook.com";
	
	
	@Parameters({"browser"})
	
	@BeforeTest
	public void launchBrowser(String browserName){
		try{
			if(browserName.equalsIgnoreCase("firefox")){
				driver=new FirefoxDriver();
			}
			
			else if(browserName.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
				driver=new ChromeDriver();
			}
			else if(browserName.equalsIgnoreCase("ie")){
				System.setProperty("webdriver.ie.driver", "E:\\IEDriverServer.exe");
				driver=new InternetExplorerDriver();
				
			}
			
		}
		
		
		catch(Exception e){
			e.getMessage();
			
		}
		
	}
	
	
	@Test
	public void search_Test() throws Exception{
		driver.navigate().to(url);
		driver.manage().window().maximize();
		Thread.sleep(4000);
		WebElement e = driver.findElement(By.xpath("//select[@id='day']"));
		Select sel=new Select(e);
		List<WebElement> ls=sel.getOptions();
		for(int i=0; i<ls.size(); i++){
			String text=ls.get(i).getText();
			System.out.println(text);
			sel.selectByVisibleText("20");
			driver.manage().timeouts().implecitelyWait(20, TimeUnit.SECONDS);

			WebDriverWait wait =new WebDriverWait(20, driver);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='day']"));
					Thread.sleep(2000);
		}
		Thread.sleep(4000);
	
		
	}
	
	@Test
	public void login_Test(){
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void closeBrowser(){
		driver.quit();
		
	}
	
		

	

}


