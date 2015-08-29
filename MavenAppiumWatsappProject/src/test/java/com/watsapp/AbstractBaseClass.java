package com.watsapp;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

public class AbstractBaseClass {

	protected static String appPath = System.getProperty("user.dir")+"/apps/whatsapp-2.12.252.apk";
	protected static DesiredCapabilities capabilities;
	//protected AndroidDriver<WebElement> driver;
	public static Process process;
	public static String APPIUMSERVERSTART = "C:/Users/AppiumServer/Appium/node.exe C:/Users/AppiumServer/Appium/node_modules/appium/bin/appium.js";

	public static void startAppiumServer() throws IOException, InterruptedException {

		/*CommandLine command = new CommandLine("cmd");
		command.addArgument("/c");
		command.addArgument("C:/Appium/Appium/node.exe");
		command.addArgument("C:/Appium/Appium/node_modules/appium/bin/appium.js");
		command.addArgument("--address");
		command.addArgument("localhost");
		command.addArgument("--port");
		command.addArgument("4723");
		command.addArgument("--no-reset");
		command.addArgument("--log");
		command.addArgument(System.getProperty("user.dir")+"/appiumLogs.txt");
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);

		try {
			executor.execute(command, resultHandler);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		Runtime runtime = Runtime.getRuntime();
		process = runtime.exec(APPIUMSERVERSTART);
		Thread.sleep(5000);
		if(process!=null){
			System.out.println("Appium Server Started");
		}
	}

	public static void stopAppiumServer() {
		/*CommandLine command = new CommandLine("cmd");
		command.addArgument("/c");
		command.addArgument("taskkill");
		command.addArgument("/F");
		command.addArgument("/IM");
		command.addArgument("node.exe");

		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);

		try {
			executor.execute(command, resultHandler);
		} catch (IOException e) {
			e.printStackTrace();
		}
*/
		
		if(process!=null){
			process.destroy();
		}
		System.out.println("Appium Server Stopped");
	}


	public static DesiredCapabilities desiredCapabilitiesMethod() throws MalformedURLException {

			capabilities = new DesiredCapabilities();
			capabilities.setCapability("automationName", "Appium");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", "5.1.0");
			capabilities.setCapability("deviceName",
					"Google Nexus 5 - 5.1.0 - API22 - 1080x1920");
			capabilities.setCapability("app", appPath);
			capabilities.setCapability("appPackage", "com.whatsapp");
			capabilities.setCapability("appActivity", "com.whatsapp.Main");

			return capabilities;
	}
}