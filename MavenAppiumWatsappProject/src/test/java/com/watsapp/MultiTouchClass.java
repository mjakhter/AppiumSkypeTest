package com.watsapp;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class MultiTouchClass {

	protected AndroidDriver<WebElement> driver;
	protected String appPath = System.getProperty("user.dir")
			+ "/apps/MultiTouch Tester.apk";
	protected DesiredCapabilities capabilities;

	@Test
	public void multiTouchMethod() throws IOException, InterruptedException {

		AbstractBaseClass.stopAppiumServer();
		AbstractBaseClass.startAppiumServer();

		capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "5.1.0");
		capabilities.setCapability("deviceName",
				"Google Nexus 5 - 5.1.0 - API22 - 1080x1920");
		capabilities.setCapability("app", appPath);
		capabilities.setCapability("appPackage",
				"com.the511plus.MultiTouchTester");
		capabilities.setCapability("appActivity", ".MultiTouchTester");

		System.out.println("Trying to start the driver");
		driver = new AndroidDriver<WebElement>(new URL(
				"http://127.0.0.1:4723/wd/hub"), capabilities);
		Thread.sleep(5000);

		AbstractBaseClass.stopAppiumServer();
	}

}
