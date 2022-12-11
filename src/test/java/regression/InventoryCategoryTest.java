package regression;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.uiFramework.KTCTC.Pages.InventoryCategoryPage;
import com.uiFramework.KTCTC.testbase.TestBase;

public class InventoryCategoryTest extends TestBase{
	
	InventoryCategoryPage  inventoryCategoryPage;
	int initialCountOfRecords;
	String categoryName;
	String newCategoryName;
	@Test (priority = 1)
	public void verifyNewCategoryCanBeAddedOnCategoryPage()
	{
		SoftAssert sAasert = new SoftAssert();
		  inventoryCategoryPage = new InventoryCategoryPage(driver);
		cmObj.expandInventoryOption(driver);
		 categoryName = cmObj.getcharacterString(6);
		inventoryCategoryPage.navigateToInventoryCategoryPage();
		initialCountOfRecords = inventoryCategoryPage.getCountOfRecordsOnCategoryPage();
		inventoryCategoryPage.addNewCategoryOnCategoryPage(categoryName);
		boolean flag = inventoryCategoryPage.isCategoryPresentOnCategoryPage(categoryName);
		sAasert.assertTrue(flag,"Added category is not displayed on Category page");
		sAasert.assertAll();
	}
	
	@Test (priority = 2)
	public void verifySuccessBannerIsDisplayedForNewlyAddedCategory()
	{
		SoftAssert sAasert = new SoftAssert();
		boolean flag = inventoryCategoryPage.isSuccessBannerDisplayedForAddedCategory();
		sAasert.assertTrue(flag,"Category Added Banner is not displayed");
		sAasert.assertAll();
	}
	
	@Test (priority = 3)
	public void verifyCountIsIncreasedByOneAfterAddigngNewCategory()
	{
		SoftAssert sAasert = new SoftAssert();
		int count = inventoryCategoryPage.getCountOfRecordsOnCategoryPage();		
		sAasert.assertTrue(count==initialCountOfRecords+1,"Records count is not increased by 1 after adding new Category");
		sAasert.assertAll();
	}
	@Test(priority = 4)
	public void verifyUserCanEditExistingCategory()
	{
		SoftAssert sAasert = new SoftAssert();
		initialCountOfRecords = inventoryCategoryPage.getCountOfRecordsOnCategoryPage();
		newCategoryName = cmObj.getcharacterString(7);
		inventoryCategoryPage.editExistingCategoryOnCategoryPage(categoryName, newCategoryName);
		boolean flag = inventoryCategoryPage.isCategoryPresentOnCategoryPage(newCategoryName);
		sAasert.assertTrue(flag,"Edited category is not displayed on category page");
		boolean flag1 = inventoryCategoryPage.isCategoryPresentOnCategoryPage(categoryName);
		sAasert.assertFalse(flag1, "Old category name is still displayed");
		sAasert.assertAll();
	}
	
	@Test(priority = 5)
	public void successBannerIsDisplayedForEditedCategory()
	{
		SoftAssert sAasert = new SoftAssert();
		boolean flag = inventoryCategoryPage.isSuccessBannerDisplayedForEditedCategory();
		sAasert.assertTrue(flag,"Category updated  Banner is not displayed");
		sAasert.assertAll();
	}
	@Test(priority = 6)
	public void verifyCountIsNotChangedAfterEditingExistingCategory()
	{
		SoftAssert sAasert = new SoftAssert();
		int count = inventoryCategoryPage.getCountOfRecordsOnCategoryPage();		
		sAasert.assertTrue(count==initialCountOfRecords,"Records count is not same after editing category");
		sAasert.assertAll();
	}
	
	@Test(priority = 7)
	public void verifyExistingCategoryCanBeDeleted()
	{
		SoftAssert sAasert = new SoftAssert();
		initialCountOfRecords = inventoryCategoryPage.getCountOfRecordsOnCategoryPage();
		inventoryCategoryPage.deleteExistingCategoryOnCategoryPage(newCategoryName);
		boolean flag = inventoryCategoryPage.isCategoryPresentOnCategoryPage(newCategoryName);
		sAasert.assertFalse(flag, "deleted category is still displayed");
		sAasert.assertAll();
	}
	@Test (priority = 8)
	public void verifySuccessBannerIsDisplayedForDeletedCategory()
	{
		SoftAssert sAasert = new SoftAssert();
		boolean flag = inventoryCategoryPage.isSuccessBannerDisplayedForDeletedCategory();
		sAasert.assertTrue(flag,"Category deleted Banner is not displayed");
		sAasert.assertAll();
	}
	@Test(priority = 9)
	public void verifyCountIsDecreasedByOneAfterDeletingCategory()
	{
		SoftAssert sAasert = new SoftAssert();
		int count = inventoryCategoryPage.getCountOfRecordsOnCategoryPage();		
		sAasert.assertTrue(count+1==initialCountOfRecords,"Records count is not decreased after deleting category");
		sAasert.assertAll();
		
	}

}
