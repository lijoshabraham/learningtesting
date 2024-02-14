package com.abrahamlijoshjan24.FirstMavenProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicWebElements {

	EdgeDriver driver = null;
	String currentTimeXpath = "//div[@id='clock0_bg']/time[@id='clock']";

	@BeforeMethod
	public void initialization() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\user\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://time.is/");
	}

	/*
	 * @Test public void time() { List<WebElement> currentTime =
	 * driver.findElements(By.xpath("//div[@id='clock0_bg']/time/span"));
	 * 
	 * for (WebElement webElement : currentTime) {
	 * System.out.println(webElement.getText());
	 * 
	 * } currentTime =
	 * driver.findElements(By.xpath("//div[@id='clock0_bg']/time/span")); }
	 */

	@Test
	public void currentTime() {

		printCurrentTime(currentTimeXpath);

	}
	
	private void printCurrentTime(String locator) {
		while (true) {

			List<WebElement> currentTime = driver.findElements(By.xpath(currentTimeXpath));

			for (WebElement webElement : currentTime) {
				System.out.println(webElement.getText());

			}
		}
	}

}
