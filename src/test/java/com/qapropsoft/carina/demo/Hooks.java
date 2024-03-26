package com.qapropsoft.carina.demo;

import com.zebrunner.agent.core.registrar.Screenshot;
import com.zebrunner.carina.core.IAbstractTest;
//import com.zebrunner.carina.webdriver.Screenshot;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Hooks implements IAbstractTest {
    //Screenshot screenshot =new Screenshot();
    @Before
    public static void setUp() {

       // HelperClass.setUpDriver();
    }
//    @AfterStep
//    public void as(Scenario scenario) throws IOException, InterruptedException
//    {
//
//            File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
//            byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
//            scenario.attach(fileContent, "image/png", "screenshot");
////            final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
////            //byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
////            scenario.attach(screenshot, "image/png", scenario.getName());
//
//
//        //scenario.attach(getByteScreenshot(), "image/png", scenario.getName());
//    }
    @After
    public void tearDown(Scenario scenario) throws Exception {

        //File file = screenshot.getScreenshotAs(OutputType.FILE);

        if(scenario.isFailed()) {
//            File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
//            byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
//            scenario.attach(fileContent, "image/png", scenario.getName());
           // File file = screenshot.getScreenshotAs(OutputType.FILE);
            final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            System.out.println("The scenario name is :"+scenario.getName());
            getDriver().close();
        }
    }


}
