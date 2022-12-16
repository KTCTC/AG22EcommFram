package regression;

import org.testng.annotations.Test;

import com.uiFramework.KTCTC.Pages.InventoryCategoryPage;
import com.uiFramework.KTCTC.testbase.TestBase;

public class InventoryProductTest extends TestBase{
	String categoryName; 
	
	@Test
	public void verifyNewProductCanBeAdded()
	{
		InventoryCategoryPage inventoryCategoryPage = new InventoryCategoryPage(driver);
		cmObj.expandInventoryOption(driver);
		inventoryCategoryPage.navigateToInventoryCategoryPage();
		categoryName = cmObj.getcharacterString(5);
		inventoryCategoryPage.addNewCategoryOnCategoryPage(categoryName);
		
	
	}

}
