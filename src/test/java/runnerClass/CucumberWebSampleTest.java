package runnerClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions
        (features = "src/test/resources/features",
                glue = "com.qapropsoft.carina.demo",
                monochrome = true,  //Proper formatting in console
                dryRun = false,		//Verify connections and flow
strict = true,		//To supress warnings from cucumber
                plugin = {"pretty",

//"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports1/report.html"
                }

        )

//@Listeners({ExtentITestListenerClassAdapter.class})
//@Listeners({ListenersExtent.class})
public class CucumberWebSampleTest extends AbstractTestNGCucumberTests {

}