package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = ".//Feature/Customer.feature", 
		glue = "Stepdefinition",
		dryRun = false,
		plugin = {"html:target/cucumber_html_Report.html", "pretty" },
		monochrome = true,
		tags ="@4"
		
)

public class TestRunner {  

}
