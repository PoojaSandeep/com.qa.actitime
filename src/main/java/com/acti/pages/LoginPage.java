package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

/*
 * Title: DriverScript
 * Description: 
 * Developed By: Pooja Prahlad
 * Data : 30/07/2021
 * Approved By: Shantosh Kumar
 * Approved Date: 30/07/2021
 */

public class LoginPage extends DriverScript{

//******************************Page Elements ***************************************************************
	@FindBy(id="username") WebElement textUsername;
	@FindBy(name="pwd") WebElement textPassword;
	@FindBy(xpath="//div[text()='Login ']") WebElement buttonLogin;
	@FindBy(xpath="//span[@class='errormsg']") WebElement textLoginErrorMessage;
	
	
//*******************************Page Initialization*********************************************************
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
//**********************************Page Actions**************************************************************
	
	public void enterUsername(String username)
	{
		textUsername.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		textPassword.sendKeys(password);
	}
	
	public void clicklogin()
	{
		buttonLogin.click();
	}
	
	public String verifyErrorMessage()
	{
		return textLoginErrorMessage.getText();
	}
	
}
