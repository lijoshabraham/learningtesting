package com.abrahamlijoshjan24.FirstMavenProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssignmentFeb12 {

	private static final String EDGE_DRIVER_PATH = "C:\\Users\\user\\Downloads\\edgedriver_win64\\msedgedriver.exe";
    private static final String PAGE_URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";
    private static final String TEST_EMAIL = "lijosh@gmail.com";
    private static final String TEST_PASSWORD = "password";

    private EdgeDriver driver;

	@BeforeMethod
	public void inititalisation() {
		System.setProperty("webdriver.edge.driver", EDGE_DRIVER_PATH);
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(PAGE_URL);
	}

	@AfterMethod
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
	
	@Test
	public void purchase() {
		login();
		navigateToLaptops();
		addToCart();
		viewCartAndCheckout();
		fillBillingDetails();
		testFinalResult();

	}

	private void login() {
		WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys(TEST_EMAIL);
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys(TEST_PASSWORD);
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();
	}

	private void navigateToLaptops() {
		Actions actions = new Actions(driver);
		WebElement mouseHover = driver
				.findElement(By.xpath("//a[contains(text(), 'Laptops & Notebooks') and @class='dropdown-toggle']"));
		actions.moveToElement(mouseHover).perform();
		WebElement showAllBtn = driver
				.findElement(By.xpath("//a[@class='see-all' and contains(text(), 'Show All Laptops & Notebooks')]"));
		showAllBtn.click();
	}

	private void addToCart() {
		WebElement addToCartBtn = driver.findElementByXPath(
				"//div[@class='caption' and h4/a[contains(text(), 'MacBook Pro')]]/following-sibling::div[@class='button-group']/button[contains(@onclick, \"cart.add\")]");
		addToCartBtn.click();
	}

	/*
	 * private void viewCartAndCheckout() { // WebElement shoppingCartBtn =
	 * driver.findElementByXPath( //
	 * "//div[contains(@class, 'alert-success')]/a[contains(@href, 'route=checkout/cart')]"
	 * ); // shoppingCartBtn.click();
	 * 
	 * 
	 * WebElement cartBtn = driver.
	 * findElementByCssSelector("#cart button[type='button'][data-toggle='dropdown']"
	 * ); cartBtn.click();
	 * 
	 * WebElement viewCartBtn = driver.findElementByXPath(
	 * "//p[@class='text-right']//a[@href='https://naveenautomationlabs.com/opencart/index.php?route=checkout/cart']"
	 * ); viewCartBtn.click();
	 * 
	 * WebElement checkoutBtn = driver
	 * .findElementByCssSelector("div.pull-right a.btn[href*='route=checkout/checkout']"
	 * ); checkoutBtn.click();
	 * 
	 * }
	 */

	private void viewCartAndCheckout() {

		sleep();

		WebElement shoppingCartBtn = driver.findElementByXPath(
				"//div[contains(@class, 'alert-success')]/a[contains(@href, 'route=checkout/cart')]");
		shoppingCartBtn.click();

		sleep();

		WebElement checkoutBtn = driver
				.findElementByCssSelector("div.pull-right a.btn[href*='route=checkout/checkout']");
		checkoutBtn.click();
	}

	private void fillBillingDetails() {

		WebElement newAddressBtn = driver
				.findElementByCssSelector("input[type='radio'][name='payment_address'][value='new']");
		newAddressBtn.click();

		WebElement firstName = driver.findElement(By.id("input-payment-firstname"));
		firstName.sendKeys("Albert");

		WebElement lastName = driver.findElement(By.id("input-payment-lastname"));
		lastName.sendKeys("John");

		WebElement billingAddress = driver.findElement(By.id("input-payment-address-1"));
		billingAddress.sendKeys("10 Edward st");

		WebElement city = driver.findElement(By.id("input-payment-city"));
		city.sendKeys("Toronto");

		WebElement postalCode = driver.findElement(By.id("input-payment-postcode"));
		postalCode.sendKeys("M2J 4A6");

		WebElement country = driver.findElement(By.xpath("//select[@name='country_id']/option[text()='Canada']"));
		country.click();

		WebElement region = driver.findElement(By.xpath("//select[@name='zone_id']/option[text()='Ontario']"));
		region.click();

		WebElement billingContinueBtn = driver.findElement(By.id("button-payment-address"));
		billingContinueBtn.click();

		WebElement deliveryContinueBtn = driver.findElement(By.id("button-shipping-address"));
		deliveryContinueBtn.click();

		WebElement addComments = driver.findElement(By.xpath("//textarea[@name='comment']"));
		addComments.sendKeys(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,");

		WebElement deliveryMthdContinueBtn = driver.findElement(By.id("button-shipping-method"));
		deliveryMthdContinueBtn.click();

		WebElement paymentCheckbox = driver.findElement(By.cssSelector(" input[type='checkbox']"));
		paymentCheckbox.click();

		WebElement paymentConfirmBtn = driver.findElement(By.id("button-payment-method"));
		paymentConfirmBtn.click();

		WebElement confirmBtn = driver.findElement(By.id("button-confirm"));
		confirmBtn.click();

	}

	private void testFinalResult() {

		WebElement headerElement = driver.findElement(By.tagName("h1"));
		String actualHeaderText = headerElement.getText();

		String expectedHeaderText = "Your order has been placed!";

		Assert.assertEquals(actualHeaderText, expectedHeaderText, "Header text doesn't match");

		if (actualHeaderText.equals(expectedHeaderText)) {
			WebElement continueButton = driver.findElement(By.cssSelector(".pull-right a.btn-primary"));
			continueButton.click();
		}

	}

	private void sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
