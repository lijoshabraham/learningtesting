package com.abrahamlijoshjan24.FirstMavenProject;

import java.util.concurrent.TimeUnit;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Register {

	EdgeDriver driver = null;
	String randomEmail;
	String randomPassword;

	@BeforeMethod
	public void inititalisation() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\user\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	}

	private String generateRandomEmail() {
		return "mail" + RandomStringUtils.randomAlphanumeric(5) + "@samplmail.com";
	}

	private String generateRandomPassword() {
		return RandomStringUtils.randomAlphanumeric(8);
	}

	@Test
	public void signUp() {
		WebElement firstName = driver.findElement(By.id("input-firstname"));
		firstName.sendKeys("Lijosh");
		WebElement lasttName = driver.findElement(By.id("input-lastname"));
		lasttName.sendKeys("Abraham");
		// email
		randomEmail = generateRandomEmail();
		WebElement email = driver.findElement(By.id("input-email"));
		email.sendKeys(randomEmail);

		WebElement phone = driver.findElement(By.id("input-telephone"));
		phone.sendKeys("6476753055");
		// password
		randomPassword = generateRandomPassword();
		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys(randomPassword);
		WebElement confirmPassword = driver.findElement(By.id("input-confirm"));
		confirmPassword.sendKeys(randomPassword);

		WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
		checkbox.click();
		WebElement continueBtn = driver.findElementByCssSelector("input[type='submit']");
		continueBtn.submit();

	}

	@Test
	public void contactUs() {
		WebElement contactUsBtn = driver.findElementByXPath("//a[contains(text(), 'Contact Us')]");
		contactUsBtn.click();

		WebElement name = driver.findElement(By.id("input-name"));
		name.sendKeys("Tester");

		WebElement email = driver.findElement(By.id("input-email"));
		email.sendKeys(randomEmail);

		WebElement enquiryMessage = driver.findElement(By.id("input-enquiry"));
		enquiryMessage.sendKeys("Testing...testing...testing");

		WebElement submitBtn = driver
				.findElementByCssSelector("div.buttons div.pull-right input[type=\"submit\"].btn.btn-primary");
		submitBtn.submit();
	}

	@Test
	public void purchaseGift() {
		WebElement purchaseBtn = driver.findElementByCssSelector("a[href*=voucher]");
		purchaseBtn.click();

		WebElement RecipientName = driver.findElement(By.id("input-to-name"));
		RecipientName.sendKeys("Name");

		WebElement RecipientEmail = driver.findElement(By.id("input-to-email"));
		RecipientEmail.sendKeys(randomEmail);

		WebElement yourName = driver.findElement(By.id("input-from-name"));
		yourName.sendKeys("your_name");

		WebElement yourEmail = driver.findElement(By.id("input-from-email"));
		yourEmail.sendKeys(randomEmail);

		WebElement birthdayTheme = driver.findElement(By.cssSelector("input[name='voucher_theme_id'][value='7']"));
		birthdayTheme.click();

		WebElement message = driver.findElement(By.id("input-message"));
		message.sendKeys("Happy Birthday!");

		WebElement amount = driver.findElement(By.id("input-amount"));
		amount.clear();
		amount.sendKeys("50");

		WebElement checkbox = driver.findElement(By.name("agree"));
		checkbox.click();
		WebElement continueButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
		continueButton.click();
	}

	@Test
	public void returns() {
		WebElement returnBtn = driver
				.findElementByXPath("//ul[@class='list-unstyled']/li[2]/a[contains(text(), 'Returns')]");
		returnBtn.click();
		WebElement firstName = driver.findElement(By.id("input-firstname"));
		firstName.sendKeys("Lijosh");
		WebElement lastName = driver.findElement(By.id("input-lastname"));
		lastName.sendKeys("Abraham");
		WebElement email = driver.findElement(By.id("input-email"));
		email.sendKeys("lijosh@gmail.com");
		WebElement phone = driver.findElement(By.id("input-telephone"));
		phone.sendKeys("6476753055");
		WebElement orderId = driver.findElement(By.id("input-order-id"));
		orderId.sendKeys("12345");
		WebElement date = driver.findElement(By.id("input-date-ordered"));
		date.sendKeys("2024-01-27");
		WebElement productName = driver.findElement(By.id("input-product"));
		productName.sendKeys("phone");
		WebElement productCode = driver.findElement(By.id("input-model"));
		productCode.sendKeys("56789");
		WebElement productQuantity = driver.findElement(By.id("input-quantity"));
		productQuantity.sendKeys("1");
		WebElement reason = driver
				.findElement(By.cssSelector("input[type=\"radio\"][name=\"return_reason_id\"][value=\"3\"]"));
		reason.click();
		WebElement opened = driver.findElement(By.cssSelector("input[type='radio'][name='opened'][value='1']"));
		opened.click();
		WebElement otherDetails = driver.findElement(By.id("input-comment"));
		otherDetails.sendKeys("Reason");
		WebElement submitBtn = driver.findElement(By.cssSelector("input[type='submit']"));
		submitBtn.submit();

	}

	@Test
	public void changePassword() {

		WebElement loginBtn = driver
				.findElement(By.cssSelector("#column-right .list-group-item[href*='account/login']"));
		loginBtn.click();
		WebElement loginEmail = driver.findElement(By.id("input-email"));
		loginEmail.sendKeys(randomEmail);
		WebElement loginPassword = driver.findElement(By.id("input-password"));
		loginPassword.sendKeys(randomPassword);
		WebElement loginContinueBtn = driver.findElement(By.id("vueloginButton"));
		loginContinueBtn.click();
		WebElement updatePasswordBtn = driver.findElement(By.cssSelector("div.list-group>a:nth-of-type(3)"));
		updatePasswordBtn.click();

		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys(generateRandomEmail());
		WebElement confirmPassword = driver.findElement(By.id("input-confirm"));
		confirmPassword.sendKeys(generateRandomPassword());

		WebElement continueBtn = driver.findElement(By.cssSelector("input[type='submit']"));
		continueBtn.submit();
	}

	@Test
	public void editAccount() {
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		WebElement email = driver.findElement(By.cssSelector("form input#input-email"));
		WebElement pwd = driver.findElement(By.cssSelector("form input#input-password"));
		WebElement loginBtn = driver.findElement(By.id("vueloginButton"));
		email.sendKeys("lijosh@gmail.com");
		pwd.sendKeys("password");
		loginBtn.submit();
		WebElement editAccount = driver.findElement(By.cssSelector("div.list-group>a:nth-of-type(2)"));
		editAccount.click();
		WebElement firstName = driver.findElement(By.id("input-firstname"));
		firstName.sendKeys("Lijosh1");
		WebElement lasttName = driver.findElement(By.id("input-lastname"));
		lasttName.sendKeys("Abraham1");
		WebElement newEmail = driver.findElement(By.id("input-email"));
		newEmail.sendKeys("lijosh1@gmail.com");
		WebElement phone = driver.findElement(By.id("input-telephone"));
		phone.sendKeys("6476753045");

		WebElement continueBtn = driver.findElement(By.cssSelector("input[type='submit']"));
		continueBtn.submit();

	}

	@Test
	public void alerts() {
		driver.get("https://demoqa.com/alerts");
		WebElement btn = driver.findElement(By.id("promtButton"));

		btn.click();

		Alert alert = driver.switchTo().alert();

		alert.sendKeys("hai");

		alert.accept();

	}

}
