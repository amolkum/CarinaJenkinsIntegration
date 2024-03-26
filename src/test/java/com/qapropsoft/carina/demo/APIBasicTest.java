package com.qapropsoft.carina.demo;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.RestAssured.responseSpecification;

import java.io.File;
import java.io.IOException;


import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APIBasicTest {

	public Response response;
	public Scenario scenario;
	long petID;


	
	@Given("Get the API Base URI")
	public void get_the_api_base_uri() throws IOException {
		System.out.println("Commaon steps");
		RequestSpecBuilder requestSpec = new RequestSpecBuilder();
		requestSpec.setBaseUri("https://petstore.swagger.io");
		requestSpec.setContentType(ContentType.JSON);
		requestSpec.log(LogDetail.ALL);
		requestSpec.addHeader("accept", "application/json");
		requestSpecification = requestSpec.build();

		ResponseSpecBuilder responseSpec = new ResponseSpecBuilder();
		responseSpec.expectStatusCode(200);
		responseSpec.expectContentType(ContentType.JSON);
		responseSpec.log(LogDetail.ALL);
		responseSpecification = responseSpec.build();



		
	}

	@Given("Get call to url test the API")
	public void get_call_to_https_reqres_in_api_users_page() throws IOException {
		// baseURI = "https://reqres.in/api";
		Response response = given().spec(requestSpecification)
				.expect()
				.spec(responseSpecification)
				.when()
				.get("/v2/pet/findByStatus?status=pending");


	}

	@Then("Response code is storing PostPet")
	public void response_code_is() throws IOException {

		// given().get("/users?page=2").then().statusCode(200).log().all();
		System.out.println("-------------Test 2 Post pet ------------");
		//String payload = "id":0;etc
		
		Response response = given().spec(requestSpecification)
				.header("accept", "application/json")
				.body(new File("C:\\Users\\amol.kumbhare\\Downloads\\carina-Extent\\carina-Extent\\payload.json"))
				.expect()
				.spec(responseSpecification)
				.when().post("/v2/pet");
		//System.out.println(response.asPrettyString());
		petID = response.path("id");
		System.out.println(petID);
	System.out.println("2------------------------end");

	}

	@And("Update pet details PutPet")
	public void update_pet_details_put_pet() throws IOException {
		System.out.println("-------------Test 3 put pet ------------");

		String jsonBody = "{"
				+ "  \"id\": "+petID+","
				+ "  \"category\": {"
				+ "    \"id\": 0,"
				+ "    \"name\": \"updated string\""
				+ "  },"
				+ "  \"name\": \"doggie name updated\","
				+ "  \"photoUrls\": ["
				+ "    \"string\""
				+ "  ],"
				+ "  \"tags\": ["
				+ "    {"
				+ "      \"id\": 0,"
				+ "      \"name\": \"string updated\""
				+ "    }"
				+ "  ],"
				+ "  \"status\": \"sold\""
				+ "}";
		Response response = given()
				.spec(requestSpecification)
				.header("accept", "application/json")
				
				.body(jsonBody)
				.expect()
				.spec(responseSpecification)
				.when().put("/v2/pet/");


		System.out.println("3rd -------------------------end");
		
	}

	@And("Update pet details PostUpdate")
	public void update_pet_details_post_update() throws IOException {
		System.out.println("----------postUpdate---------");
		Response response = given()
				.spec(requestSpecification)
				.header("Content-Type","application/x-www-form-urlencoded")
				.formParam("name", "DogUpdated")
				.formParam("status", "sold")
				.expect()
				.spec(responseSpecification)
				.when()
				.post("/v2/pet/"+petID);
				//.patch 
		System.out.println("4th -------------------end");
	}

	@Then("Delete the pet DeletePet")
	public void delete_the_pet_delete_pet() throws IOException {
		System.out.println("---------Delete---------------");
		Response response = given()
				.spec(requestSpecification)
				.expect()
				.spec(responseSpecification)
				.when()
				.delete("/v2/pet/"+petID);



		System.out.println("5th ---------------------end");
	}
}
