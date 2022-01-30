package com.vtiger.pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPage {
	
WebDriver localDriver;
	
	public VendorPage(WebDriver driver) {
		this.localDriver=driver;
		PageFactory.initElements(localDriver, this);
	}
	
	private String actualVendorPage="Vendors";
	
	private String windSwitchText="Vendors&action";
	
	@FindBy(xpath = "//img[@alt='Create Vendor...']")
	private WebElement addBtn;
	
	@FindBy(className = "hdrLink")
	private WebElement dispVendorText;
	
	@FindBy(xpath = "//input[@class='txtBox']")
	private WebElement searchBox;
	
	@FindBy(xpath ="//select[@id='bas_searchfield' and @name='search_field']")
	private WebElement selType;
	
	@FindBy(xpath = "//option[@value='vendorname']")
	private WebElement prdName;
	
	@FindBy(xpath = "//input[@value=' Search Now ']")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@name='vendorname']")
	private WebElement textBox;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getDispVendorText() {
		return dispVendorText;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSelType() {
		return selType;
	}

	public WebElement getPrdName() {
		return prdName;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getTextBox() {
		return textBox;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public String getActualVendorPage() {
		return actualVendorPage;
	}
	
	public String getWindSwitchText() {
		return windSwitchText;
	}
	
}
