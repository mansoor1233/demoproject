package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Customer {

	public WebDriver ldriver;

	public Customer(WebDriver rdriver) {

		ldriver = rdriver;

		PageFactory.initElements(ldriver, this);

	}

	By lnkcustomer_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')] "); // Customers

	By Sulnkcustomer_menu = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");

	By Addnewbutton = By.xpath("//a[@class='btn btn-primary']"); // Add new

	By txtemail = By.xpath("//input[@id='Email']"); // Email

	By txtpassword = By.xpath("//input[@id='Password']"); // password
	By Firstname = By.xpath("//input[@id='FirstName']"); // Firstname

	By Lastname = By.xpath("//input[@id='LastName']"); // Lastname

	By Gender_male = By.xpath("//input[@id='Gender_Male']"); // Male

	By Gender_female = By.xpath("//input[@id='Gender_Female']"); // Male

	By DOB = By.xpath("//input[@id='DateOfBirth']");// Dateofbirth

	By Company = By.xpath("//input[@id='Company']");// Company

	// By tax = By.xpath("//input[@id='IsTaxExempt']");// tax

	/*
	 * By Newletter = By
	 * .xpath("//select[@id='SelectedNewsletterSubscriptionStoreIds']//option[contains(text(),'Test store 2')]"
	 * );// Newletter
	 */
	By txtcustomerroles = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");

	By listitemAdministrators = By.xpath("//li[contains(text(),'Administrators')]");
	By listitemForumModerators = By.xpath("//li[contains(text(),'Forum Moderators')]");
	By listitemGuest = By.xpath("//li[contains(text(),'Guests')]");
	By listitemRegistered = By.xpath("//li[contains(text(),'Registered')]");
	By listitemVendors = By.xpath("//li[contains(text(),'Vendors')]");

	// By customerrole =
	// By.xpath("//select[@id='SelectedCustomerRoleIds']//option[contains(text(),'Guests')]");
	// //Customerroles

	By vendor = By.xpath("//*[@id='VendorId']");

	By admincontent = By.xpath("//textarea[@id='AdminComment']");// admincomment

	By btnsave = By.xpath("//button[@name='save']");

	// Action methods

	public String getPageTitle() {
		return ldriver.getTitle();
	}

	public void Clickoncustomermenu() {
		ldriver.findElement(lnkcustomer_menu).click();

	}

	public void Clickonsubcustomermenu() {
		ldriver.findElement(Sulnkcustomer_menu).click();

	}

	public void ClickAddnew() {
		ldriver.findElement(Addnewbutton).click();

	}

	public void setemail(String email) {
		ldriver.findElement(txtemail).sendKeys(email);

	}

	public void setpassword(String password) {
		ldriver.findElement(txtpassword).sendKeys(password);

	}

	public void setcustomerroles(String role) 
	{

		if (!role.equals("Vendors")) {
			ldriver.findElement(
					By.xpath("//div[@class='input-group']//div//select[@id='SelectedCustomerRoleIds']//option"));

		}
		ldriver.findElement(txtcustomerroles).click();
		
		WebElement listitem;
	
	 if(role.equals("administrators"))
	{
	listitem =ldriver.findElement(listitemAdministrators);
	}
	else if(role.equals("Guests"))
	{
	listitem=ldriver.findElement(listitemGuest);
	}
	else if(role.equals("registered"))
	{
	listitem=ldriver.findElement(listitemRegistered);
	} else if(role.equals("vendors"))
	{
	listitem=ldriver.findElement(listitemVendors);
	}
	else if(role.equals("forum moderators"))
	{
	listitem=ldriver.findElement(listitemForumModerators);
	}else
	{
		listitem=ldriver.findElement(listitemGuest);
	}
	listitem.click();

	JavascriptExecutor js = (JavascriptExecutor)ldriver;
	js.executeScript("arguments[0].click();", listitem);
	}
	public void setmanagerofvendor(String value)
	{
	Select drp = new Select(ldriver.findElement(vendor));
	drp.selectByVisibleText(value);
	}
	public void setgender(String gender) {
		if (gender.equals("Male")) {
			ldriver.findElement(Gender_male).click();
		} else if (gender.equals("Female")) {
			ldriver.findElement(Gender_female).click();

		} else {
			ldriver.findElement(Gender_male).click();
		}

	} 

	public void setfirstname(String fname) {
		ldriver.findElement(Firstname).sendKeys(fname);

	}

	public void setlastname(String lname) {
		ldriver.findElement(Lastname).sendKeys(lname);

	}

	public void setdob(String dob) {
		ldriver.findElement(DOB).sendKeys(dob);

	}

	public void setcompany(String company) {
		ldriver.findElement(Company).sendKeys(company);

	}

	public void setadmincontent(String comment) {

		ldriver.findElement(admincontent).sendKeys(comment);
	}

	public void setsave() {
		ldriver.findElement(btnsave).click();
	}

}
