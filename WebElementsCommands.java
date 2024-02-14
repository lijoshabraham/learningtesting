package com.abrahamlijoshjan24.FirstMavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebElementsCommands {

	EdgeDriver driver = null;

	@BeforeMethod
	public void intialisation() {
		// Setting the path to the respective driver
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\user\\Downloads\\edgedriver_win64\\msedgedriver.exe");

		// Launch the browser instance
		driver = new EdgeDriver();

		driver.get("https://demoqa.com/text-box");
	}

	@Test
	public void sendKeysToInputField() {

		WebElement userName = driver.findElement(By.id("userName"));
		WebElement userEmail = driver.findElement(By.id("userEmail"));
		WebElement address = driver.findElement(By.id("currentAddress"));
		WebElement pAddress = driver.findElement(By.id("permanentAddress"));

		userName.sendKeys("Manvir");
		userEmail.sendKeys("abc@gmail.com");
		address.sendKeys("Canada");
		pAddress.sendKeys("India");
	}

	@Test
	public void clickButton() {

		WebElement userName = driver.findElement(By.id("userName"));
		WebElement userEmail = driver.findElement(By.id("userEmail"));
		WebElement address = driver.findElement(By.id("currentAddress"));
		WebElement pAddress = driver.findElement(By.id("permanentAddress"));

		userName.sendKeys("Manvir");
		userEmail.sendKeys("abc@gmail.com");
		address.sendKeys("Canada");
		pAddress.sendKeys("India");

		WebElement submitBtn = driver.findElement(By.id("submit"));
		submitBtn.click();

	}

	@Test
	public void isLogoDisplayed() {

		WebElement logo = driver.findElement(By.cssSelector("header>a>img"));
		boolean isLogoDisplayed = logo.isDisplayed();
		System.out.println("Is Logo Displated: " + isLogoDisplayed);
	}

	@Test
	public void submitButton() {

		WebElement userName = driver.findElement(By.id("userName"));
		WebElement userEmail = driver.findElement(By.id("userEmail"));
		WebElement address = driver.findElement(By.id("currentAddress"));
		WebElement pAddress = driver.findElement(By.id("permanentAddress"));

		userName.sendKeys("Manvir");
		userEmail.sendKeys("abc@gmail.com");
		address.sendKeys("Canada");
		pAddress.sendKeys("India");

		WebElement submitBtn = driver.findElement(By.id("submit"));
		submitBtn.submit();

	}

	@Test
	public void getTextTest() {

		WebElement userName = driver.findElement(By.id("userName"));
		WebElement userEmail = driver.findElement(By.id("userEmail"));
		WebElement address = driver.findElement(By.id("currentAddress"));
		WebElement pAddress = driver.findElement(By.id("permanentAddress"));
		userName.sendKeys("Manvir");
		userEmail.sendKeys("abc@gmail.com");
		address.sendKeys("Canada");
		pAddress.sendKeys("India");
		WebElement submitBtn = driver.findElement(By.id("submit"));
		submitBtn.click();
		WebElement enteredName = driver.findElement(By.id("name"));
		String enteredNameText = enteredName.getText();
		System.out.println(enteredNameText);
	}

	@Test
	public void clearCommand() {

		WebElement userName = driver.findElement(By.id("userName"));
		WebElement userEmail = driver.findElement(By.id("userEmail"));
		WebElement address = driver.findElement(By.id("currentAddress"));
		WebElement pAddress = driver.findElement(By.id("permanentAddress"));
		userName.sendKeys("Manvir");
		userEmail.sendKeys("abc@gmail.com");
		address.sendKeys("Canada");
		pAddress.sendKeys("India");

		pAddress.clear();

	}
}