package com.abrahamlijoshjan24.FirstMavenProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class IframesExamples {
	
	EdgeDriver driver = null;
	@BeforeMethod
	public void inititalisation() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\user\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.pcloudy.com/contact-us/");
	}
	
	@Test
	public void switchBetweenIframes() {
		
		driver.switchTo().frame("hs-form-iframe-0");
		WebElement sampleText = driver.findElementByXPath("//label[@id='label-email-95cf67e4-a812-49be-a16d-d881a933d83d']/span[contains(text(), 'Business Email')]\r\n"
				+ "");
		String text = sampleText.getText();
		System.out.println(text);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("a-ue924mss4xot");
		
		WebElement sampleText2 = driver.findElementByXPath("//div[@class='rc-anchor-pt']/a[text()='Privacy']\r\n");
		String text2 = sampleText2.getText();
		System.out.println(text2);
		
		
	}

}
