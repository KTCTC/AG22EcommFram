package com.uiFramework.KTCTC.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
		
	/*
	 * @FindBy (id="email") WebElement emailTextBox;
	 * 
	 * @FindBy(xpath = "//button[contains(@class,'delete')]") WebElement
	 * passwordtextBox;
	 * 
	 * @FindBy (linkText = "loginButton") WebElement loginButton;
	 * 
	 * public void loginWithPRovidedCredentials(String uname, String pass) {
	 * emailTextBox.sendKeys(uname); passwordtextBox.sendKeys(pass);
	 * loginButton.click(); }
	 */
	public InventoryCategoryPage(WebDriver driver)
	{
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	/**
	 * Method navigates user to category page
	 */
	public void navigateToInventoryCategoryPage()
	{
		driver.findElement(categoryOptionUnderInventory).click();
		
	}
	
	/**
	 * This method add new user on category page with provided name
	 * @param name
	 */
	public void addNewCategoryOnCategoryPage(String name)
	{
		driver.findElement(newButtonOnCategoryPage).click();
		driver.findElement(nameOnAddNewCategoryModal).sendKeys(name);
		driver.findElement(saveButtonOnAddNewCategoryModal).click();
		
	}
	
	/**
	 * this method search provided string in search box
	 * @param name
	 */
	public void searchProvidedStringInSearchBox(String name)
	{
		clearSearchBoxOnCategoryPage();
		driver.findElement(searchBoxOnCategoryPage).sendKeys(name);
	}
	
	/**
	 * This method clear search box
	 * 
	 */
	public void clearSearchBoxOnCategoryPage()
	{
		String str = driver.findElement(searchBoxOnCategoryPage).getAttribute("value");
		if (str!=null)
		{
			driver.findElement(searchBoxOnCategoryPage).click();
			for (int i=0;i<str.length();i++)
			{
				driver.findElement(searchBoxOnCategoryPage).sendKeys(Keys.BACK_SPACE);
			}
			
		}	
		
	}
	
	
	/**
	 * This method checks if success banner displayed for added category
	 * @return
	 */
	public boolean isSuccessBannerDisplayedForAddedCategory()
	{
		boolean flag = false;
		
		try {
			flag = driver.findElement(successBannerOfCategoryAddedSuccessfully).isDisplayed();
		} catch (Exception e) {
			
		}
		
		return flag;		
	}
	/**
	 * This method checks if success banner displayed for edited category
	 * @return
	 */
	public boolean isSuccessBannerDisplayedForEditedCategory()
	{
		boolean flag = false;
		
		try {
			flag = driver.findElement(successBannerOfCategoryEditedSuccessfully).isDisplayed();
		} catch (Exception e) {
			
		}
		
		return flag;		
	}
	/**
	 * This method checks if success banner displayed for Deleted category
	 * @return
	 */
	public boolean isSuccessBannerDisplayedForDeletedCategory()
	{
		boolean flag = false;
		
		try {
			flag = driver.findElement(successBannerOfCategoryDeletedSuccessfully).isDisplayed();
		} catch (Exception e) {
			
		}
		
		return flag;		
	}
	
	/**
	 * This method returns count of records present on category page
	 * @return
	 */
	public int getCountOfRecordsOnCategoryPage()
	{
		clearSearchBoxOnCategoryPage();
		String cnt = driver.findElement(recordsCountOncategoryPage).getText();		
		String actCount = cnt.trim().split(" ")[5];		
		return Integer.parseInt(actCount);
	}
	
	/**
	 * This method edit/update existing category
	 * @param existingCat
	 * @param newCateName
	 */
	public void editExistingCategoryOnCategoryPage(String existingCat, String newCateName)
	{
		searchProvidedStringInSearchBox(existingCat);
		driver.findElement(editButtonOnCategoryPage).click();
		driver.findElement(nameOnEditCategoryPage).clear();
		driver.findElement(nameOnEditCategoryPage).sendKeys(newCateName);
		driver.findElement(updateButtonOnEditCategoryPage).click();
		
	}
	
	/**
	 * This method deletes existing category
	 * @param existingCat
	 */
	public void deleteExistingCategoryOnCategoryPage(String existingCat)
	{
		searchProvidedStringInSearchBox(existingCat);
		driver.findElement(deleteButtonOnCategoryPage).click();
		driver.findElement(deleteButtonOnDeleteConfirmationModal).click();
		
	}
	
	/**
	 * This method checks if category is present on category page
	 * @param name
	 * @return
	 */
	public boolean isCategoryPresentOnCategoryPage(String name)
	{
		searchProvidedStringInSearchBox(name);
		boolean flag = false;
		
		try {
			flag = driver.findElement(By.xpath("//*[@id='example1']//td[contains(text(),'"+name+"')]")).isDisplayed();
		} catch (Exception e) {
			
		}
		
		return flag;
	}

}
