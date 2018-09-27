package Runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\venkata.addala\\workspace\\RestAssuredBDDFrameworkCucumber\\src\\main\\java\\features", //path of features files
		glue="stepDefinition", //path of step definition
		format={"pretty","html:test-output", "json:json_output/cucumber.json","junit:junit_xml/cucumber.xml"}, 
		dryRun=false, //it will check proper mapping between feature file and step definition.
		monochrome=true, //display output in a readable format
		strict=true, //it will check any step is not defined in the step definition file
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},
		tags={"@FunctionalTest,@smokeTest"} //it will run only the features mentioned in the tags with tag name
		)
public class TestRunner {
	@AfterClass
    public static void teardown() {
        Reporter.loadXMLConfig(new File("src/test/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Windows");
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }
}
