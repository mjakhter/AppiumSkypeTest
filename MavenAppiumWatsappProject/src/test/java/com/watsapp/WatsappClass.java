package com.watsapp;

import io.appium.java_client.android.AndroidDriver;
import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class WatsappClass extends AbstractBaseClass {

	protected AndroidDriver<WebElement> driver;
	protected String appPath = System.getProperty("user.dir")
			+ "/apps/whatsapp-2.12.252.apk";
	protected DesiredCapabilities capabilities;

	@Test
	public void launchingWatsapp() throws IOException, InterruptedException {

		stopAppiumServer();
		startAppiumServer();

		capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "5.1.0");
		capabilities.setCapability("deviceName",
				"Google Nexus 5 - 5.1.0 - API22 - 1080x1920");
		capabilities.setCapability("app", appPath);
		capabilities.setCapability("appPackage", "com.whatsapp");
		capabilities.setCapability("appActivity", "com.whatsapp.Main");

				
		System.out.println("Trying to start the driver");
		driver = new AndroidDriver<WebElement>(new URL(
				"http://127.0.0.1:4723/wd/hub"), capabilities);
		Thread.sleep(5000);
		//com.whatsapp:id/parentPanel
		if (driver.findElement(By.id("com.whatsapp:id/eula_accept"))
				.isDisplayed()) {   //button2
			driver.findElement(By.id("android:id/eula_accept")).click();
			System.out.println("Successfully clicked on the \"OK\" button");
		}
		// driver.findElement(By.partialLinkText("Agree and continue")).click();
		driver.findElementByAndroidUIAutomator(
				"new UiSelector().textMatches(\"Agree and continue\")").click();

		if (!(driver.findElement(By.id("com.whatsapp:id/registration_country"))
				.getText().equalsIgnoreCase("United States"))) {
			driver.findElement(By.id("com.whatsapp:id/registration_country"))
					.sendKeys("United States");
		}

		driver.findElement(By.id("com.whatsapp:id/registration_phone"))
				.sendKeys("1234567890");
		driver.findElement(By.id("com.whatsapp:id/registration_submit"))
				.click();

		Thread.sleep(30000);
		try{
		if (driver.findElement(By.id("android.widget.LinearLayout"))
				.isDisplayed()) {
			driver.findElement(By.id("android:id/button1")).click();
		}
		}catch(Exception e){
			
		}
	}

}