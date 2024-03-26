package com.qapropsoft.carina.demo;

import java.io.File;
import java.io.IOException;
import com.qapropsoft.carina.demo.gui.pages.common.ParkarContactUsPageBase;
import com.qapropsoft.carina.demo.gui.pages.desktop.HomePage;
import com.qapropsoft.carina.demo.gui.pages.desktop.ParkarContactUsPage;
import com.qapropsoft.carina.demo.gui.pages.desktop.ParkarHomePage;
import com.zebrunner.carina.webdriver.IDriverPool;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class ParkarContactUsTest implements IDriverPool {
	ParkarHomePage parkarHomePage=new ParkarHomePage(getDriver());
	//HomePage homePage = new HomePage(getDriver());
	ParkarContactUsPage parkarContactUsPage=new ParkarContactUsPage(getDriver());
	ParkarContactUsPageBase parkarContactUsPageBase;


	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() throws IOException {
		// Open GSM Arena home page and verify page is opened
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		//scenario.attach(getByteScreenshot(), "image/png", scenario.getName());
		// Assert.assertTrue(homePage.isPageOpened(), "Home Page Opened");
//		throw new io.cucumber.java.PendingException();

	}


	@When("the user clicks on the Contact Us page")
	public void the_user_clicks_on_the_contact_us_page() {
				parkarContactUsPageBase=parkarContactUsPage.openContactUsPage();

	//throw new io.cucumber.java.PendingException();
	}


	@When("the user enter the details")
	public void the_user_enter_the_details() {
		//ExtentTest test = extent.createTest("the user enter the details");
		// Write code here that turns the phrase above into concrete actions
		parkarContactUsPageBase=parkarContactUsPage.enterNameTxtOnContactUsPage();
		parkarContactUsPageBase=parkarContactUsPage.enterEmailTxtOnContactUsPage();
		parkarContactUsPageBase=parkarContactUsPage.enterPhoneTxtOnContactUsPage();
		parkarContactUsPageBase=parkarContactUsPage.enterMessageTxtOnContactUsPage();



//throw new io.cucumber.java.PendingException();
	}


	@Then("the user click on submit button")
	public void the_user_click_on_submit_button() {

		parkarContactUsPageBase=parkarContactUsPage.clickContactUsBtnOnContactUsPage();
		getDriver().close();


//throw new io.cucumber.java.PendingException();
	}


}
