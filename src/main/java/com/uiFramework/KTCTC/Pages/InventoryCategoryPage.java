package com.uiFramework.KTCTC.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uiFramework.KTCTC.helper.wait.WaitHelper;

public class InventoryCategoryPage {
	private WebDriver driver;
	By categoryOptionUnderInventory = By.xpath("//a[starts-with(@href,'category')]");
	
	By newButtonOnCategoryPage = By.xpath("//a[@href='#addnew']");
	By nameOnAddNewCategoryModal = By.id("name");
	By saveButtonOnAddNewCategoryModal = By.name("add");
	By searchBoxOnCategoryPage = By.xpath("//*[@id='example1_filter']//input");
	
	By successBannerOfCategoryAddedSuccessfully = By.xpath("//*[contains(@class,'content')]//div[contains(.,'Category added successfully')]");
	
	By recordsCountOncategoryPage = By.xpath("//*[contains(text(),'Showing 1')]");
	
	By editButtonOnCategoryPage = By.xpath("//button[contains(@class,'edit')]");
	By nameOnEditCategoryPage = By.id("edit_name");
	By updateButtonOnEditCategoryPage = By.name("edit");
	
	By successBannerOfCategoryEditedSuccessfully = By.xpath("//*[contains(@class,'content')]//div[contains(.,'Category updated successfully')]");
	By deleteButtonOnCategoryPage = By.xpath("//button[contains(@class,'delete')]");
	
	By deleteButtonOnDeleteConfirmationModal = By.name("delete");
	By successBannerOfCategoryDeletedSuccessfully = By.xpath("//*[contains(@class,'content')]//div[contains(.,'Category deleted successfully')]");
	
	
	public InventoryCategoryPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void navigateToInventoryCategoryPage()
	{
		driver.findElement(categoryOptionUnderInventory).click();
	}
	
	public void addNewCategoryOnCategoryPage(String name)
	{
		driver.findElement(newButtonOnCategoryPage).click();
		driver.findElement(nameOnAddNewCategoryModal).sendKeys(name);
		driver.findElement(saveButtonOnAddNewCategoryModal).click();
		
	}
	
	public void searchProvidedStringInSearchBox(String name)
	{
		clearSearchBoxOnCategoryPage();
		driver.findElement(searchBoxOnCategoryPage).sendKeys(name);
	}
	
	public void clearSearchBoxOnCategoryPage()
	{
		driver.findElement(searchBoxOnCategoryPage).clear();
		WaitHelper wt = new WaitHelper(driver);
		wt.waitForElementNotPresent(driver.findElement(By.xpath("//*[contains(text(),'filtered from')]")), 5);
		
	}
	
	
	public boolean isSuccessBannerDisplayedForAddedCategory()
	{
		boolean flag = false;
		
		try {
			flag = driver.findElement(successBannerOfCategoryAddedSuccessfully).isDisplayed();
		} catch (Exception e) {
			
		}
		
		return flag;		
	}
	public boolean isSuccessBannerDisplayedForEditedCategory()
	{
		boolean flag = false;
		
		try {
			flag = driver.findElement(successBannerOfCategoryEditedSuccessfully).isDisplayed();
		} catch (Exception e) {
			
		}
		
		return flag;		
	}
	public boolean isSuccessBannerDisplayedForDeletedCategory()
	{
		boolean flag = false;
		
		try {
			flag = driver.findElement(successBannerOfCategoryDeletedSuccessfully).isDisplayed();
		} catch (Exception e) {
			
		}
		
		return flag;		
	}
	
	public int getCountOfRecordsOnCategoryPage()
	{
		clearSearchBoxOnCategoryPage();
		String cnt = driver.findElement(recordsCountOncategoryPage).getText();		
		String actCount = cnt.trim().split(" ")[5];		
		return Integer.parseInt(actCount);
	}
	
	public void editExistingCategoryOnCategoryPage(String existingCat, String newCateName)
	{
		searchProvidedStringInSearchBox(existingCat);
		driver.findElement(editButtonOnCategoryPage).click();
		driver.findElement(nameOnEditCategoryPage).clear();
		driver.findElement(nameOnEditCategoryPage).sendKeys(newCateName);
		driver.findElement(updateButtonOnEditCategoryPage).click();
		
	}
	
	public void deleteExistingCategoryOnCategoryPage(String existingCat)
	{
		searchProvidedStringInSearchBox(existingCat);
		driver.findElement(deleteButtonOnCategoryPage).click();
		driver.findElement(deleteButtonOnDeleteConfirmationModal).click();
		
	}
	
	public boolean isCategoryPresentOnCategoryPage(String name)
	{
		boolean flag = false;
		
		try {
			flag = driver.findElement(By.xpath("//*[@id='example1']//td[contains(text(),'"+name+"')]")).isDisplayed();
		} catch (Exception e) {
			
		}
		
		return flag;
	}

}
