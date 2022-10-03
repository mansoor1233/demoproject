package Pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

	public WebDriver ldriver;
	  

	@SuppressWarnings("deprecation")
	public SearchCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	
		ldriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@FindBy(how = How.XPATH, using = "//i[@class='far fa-angle-down']")
	@CacheLookup
	WebElement Drpdown; 

	@FindBy(how = How.ID, using = "SearchEmail")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(how = How.ID, using = "SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;

	@FindBy(how = How.XPATH, using = "//input[@id='SearchLastName']")
	@CacheLookup
	WebElement txtlastName;

	@FindBy(how = How.ID, using = "SearchMonthOfBirth")
	@CacheLookup
	WebElement DateOfMonth;

	@FindBy(how = How.ID, using = "SearchDayOfBirth")
	@CacheLookup
	WebElement DateOfBirth;

	@FindBy(how = How.ID, using = "SearchCompany")
	@CacheLookup
	WebElement Company;

	@FindBy(how = How.ID, using = "SearchIpAddress")
	@CacheLookup
	WebElement Ipaddress;

	@FindBy(how = How.ID, using = "search-customers")
	@CacheLookup
	WebElement searchbtn;

	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;

	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody//tr")
	List<WebElement> tablerows;

	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody//tr//td")
	List<WebElement> tablecolumns;

	public void dropdown() throws InterruptedException {
		Thread.sleep(3000);
		Drpdown.click();

	}

	public void setemail(String email) throws InterruptedException {
		Thread.sleep(2000);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void setfirstname(String fname) throws InterruptedException {
		Thread.sleep(2000);
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
	}

	public void setlastname(String lname) throws InterruptedException {
		Thread.sleep(2000);
		txtlastName.clear();
		txtlastName.sendKeys(lname);
	}

	public void Clicksearch() throws InterruptedException {
		searchbtn.click();
		Thread.sleep(2000);
	}

	public int getNoOfrows() {
		return (tablerows.size());

	}

	public int getNoOfcolumn() {
		return (tablecolumns.size());

	}

	public boolean SearchCustomerbyEmail(String email) {

		boolean flag = false;

		for (int i = 1; i <= getNoOfrows(); i++) {

			String emailid = table.findElement(By.xpath("//table[@id='customers-grid']//tbody//tr[" + i + "]//td[2]"))
					.getText();

			System.out.println(emailid);

			if (emailid.equals(email))
			{
				flag = true;
			}

		}
		return flag;

 }

	public boolean SearchCustomerbyname(String Name) {

		boolean flag = false; 

		for (int i = 1; i <= getNoOfrows(); i++) {

			String name1 = table.findElement(By.xpath("//table[@id='customers-grid']//tbody//tr[" + i + "]//td[3]"))
					.getText();

			String names[] = name1.split("");

			if (names[0].equals("Team") && names[1].equals("Test")) 
			{

				flag = true;
			}

		}
		return flag;

	}
}
