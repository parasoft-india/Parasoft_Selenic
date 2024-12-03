/**
 * 
 */
package com.parasoft;

import com.parasoft.page.ParaBankAccountsOverviewPage;
import com.parasoft.page.ParaBankLoanRequestPage;
import com.parasoft.page.ParaBankWelcomeOnlineBankingPage;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RequestLoan {

	/**
	 * Parasoft auto generated base URL
	 * Use -DPARABANK_BASE_URL=http://localhost:8080 from command line
	 * or use System.setProperty("PARABANK_BASE_URL", "http://localhost:8080") to change base URL at run time.
	 */
	private static final String PARABANK_BASE_URL = "http://localhost:8084";

	private WebDriver driver;

	@BeforeEach
	public void beforeTest() {
		ChromeOptions opts = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.managed_default_content_settings.geolocation", 2);
		prefs.put("profile.default_content_setting_values.notifications", 2);
		opts.setExperimentalOption("prefs", prefs);
		opts.addArguments("--start-maximized");
		opts.addArguments("--incognito");
		opts.addArguments("--enable-strict-powerful-feature-restrictions");
		driver = new ChromeDriver(opts);
		driver.manage().window().maximize();
	}

	@AfterEach
	public void afterTest() {
		if (driver != null) {
			driver.quit();
		}
	}

	/**
	 * Name: RequestLoan
	 * Recording file: RequestLoan.json
	 *
	 * Parasoft recorded Selenium test on Thu Sep 19 2024 09:59:10 GMT+0530 (India Standard Time)
	 */
	@Test
	public void testRequestLoan() throws Throwable {
		driver.get(System.getProperty("PARABANK_BASE_URL", PARABANK_BASE_URL) + "/parabank/index.htm");

		ParaBankWelcomeOnlineBankingPage paraBankWelcomeOnlineBankingPage = new ParaBankWelcomeOnlineBankingPage(
				driver);
		paraBankWelcomeOnlineBankingPage.setUsernameText("john");
		paraBankWelcomeOnlineBankingPage.setPassword("demo");
		paraBankWelcomeOnlineBankingPage.clickLogInSubmit();

		ParaBankAccountsOverviewPage paraBankAccountsOverviewPage = new ParaBankAccountsOverviewPage(driver);
		paraBankAccountsOverviewPage.clickRequestLoanLink();

		ParaBankLoanRequestPage paraBankLoanRequestPage = new ParaBankLoanRequestPage(driver);
		paraBankLoanRequestPage.setAmountText("1000");
		paraBankLoanRequestPage.setDownPaymentText("100");
		paraBankLoanRequestPage.clickApplyNowSubmit();
		paraBankLoanRequestPage.clickLogOutLink();
	}

}
