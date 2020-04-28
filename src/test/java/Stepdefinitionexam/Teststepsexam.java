package Stepdefinitionexam;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Teststepsexam {

	public static WebDriver driver;
	int flag=0;
	
	@Given("^User is on Home page$")
	public void user_is_on_Home_page() throws Throwable {
	   
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp-p\\Desktop\\sel\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.get("http://demowebshop.tricentis.com/");
		
		driver.manage().window().maximize();
		assertEquals("Demo Web Shop",driver.getTitle());
		
	}

	@Given("^Click on Login link$")
	public void click_on_Login_link() throws Throwable {

		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
		assertEquals("Demo Web Shop. Login",driver.getTitle());
		
	}

	@When("^Enters email and password and clicks login$")
	public void enters_email_and_password_and_clicks_login(DataTable logincredentials) throws Throwable {

		List<Map<String, String>> list = logincredentials.asMaps(String.class, String.class);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).get("email"));
			driver.findElement(By.name("Email")).sendKeys(list.get(i).get("email"));
			System.out.println(list.get(i).get("password"));
			driver.findElement(By.name("Password")).sendKeys(list.get(i).get("password"));
			driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();
			flag = flag + driver.findElements(By.linkText(list.get(i).get("email"))).size();
			System.out.println(list.get(i).get("email") + " " + flag);
			driver.findElement(By.linkText("Log out")).click();
			driver.findElement(By.linkText("Log in")).click();
			
		}
	}

	@Then("^User logged in successfully$")
	public void user_logged_in_successfully() throws Throwable {
	    System.out.println("Login Sucessful");
	    assertEquals(2, flag);
	    
	}


}
