package com.vainolo.examples.javahttpapiclient;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class JavaHTTPAPIClient {
	
	public void getUsersUsingUnirest() throws Exception {
		HttpResponse<String> response = Unirest.get("https://dev-106499.oktapreview.com/api/v1/users/00ud9x003dTvaisuK0h7")
				  .header("accept", "application/json")
				  .header("content-type", "application/json")
				  .header("authorization", "SSWS 00bvhwILAKvSLwFmFuKNZDVTorU4ukDHsulIfKzjLb")
				  .header("cache-control", "no-cache")
				  .asString();
		System.out.println(response.getBody());
	}
	
	public void createUserUnirest() throws Exception {
		HttpResponse<String> response = Unirest.post("https://dev-106499.oktapreview.com/api/v1/users?activate=false")
				  .header("accept", "application/json")
				  .header("content-type", "application/json")
				  .header("authorization", "SSWS 00bvhwILAKvSLwFmFuKNZDVTorU4ukDHsulIfKzjLb")
				  .header("cache-control", "no-cache")
				  .body("{\n  \"profile\": {\n    \"firstName\": <<firstName>>,\n    \"lastName\": <<lastName>>,\n    \"email\": <<email>>,\n    \"login\": <<username>>,\n    \"title\": <<title>>,\n    \"managerId\": <<managerId>>,\n    \"manager\": <<manager>>,\n    \"zenefitsId\": <<zenefitsId>>\n  }\n}")
				  .asString();
	}
	public static void main(String args[]) throws Exception {
		JavaHTTPAPIClient client = new JavaHTTPAPIClient();
		client.getUsersUsingUnirest();
		
	}
}
