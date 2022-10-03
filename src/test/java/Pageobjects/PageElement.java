package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageElement {

	public WebDriver Idriver;

	public PageElement(WebDriver rdriver) {
		Idriver = rdriver;
		PageFactory.initElements(rdriver, this);
	} 

	@FindBy(xpath = "// input[@id='Email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement txtPassword;

	@FindBy(xpath = "// button[@type='submit']")
	WebElement submitbtn;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logoutbtn;

	public void setusername(String uname) {
		txtEmail.clear();
		txtEmail.sendKeys(uname);

	}

	public void setpassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);

	}

	public void loginsubmit() throws InterruptedException {
		submitbtn.click();
		Thread.sleep(3000);

	}

	public void logout() {
		logoutbtn.click();

	}
}
