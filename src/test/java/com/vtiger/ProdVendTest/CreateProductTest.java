package com.vtiger.ProdVendTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.genericUtility.BaseUtility;
import com.vtiger.pomRepo.HomePage;
import com.vtiger.pomRepo.ProductPage;

public class CreateProductTest extends BaseUtility {
	
	@Test
	public void productCreateTest() throws IOException {
		//Verify Homepage is displayed or not
		HomePage hp=new HomePage(driver);
		String homepage = hp.getDispHomeText().getText();
		System.out.println(homepage);		
		Assert.assertEquals(homepage,hp.getActualHome());
		
		//Verify Product page is displayed or not
		hp.getProdBtn().click();
		ProductPage pp=new ProductPage(driver);
		String productspage=pp.getDispProductsText().getText();
		Assert.assertEquals(productspage,pp.getActualProductsPage());
		
		//Entering Product Data and saving it
		pp.getAddBtn().click();
		pp.getTextBox().sendKeys(eLIB.readExcel("VTiger", 1, 5)+jLIB.randomNumbers());
		pp.getSaveBtn().click();
		
	}

}
