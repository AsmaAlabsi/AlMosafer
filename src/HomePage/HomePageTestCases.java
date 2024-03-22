package HomePage;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTestCases extends Parameters {

	private static final String priority = null;
	@BeforeTest
	public void mySetup() {
		driver.manage().window().maximize();
		driver.get(URL);
		WebElement popMSG = driver.findElement(By.cssSelector(".sc-iBmynh.izXFRL"));
		if (popMSG.isDisplayed())
			;
		{

			WebElement SarBUTTON = driver
					.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
			SarBUTTON.click();

		}
	}

	@Test()
	public void CheckTheDefaultLanguageIsEnglish() {
		String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
		myAssert.assertEquals(ActualLanguage, ExpectedEnglishLanguage);

	}

	@Test()
	public void CheckTheDefaultCurrency() {
		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid=\"Header__CurrencySelector\"]"))
				.getText();
		myAssert.assertEquals(ActualCurrency, ExpectedCurrency, "wllah this is currency check");

	}

	@Test()
	public void CheckTheContactNumber() {
		String ActualNumber = driver.findElement(By.tagName("strong")).getText();
		myAssert.assertEquals(ActualNumber, ExpectedNumber, "This is contact Number");

	}

	@Test()
	public void CheckQitafLogo() {
		WebElement QitafLogo = driver.findElement(By.xpath("//div[@class='sc-fihHvN eYrDjb']//*[name()='svg']"));
		boolean ActualResult = QitafLogo.isDisplayed();
		myAssert.assertEquals(ActualResult, true);

	}

	@Test()
	public void CheckHotelTabIsNotSelected() {
		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ActualResult = HotelTab.getAttribute("aria-selected");
		myAssert.assertEquals(ActualResult, "false");
	}

	@Test()
	public void CheckDepatureAndReturnDate() {
		LocalDate today = LocalDate.now();
		int tomorrow = today.plusDays(1).getDayOfMonth();
		int TheDayAfterTomorrow = today.plusDays(2).getDayOfMonth();

		String ActualDepatureDateOnTheWebSite = driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE blwiEW'] span[class='sc-cPuPxo LiroG']"))
				.getText();
		int ActualDepatureDateOnTheWebSiteNumber = Integer.parseInt(ActualDepatureDateOnTheWebSite);
		String ActualReturnDateOnTheWebSite = driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-OxbzP edzUwL'] span[class='sc-cPuPxo LiroG']"))
				.getText();
		int ActualReturnDateOnTheWebSiteNumber = Integer.parseInt(ActualReturnDateOnTheWebSite);

		myAssert.assertEquals(ActualDepatureDateOnTheWebSiteNumber, tomorrow);
		myAssert.assertEquals(ActualReturnDateOnTheWebSiteNumber, TheDayAfterTomorrow);

	}
	@Test()
	public void ChangeLanguageRandomly() {
		driver.get(websites[randomwebsite]);
		if (driver.getCurrentUrl().contains("en")) {
			
		String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
		myAssert.assertEquals(ActualLanguage, ExpectedEnglishLanguage);
		
		}else {
			String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			myAssert.assertEquals(ActualLanguage, ExpectedArabicLanguage);

		}

		}
		
	}
	
	

