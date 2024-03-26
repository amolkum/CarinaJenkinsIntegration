//package Steps;
//
//import static io.restassured.RestAssured.given;
//import static io.restassured.RestAssured.requestSpecification;
//import static io.restassured.RestAssured.responseSpecification;
//
//import java.io.File;
//
//
//
//import io.cucumber.java.Scenario;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.builder.ResponseSpecBuilder;
//import io.restassured.filter.log.LogDetail;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//
//public class APIBasic {
//	public Response response;
//	public Scenario scenario;
//	long petID;
//	@Given("^Get the API Base URI$")
//	public void get_the_API_Base_URI() throws Throwable {
//		System.out.println("Commaon steps");
//		RequestSpecBuilder requestSpec = new RequestSpecBuilder();
//		requestSpec.setBaseUri("https://petstore.swagger.io");
//		requestSpec.setContentType(ContentType.JSON);
//		requestSpec.log(LogDetail.ALL);
//		requestSpec.addHeader("accept", "application/json");
//		requestSpecification = requestSpec.build();
//
//		ResponseSpecBuilder responseSpec = new ResponseSpecBuilder();
//		responseSpec.expectStatusCode(200);
//		responseSpec.expectContentType(ContentType.JSON);
//		responseSpec.log(LogDetail.ALL);
//		responseSpecification = responseSpec.build();
//
//
//	}
//
//	@Given("^Get call to url test the API$")
//	public void get_call_to_url_test_the_API() throws Throwable {
//		Response response = given().spec(requestSpecification)
//				.expect()
//				.spec(responseSpecification)
//				.when()
//				.get("/v2/pet/findByStatus?status=pending");
//	}
//
//	@When("^Response code is storing PostPet$")
//	public void response_code_is_storing_PostPet() throws Throwable {
//		Response response = given().spec(requestSpecification)
//				.header("accept", "application/json")
//				.body(new File("./payload.json"))
//				.expect()
//				.spec(responseSpecification)
//				.when().post("/v2/pet");
//		//System.out.println(response.asPrettyString());
//		petID = response.path("id");
//		System.out.println(petID);
//	}
//
//	@When("^Update pet details PutPet$")
//	public void update_pet_details_PutPet() throws Throwable {
//		String jsonBody = "{"
//				+ "  \"id\": "+petID+","
//				+ "  \"category\": {"
//				+ "    \"id\": 0,"
//				+ "    \"name\": \"updated string\""
//				+ "  },"
//				+ "  \"name\": \"doggie name updated\","
//				+ "  \"photoUrls\": ["
//				+ "    \"string\""
//				+ "  ],"
//				+ "  \"tags\": ["
//				+ "    {"
//				+ "      \"id\": 0,"
//				+ "      \"name\": \"string updated\""
//				+ "    }"
//				+ "  ],"
//				+ "  \"status\": \"sold\""
//				+ "}";
//		Response response = given()
//				.spec(requestSpecification)
//				.header("accept", "application/json")
//
//				.body(jsonBody)
//				.expect()
//				.spec(responseSpecification)
//				.when().put("/v2/pet/");
//
//	}
//
//	@When("^Update pet details PostUpdate$")
//	public void update_pet_details_PostUpdate() throws Throwable {
//		Response response = given()
//				.spec(requestSpecification)
//				.header("Content-Type","application/x-www-form-urlencoded")
//				.formParam("name", "DogUpdated")
//				.formParam("status", "sold")
//				.expect()
//				.spec(responseSpecification)
//				.when()
//				.post("/v2/pet/"+petID);
//	}
//
//	@Then("^Delete the pet DeletePet$")
//	public void delete_the_pet_DeletePet() throws Throwable {
//		System.out.println("---------Delete---------------");
//		Response response = given()
//				.spec(requestSpecification)
//				.expect()
//				.spec(responseSpecification)
//				.when()
//				.delete("/v2/pet/"+petID);
//		//System.out.println(response.asPrettyString());
//        //ExtentTest test = extent.createTest("Delete the pet DeletePet");
////		test.log(Status.PASS, "Test case passed - Delete the pet DeletePet");
////		test.pass("verified Delete the pet DeletePet");
//
//		System.out.println("5th ---------------------end");
//	}
//
//}
