package com.vtiger.genericUtility;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnersLibrary implements ITestListener {
	
	public void onTestFailure(ITestResult result) {
		
		String failName = result.getMethod().getMethodName();
		Date dt=new Date();
		String format = dt.toString().replace(":", "_").replace(" ", " _");
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseUtility.edriver);
		File source = edriver.getScreenshotAs(OutputType.FILE);
		File destination=new File("./screenshot/"+failName+"_"+format+".png");
		try {
			FileUtils.copyFile(source, destination);	
			
		} catch (Exception e) {
			System.err.println("NO SCREENSHOT TAKEN");
		}			
	}
}
