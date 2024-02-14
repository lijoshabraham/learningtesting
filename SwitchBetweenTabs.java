package com.abrahamlijoshjan24.FirstMavenProject;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwitchBetweenTabs {

    EdgeDriver driver = null;

    @BeforeMethod
    public void initialization() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\user\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.thesource.ca/en-ca");
    }

    @Test
    public void openTabs() {
        // open tab2
        WebElement tabOne = driver
                .findElement(By.xpath("//div[@class='trending-icon content']/a[@href='/financing']\r\n"));
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).moveToElement(tabOne).click().perform();

        // open tab3
        WebElement tabTwo = driver
                .findElement(By.xpath("//div[@class='trending-icon content']/a[text()='Free Store Pick Up']"));
        action.keyDown(Keys.CONTROL).moveToElement(tabTwo).click().perform();

        String parentHandle = driver.getWindowHandle();
        		
        Set<String> windowHandles = driver.getWindowHandles();

        if (switchBetweenTabs("Shipping", windowHandles)) {
            System.out.println("Window Title is :" + driver.getTitle());
        }
        
        driver.switchTo().window(parentHandle);
    }

    private boolean switchBetweenTabs(String tabTitle, Set<String> windowHandles) {
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(tabTitle)) {
                return true;
            }
        }
        return false;
    }
}
