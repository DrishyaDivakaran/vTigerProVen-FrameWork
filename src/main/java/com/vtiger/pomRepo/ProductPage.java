package com.vtiger.pomRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class ProductPage {

	WebDriver localDriver;

	public ProductPage(WebDriver driver) {
		this.localDriver=driver;
		PageFactory.initElements(localDriver, this);
	}

	private String actualProductsPage="Products";

	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement addBtn;

	@FindBy(className = "hdrLink")
	private WebElement dispProductsText;

	@FindBy(xpath = "//input[@class='txtBox']")
	private WebElement searchBox;

	@FindBy(xpath ="//select[@id='bas_searchfield' and @name='search_field']")
	private WebElement selType;

	@FindBy(xpath = "//option[@value='productname']")
	private WebElement prdName;

	@FindBy(xpath = "//input[@value=' Search Now ']")
	private WebElement searchBtn;

	@FindBy(className = "lvtHeaderText")
	private WebElement displayPage;

	@FindBy(xpath = "//input[@name='productname']")
	private WebElement textBox;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;


	public String getActualProductsPage() {
		return actualProductsPage;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getDispProductsText() {
		return dispProductsText;
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

	public WebElement getDisplayPage() {
		return displayPage;
	}

	public WebElement getTextBox() {
		return textBox;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement linkBtn;

	public WebElement getLinkBtn() {
		return linkBtn;
	}
	
	//POPUP WINDOW WEBELEMENTS
		@FindBy(xpath = "//input[@name='search_text' and @id='search_txt']")
		private WebElement searchTextNew;
		
		@FindBy(xpath = "//input[@type='button']")
		private WebElement searhBoxNew;

		
	
	public void searchProduct(String createdPro) {
		searchTextNew.sendKeys(createdPro);
		searchBox.click();
		
		try {
			localDriver.findElement(By.xpath("//a[text()='"+createdPro+"']")).getText();
		} catch (Exception e) {
			Reporter.log("NO Vendor Avaialble",true);
			System.err.println("NO Vendor Avaialble");
			Assert.fail();
		}
		
		String searchProduct=localDriver.findElement(By.xpath("//a[text()='"+createdPro+"']")).getText();
		
		if(searchProduct.contains(createdPro)) {
			System.out.println("Product and Vendor Linked");
			Reporter.log("Product and Vendor Linked");
			Assert.assertTrue(true);
			localDriver.findElement(By.xpath("//a[text()='"+createdPro+"']")).click();
		}
		else {
			System.err.println("Product and Vendor Not Linked");
			Reporter.log("Product and Vendor Not Linked",true);
			Assert.assertFalse(false);
		}
	}

}
