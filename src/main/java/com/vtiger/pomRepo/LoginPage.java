package com.vtiger.pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver localDriver;
	
	public LoginPage(WebDriver driver) {
		this.localDriver=driver;
		PageFactory.initElements(localDriver, this);
	}
	
	@FindBy(name = "user_name")
	private WebElement userName;
	
	@FindBy(name = "user_password")
	private WebElement passWord;
	
	@FindBy(id = "submitButton")
	private WebElement logInBtn;

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassWord() {
		return passWord;
	}

	public WebElement getLogInBtn() {
		return logInBtn;
	}
	
	public void loginLogic(String username, String password) {
	getUserName().sendKeys(username);	
	getPassWord().sendKeys(password);	
	getLogInBtn().click();
	
	System.out.println("Login Attemp Done");
	}

}
