//package Steps;
//
//import com.qapropsoft.carina.demo.gui.pages.common.ParkarContactUsPageBase;
//import com.qapropsoft.carina.demo.gui.pages.desktop.HomePage;
//import com.qapropsoft.carina.demo.gui.pages.desktop.ParkarContactUsPage;
//import com.qapropsoft.carina.demo.gui.pages.desktop.ParkarHomePage;
//import com.zebrunner.carina.webdriver.IDriverPool;
//
//import cucumber.api.PendingException;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import io.cucumber.junit.Cucumber;
//
//public class ParkarContactUsStep implements IDriverPool{
//	ParkarHomePage parkarHomePage=new ParkarHomePage(getDriver());
//	ParkarContactUsPage parkarContactUsPage=new ParkarContactUsPage(getDriver());
//	ParkarContactUsPageBase parkarContactUsPageBase;
//
//	@Given("^the user is on the homepage$")
//	public void the_user_is_on_the_homepage() throws Throwable {
//		 HomePage homePage = new HomePage(getDriver());
//	        homePage.open();
//	    throw new PendingException();
//	}
//
//	@When("^the user clicks on the Contact Us page$")
//	public void the_user_clicks_on_the_Contact_Us_page() throws Throwable {
//		parkarContactUsPageBase=parkarContactUsPage.openContactUsPage();
//	    throw new PendingException();
//	}
//
//	@When("^the user enter the details$")
//	public void the_user_enter_the_details() throws Throwable {
//		parkarContactUsPageBase=parkarContactUsPage.enterNameTxtOnContactUsPage();
//		parkarContactUsPageBase=parkarContactUsPage.enterEmailTxtOnContactUsPage();
//		parkarContactUsPageBase=parkarContactUsPage.enterPhoneTxtOnContactUsPage();
//		parkarContactUsPageBase=parkarContactUsPage.enterMessageTxtOnContactUsPage();
//	    throw new PendingException();
//	}
//
//	@Then("^the user click on submit button$")
//	public void the_user_click_on_submit_button() throws Throwable {
//		parkarContactUsPageBase=parkarContactUsPage.clickContactUsBtnOnContactUsPage();
//	 getDriver().close();
//	    throw new PendingException();
//	}
//
//
//}
