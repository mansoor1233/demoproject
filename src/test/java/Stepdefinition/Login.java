package Stepdefinition;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pageobjects.Customer;
import Pageobjects.PageElement;
import Pageobjects.SearchCustomerPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends Baseclass {

	@SuppressWarnings("deprecation")
	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		pe = new PageElement(driver);

	}

	@When("user opens url {string}")
	public void user_opens_url(String url) {
		driver.navigate().to(url);
	}

	@When("user enters email as  {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		pe.setusername(email);
		pe.setpassword(password);

	}

	@When("click on login")
	public void click_on_login() throws InterruptedException {
		pe.loginsubmit();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) {

		if (driver.getPageSource().contains("Login was successful")) {
			driver.close();
			Assert.assertTrue(false);
		} /*
			 * else { Assert.assertEquals(title, driver.getTitle()); }
			 */
	} 

	@When("user click on log out link")
	public void user_click_on_log_out_link() {
		pe.logout();
	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	}

	// Customer
	// steps-------------------------------//

	@Then("User should be at homepage")
	public void user_should_be_at_homepage() {

		addcustomer = new Customer(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addcustomer.getPageTitle());
	}

	@Then("User clicks on customers-Admin")
	public void user_clicks_on_customers_admin() throws InterruptedException {
		Thread.sleep(2000);
		addcustomer.Clickoncustomermenu();
	}

	@Then("Below customer accordian opens")
	public void below_customer_accordian_opens() {

	}

	@Then("User clicks on the Customers list")
	public void user_clicks_on_the_customers_list() throws InterruptedException {
		Thread.sleep(2000);
		addcustomer.Clickonsubcustomermenu();
	}

	@Then("User clicks on Add button")
	public void user_clicks_on_add_button() throws InterruptedException {
		Thread.sleep(2000);
		addcustomer.ClickAddnew();
	}

	@Then("User can see Add new customer page")
	public void user_can_see_add_new_customer_page() {

		Assert.assertEquals("Add a new customer / nopCommerce administration", addcustomer.getPageTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {

		String email = ramdomestring() + "@yahoo.com";
		addcustomer.setemail(email);
		addcustomer.setpassword("test1478");
		addcustomer.setfirstname("Hassan");
		addcustomer.setlastname("Mahamood");
		addcustomer.setgender("Male");
		addcustomer.setdob("2/11/1995");
		addcustomer.setcompany("Tammina");
		// addcustomer.setcustomerroles("Guests");
		// addcustomer.setmanagervendor("vendor 2");
		addcustomer.setadmincontent("First Framework design");

	}

	@When("Click on save button")
	public void click_on_save_button() throws InterruptedException {
		addcustomer.setsave();
		Thread.sleep(2000);
	}

	@Then("close the browser")
	public void close_the_browser() {

		driver.quit();
	}

	@Then("Page should display {string}")
	public void page_should_display(String msg) {

		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));
	}

	// Searching the customer using emailid

	@Then("Click on dropdown arrow")
	public void click_on_dropdown_arrow() {

	}

	@Then("Enters customer email")
	public void enters_customer_email() throws InterruptedException {
		Thread.sleep(5000);
		searchcust = new SearchCustomerPage(driver);
		searchcust.setemail("ayeshab@reddiff.com");

	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchcust.Clicksearch();
		Thread.sleep(2000);
	}

	@And("page is scroll down")
	public void page_is_scroll_down() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,350)", "");

	}

	@Then("User should found email in the search table")
	public void user_should_found_email_in_the_search_table() throws InterruptedException {
		Boolean status = searchcust.SearchCustomerbyEmail("ayeshab@reddiff.com");

		Assert.assertEquals(true, status);
	}

	// Searching by name

	@Then("Enter customer Firstname")
	public void enter_customer_firstname() throws InterruptedException {
		searchcust = new SearchCustomerPage(driver);
		searchcust.setfirstname("Team");
	}

	@Then("Enter customer Lastname")
	public void enter_customer_lastname() throws InterruptedException {
		searchcust = new SearchCustomerPage(driver);
		searchcust.setlastname("Test");
	}

	@Then("User should found name in the search table")
	public void user_should_found_name_in_the_search_table() throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,350)", "");

		Boolean status = searchcust.SearchCustomerbyname("Team Test");
		Assert.assertEquals(true, status);
	}
	
	
	@Then("User should fetch the Orderrecords table into excelfile")
	public void user_should_fetch_the_orderrecords_table_into_excelfile() throws InterruptedException {
		
		Thread.sleep(2000);
		pe =new PageElement(driver);
		
		
	}


}
