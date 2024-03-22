package HotelSearchTest;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

public class BookingHotelTestCases extends Parameters {

	@BeforeTest
	public void mysetup() {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		WebElement popMSG = driver.findElement(By.cssSelector(".sc-iBmynh.izXFRL"));
		if (popMSG.isDisplayed());
		{

			WebElement SarBUTTON = driver
					.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
			SarBUTTON.click();
		}
	}

	@Test(priority = 1)
	public void RandomlySelectHotelInRandomCity() {
		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		HotelTab.click();
		WebElement SearchCityInput = driver.findElement(By.xpath("//input[@data-testid=\"AutoCompleteInput\"]"));
		if (driver.getCurrentUrl().contains("en")) {
			SearchCityInput.sendKeys(EnglichCities[RandomEnglichCity] + Keys.ARROW_DOWN + Keys.ARROW_DOWN + Keys.ENTER);
			WebElement ResultList = driver.findElement(By.xpath("//ul[@data-testid='AutoCompleteResultsList']"));
			ResultList.findElements(By.tagName("li")).get(1).click();
		} else {
			SearchCityInput.sendKeys(ArabicCities[RandomArabicCity]);
			WebElement ResultList = driver.findElement(By.xpath("//ul[@data-testid='AutoCompleteResultsList']"));
			ResultList.findElements(By.tagName("li")).get(1).click();
		}
	}
	@Test(priority = 2)
	public void RandomlySelectNumberOfVisitor() {
		WebElement SelectVisitorNumber = driver.findElement(By.xpath("//select[@data-testid='HotelSearchBox__ReservationSelect_Select']"));
		Select selector = new Select(SelectVisitorNumber);
		selector.selectByIndex(visitorNumber);
		WebElement searchhotelbutton = driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']"));
		searchhotelbutton.click();
	}
	@Test(priority = 3)
	public void PageFullyComplete() throws InterruptedException {
		Thread.sleep(20000);
		WebElement resultsfound = driver.findElement(By.xpath("//span[@data-testid='HotelSearchResult__resultsFoundCount']"));
		String resultsfoundText = resultsfound.getText();
		myassert.assertEquals(resultsfoundText.contains("found"), true);
	}
	@Test(priority = 4)
	public void sortpricesfromloetohigh() throws InterruptedException {
		WebElement LowesPriceButton = driver.findElement(By.xpath("//button[@data-testid='HotelSearchResult__sort__LOWEST_PRICE']"));
		LowesPriceButton.click();
		Thread.sleep(3000);
		WebElement ContainerOfThePrices = driver.findElement(By.cssSelector(".sc-htpNat.KtFsv.col-9"));
		
		List<WebElement> Prices = ContainerOfThePrices.findElements(By.className("Price__Value"));
		int firstPrices = Integer.parseInt(Prices.get(0).getText()) ;Prices.get(0).getText();
		int lastPrices = Integer.parseInt(Prices.get(Prices.size()-1).getText());
		
		System.out.println(firstPrices);
		System.out.println(lastPrices);
		myassert.assertEquals(firstPrices<lastPrices, true);
		
		
	}
		
}