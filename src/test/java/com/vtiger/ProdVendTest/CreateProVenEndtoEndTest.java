package com.vtiger.ProdVendTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.genericUtility.BaseUtility;
import com.vtiger.pomRepo.HomePage;
import com.vtiger.pomRepo.ProductPage;
import com.vtiger.pomRepo.VendorPage;

public class CreateProVenEndtoEndTest extends BaseUtility  {

	@Test
	public void vendorCreate() throws IOException {
		//Verify Homepage is displayed or not
		HomePage hp=new HomePage(driver);
		String homepage = hp.getDispHomeText().getText();
		System.out.println(homepage);		
		Assert.assertEquals(homepage,hp.getActualHome());

		//Navigate vendor page & Verify
		VendorPage vp=new VendorPage(driver);
		wLIB.mouseHover(driver, hp.getMoreBtn());
		hp.getVenBtn().click();
		String vendorpage = vp.getDispVendorText().getText();
		Assert.assertEquals(vendorpage,vp.getActualVendorPage());

		//Entering Vendor Data and saving it
		String createdVender = eLIB.readExcel("VTiger", 1, 6)+jLIB.randomNumbers();
		vp.getAddBtn().click();
		vp.getTextBox().sendKeys(createdVender);
		vp.getSaveBtn().click();
		

		//Verify Product page is displayed or not
		hp.getProdBtn().click();
		ProductPage pp=new ProductPage(driver);
		String productspage=pp.getDispProductsText().getText();
		Assert.assertEquals(productspage,pp.getActualProductsPage());		
		String parentWind = driver.getTitle();
		
		//Entering Product Data and linking the Vendor and saving it		
		pp.getAddBtn().click();
		pp.getTextBox().sendKeys(eLIB.readExcel("VTiger", 1, 5)+jLIB.randomNumbers());		
		pp.getLinkBtn().click();		
		wLIB.winSwitch(driver, vp.getWindSwitchText());			
		pp.searchProduct(createdVender);		
		wLIB.winSwitch(driver, parentWind);			
		pp.getSaveBtn().click();
	}
}
