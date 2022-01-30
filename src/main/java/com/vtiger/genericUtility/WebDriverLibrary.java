package com.vtiger.genericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverLibrary {
	
	private WebElement Element;

	public void winMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void winWaitImplicity(WebDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void winWaitExplicit(WebDriver driver, int time, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));		
	}

	public void dropDown(WebElement element, int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}

	public void dropDown(WebElement element, String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}

	public void dropDown(String text, WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(text);		
	}

	public void mouseHover(WebDriver driver, WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}

	public void mouseRightClick(WebDriver driver) {
		Actions a=new Actions(driver);
		a.contextClick(Element).perform();
	}

	public void mouseDoubleClick(WebDriver driver) {
		Actions a=new Actions(driver);
		a.doubleClick(Element).perform();
	}

	public void robotKey() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public void winSwitch(WebDriver driver, String winName) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext()) {
			winName = it.next();
			String winTitle = driver.switchTo().window(winName).getTitle();
			if(winTitle.contains(winName)) {
				break;
			}
		}
	}

}
