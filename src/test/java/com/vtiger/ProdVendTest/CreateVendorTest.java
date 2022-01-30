package com.vtiger.ProdVendTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.genericUtility.BaseUtility;
import com.vtiger.pomRepo.HomePage;
import com.vtiger.pomRepo.VendorPage;

public class CreateVendorTest extends BaseUtility  {
	
	@Test
	public void vendorCreateTest() throws IOException {
		//Navigate vendor page & Verify
		VendorPage vp=new VendorPage(driver);
		HomePage hp=new HomePage(driver);
		wLIB.mouseHover(driver, hp.getMoreBtn());
		hp.getVenBtn().click();
		String vendorpage = vp.getDispVendorText().getText();
		Assert.assertEquals(vendorpage,vp.getActualVendorPage());
		
		//Entering Vendor Data and saving it
		vp.getAddBtn().click();
		vp.getTextBox().sendKeys(eLIB.readExcel("VTiger", 1, 6)+jLIB.randomNumbers());
		vp.getSaveBtn().click();
		
	}
}
