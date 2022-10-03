package Stepdefinition;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import Pageobjects.Customer;
import Pageobjects.PageElement;
import Pageobjects.SearchCustomerPage;

public class Baseclass {
	
	public WebDriver driver;
	public PageElement pe;
	public Customer addcustomer;
	public SearchCustomerPage searchcust;
	
	
	
	public static String ramdomestring() {
		String generatedString1=RandomStringUtils.randomAlphabetic(5);
		return(generatedString1);
		
	}

}
