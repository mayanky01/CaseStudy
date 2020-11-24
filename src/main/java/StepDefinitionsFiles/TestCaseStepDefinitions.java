package StepDefinitionsFiles;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TestCaseStepDefinitions {
	WebDriver driver;

	@Given("User is navigated to home page")
	public void User_is_navigated_to_homepage() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resource\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:3000/");
	}

	@When("Enter \"(.*)\" as City to Search for Weather forecast")
	public void enterCityName(String cityName) {
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys(cityName);

	}

	@Then("Verify five days forecast is displayed")
	public void verifyFiveDaysForecastDisplayed() {
		List<WebElement> days = driver.findElements(By.xpath("//div[@id='root']/div/div"));
		Assert.assertEquals("Five Days Forcast not Displayed", 5, days.size());
		driver.close();
	}

	@When("User click on any Day")
	public void clickOnanyDay() {
		WebElement Day = driver.findElement(By.xpath("(//div[@id='root']/div/div)[2]/div/span[1]"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Day));
		Day.click();
	}

	@Then("Verify hour forecast is displayed")
	public void verifyHourForecastDisplayed() {
		boolean flag = false;
		List<WebElement> hours = driver.findElements(
				By.xpath("(//div[@id='root']/div/div)[2]/div[2]//child::span[contains(@data-test,'hour')]"));
		for (WebElement hour : hours) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(hour));

			flag = hour.isDisplayed();
		}
		Assert.assertTrue("Hour Forecast is not displayed", flag);
		driver.close();
	}

	@And("User click on the same Day")
	public void clickAgainOnTheSameDay() {
		WebElement Day = driver.findElement(By.xpath("(//div[@id='root']/div/div)[2]/div/span[1]"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Day));
		Day.click();
	}

	@Then("Verify hour forecast is Hide")
	public void verifyHourForecastHide() {
		boolean flag = true;
		List<WebElement> hours = driver.findElements(
				By.xpath("(//div[@id='root']/div/div)[2]/div[2]//child::span[contains(@data-test,'hour')]"));
		for (WebElement hour : hours) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.invisibilityOf(hour));
			flag = hour.isDisplayed();
		}
		Assert.assertFalse("Hour Forecast is displayed", flag);
		driver.quit();
	}

}
