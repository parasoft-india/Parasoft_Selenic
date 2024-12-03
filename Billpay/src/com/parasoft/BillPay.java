/**
 * 
 */
package com.parasoft;

import com.parasoft.page.ParaBankAccountsOverviewPage;
import com.parasoft.page.ParaBankBillPayPage;
import com.parasoft.page.ParaBankBillPaymentCompletePage;
import com.parasoft.page.ParaBankServicesPage;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BillPay {

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
	 * Name: Billpay
	 * Recording file: Billpay.json
	 *
	 * Parasoft recorded Selenium test on Tue Dec 03 2024 10:09:37 GMT+0530 (India Standard Time)
	 */
	@Test
	public void testBillpay() throws Throwable {
		driver.get(System.getProperty("PARABANK_BASE_URL", PARABANK_BASE_URL) + "/parabank/services.htm");

		ParaBankServicesPage paraBankServicesPage = new ParaBankServicesPage(driver);
		paraBankServicesPage.setUsernameText("john");
		paraBankServicesPage.setPassword("demo");
		paraBankServicesPage.clickLogInSubmit();

		ParaBankAccountsOverviewPage paraBankAccountsOverviewPage = new ParaBankAccountsOverviewPage(driver);
		paraBankAccountsOverviewPage.clickBillPayLink();

		ParaBankBillPayPage paraBankBillPayPage = new ParaBankBillPayPage(driver);
		paraBankBillPayPage.setPayeeNameText("john");
		paraBankBillPayPage.setPayeeAddressStreetText("abc");
		paraBankBillPayPage.setPayeeAddressCityText("def");
		paraBankBillPayPage.setPayeeAddressStateText("hij");
		paraBankBillPayPage.setPayeeAddressZipCodeText("12345");
		paraBankBillPayPage.setPayeePhoneNumberText("98653210");
		paraBankBillPayPage.setPayeeAccountNumberText("12346");
		paraBankBillPayPage.setVerifyAccountText("12346");
		paraBankBillPayPage.setAmountText("10");
		paraBankBillPayPage.clickSendPaymentSubmit();

		ParaBankBillPaymentCompletePage paraBankBillPaymentCompletePage = new ParaBankBillPaymentCompletePage(driver);
		paraBankBillPaymentCompletePage.clickLogOutLink();
	}

}
