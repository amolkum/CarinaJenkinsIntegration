package runnerClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\amol.kumbhare\\Downloads\\carina-Extent\\carina-Extent\\src\\test\\resources\\features",
		glue= {"com.qapropsoft.carina.demo"},
		plugin = { "html:target/CucumberReports/Cucumber.html",
		 "json:target/CucumberReports1/Cucumber.json",
		"json:target/cucumber-report.json",
		//"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports2/report.html"},
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true,
		publish = true
)

//@Listeners({ExtentITestListenerClassAdapter.class})
//@Listeners({ListenersExtent.class})
public class TestRunner extends AbstractTestNGCucumberTests {
//extends AbstractTestNGCucumberTests

}