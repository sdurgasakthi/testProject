package com.tests;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;



import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestCase2 {
	

	
	@Test(priority=1)
	public void ValidatePost() throws FileNotFoundException {
		
		File f= new File(".//body.json");

		//now read the data from file

		FileReader fr= new FileReader(f);

		//to get json format data 

		JSONTokener jt= new JSONTokener(fr);

		//using jt , extract the data in json format

		JSONObject data= new JSONObject(jt);
		
		Response res=	given()
		.contentType(ContentType.JSON)
		.urlEncodingEnabled(false)
		 .body(data.toString()) 
		.when()
		 .post("https://6143a99bc5b553001717d06a.mockapi.io/testapi/v1//Users");
		
		AssertJUnit.assertEquals(res.getStatusCode(), 201); 
		
		String employee_Firstname=res.jsonPath().get("employee_firstname").toString();
		
		String phone_number=res.jsonPath().get("employee_phonenumbe").toString();
		
		String email=res.jsonPath().get("ademployee_emaildress").toString();
		
		String id= res.jsonPath().get("id").toString();
		
		System.out.println("Profile is created with ID: "+id);
		
		AssertJUnit.assertEquals(employee_Firstname, "TestData12345");
		
		AssertJUnit.assertEquals(phone_number, "264-783-9453");
		
		AssertJUnit.assertEquals(email, "ademployee_emaildress 1");
	
		

		
	}
	
	
	@Test(priority=2)
	public void validateGetCall() {
		
		Response res=	given()
				.contentType(ContentType.JSON)
				.urlEncodingEnabled(false)			
				.when()
				.get("https://6143a99bc5b553001717d06a.mockapi.io/testapi/v1//Users");
				
			AssertJUnit.assertEquals(res.getStatusCode(), 200);
			
			AssertJUnit.assertEquals(res.jsonPath().get("employee_firstname[1]").toString(), "employee_firstname 239");
			
			System.out.println(res.jsonPath().get("employee_firstname[1]").toString());

			AssertJUnit.assertEquals(res.jsonPath().get("employee_phonenumbe[9]").toString(), "264-783-9453");

	}

}
