package com.vtiger.pomRepo;

/**
 * Home Page Details
 * @author AvinashJ
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericUtility.BaseUtility;

public class HomePage extends BaseUtility {
	WebDriver localDriver;

	public HomePage(WebDriver driver) {
		this.localDriver=driver;
		PageFactory.initElements(localDriver, this);
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/Home.PNG']")
	private WebElement homeBtn;

	@FindBy(className = "hdrLink")
	private WebElement dispHomeText;
	
	private String actualHome="Home";

	@FindBy(linkText = "Organizations")
	private WebElement orgBtn;

	@FindBy(linkText = "Contacts")
	private WebElement contBtn;

	@FindBy(linkText = "Products")
	private WebElement prodBtn;

	@FindBy(linkText = "Vendors")
	private WebElement venBtn;

	@FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreBtn;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminBtn;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutBtn;

	public WebDriver getLocalDriver() {
		return localDriver;
	}

	public String getActualHome() {
		return actualHome;
	}

	public WebElement getHomeBtn() {
		return homeBtn;
	}

	public WebElement getDispHomeText() {
		return dispHomeText;
	}

	public WebElement getOrgBtn() {
		return orgBtn;
	}

	public WebElement getContBtn() {
		return contBtn;
	}

	public WebElement getProdBtn() {
		return prodBtn;
	}

	public WebElement getVenBtn() {
		return venBtn;
	}

	public WebElement getMoreBtn() {
		return moreBtn;
	}

	public WebElement getAdminBtn() {
		return adminBtn;
	}

	public WebElement getSignOutBtn() {
		return signOutBtn;
	}
	
	
	public void logoutProcess() {
		wLIB.mouseHover(localDriver, adminBtn);
		signOutBtn.click();

		System.out.println("LogoutDone");
	}
}
