package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acti.base.DriverScript;
import com.acti.util.Helper;

public class TaskListPage extends DriverScript {
	
//**************************************** Page Elements ***********************************************************//
	
	@FindBy(xpath="//div[text()='Add New']") WebElement buttonAddNew;
	@FindBy(xpath="//div[@class='item createNewCustomer']") WebElement optionNewCustomer;
	@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]") WebElement textboxCustomerName;
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']") WebElement textareaCustomerDescription;
	@FindBy(xpath="//div[text()='Create Customer']") WebElement buttonCreateCustomer;
	@FindBy(xpath="(//input[@placeholder='Start typing name ...'])[1]") WebElement textboxStartTyping;
	@FindBy(xpath="(//span[@class='highlightToken'])[1]") WebElement nodeSearchResult;
	@FindBy(xpath="//span[@class='innerHtml']") WebElement textSuccessMessage;
	@FindBy(xpath="//div[@class='titleEditButtonContainer']/div[@class='editButton']") WebElement buttonEdit;
	@FindBy(xpath="(//div[text()='ACTIONS'])[1]") WebElement buttonAction;
	@FindBy(xpath="(//div[text()='Delete'])[2]") WebElement buttonDelete;
	@FindBy(xpath="//span[text()='Delete permanently']") WebElement buttonDeletePermanentely;
	
//**************************************** Page Initialization ******************************************************//
	
	public TaskListPage()
	{
		PageFactory.initElements(driver, this);
	}
	
//**************************************** Page Actions ******** ******************************************************//
	
	public void clickDeletePermanentelyButton()
	{
		buttonDeletePermanentely.click();
	}
	
	public void clickDeleteButton()
	{
		buttonDelete.click();
	}
	
	public void clickActionButton()
	{
		buttonAction.click();
	}
	
	public void clickEditButton()
	{
		buttonEdit.click();
		Helper.sleep();
	}
	
	public String validateSuccessMessage()
	{
		return textSuccessMessage.getText();
	}
	
	public void clickSearchedCustomer()
	{
		nodeSearchResult.click();
	}
	
	public void enterStartTyping(String cutomername)
	{
		textboxStartTyping.sendKeys(cutomername);
		Helper.sleep();
	}
	
	public void clickAddNew()
	{
		buttonAddNew.click();
	}
	
	public void clickOptionNewCustomer()
	{
		optionNewCustomer.click();
	}
	
	public void enterCustomerName(String customername)
	{
		textboxCustomerName.sendKeys(customername);	
	}
	
	public void enterCustomerDescription(String customerdescription)
	{
		textareaCustomerDescription.sendKeys(customerdescription);
	}
	
	public void clickCreateCustomer()
	{
		buttonCreateCustomer.click();
	}
		
}