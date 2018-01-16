package com.vainolo.examples.javahttpapiclient;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Enumeration;

public class Okta_JavaHTTPAPIClient {
//	static String accept = "Accept" + " , " + "application/json";
//	static String contentType = "Content-Type" + " , " + "application/json";
//	static String authorization = "Authorization" + " , " + "SSWS 00bvhwILAKvSLwFmFuKNZDVTorU4ukDHsulIfKzjLb";
//	static String cacheControl = "Cache-Control" + " , " + "no-cache";
	
//	private static void someMethod(int value) {
//        System.out.println(.header("Accept", "application/json")
//				  .header("Content-Type", "application/json")
//				  .header("Authorization", "SSWS 00bvhwILAKvSLwFmFuKNZDVTorU4ukDHsulIfKzjLb")
//				  .header("Cache-Control", "no-cache"));
//    }
	
	// Creates unactivated user with password, recovery question, and any other desired fields
	public static void createUnactivatedUsersWithPassAndRecQ(Dictionary profile, String password, String question, String answer) throws Exception
	{
		String bodyText = "{\n  \"profile\": {\n ";
		for (Enumeration i = profile.keys(); i.hasMoreElements();)
		{
			Object key = i.nextElement();
			bodyText += "\"" + key + "\": \"" + profile.get(key) + "\",";
		}
		bodyText = bodyText.substring(0,bodyText.length()-1) + "}, \"credentials\": {\n    \"password\" : { \"value\": \"" + password + "\" }, \n    \"recovery_question\": {\n      \"question\": \"" + question + "\",\n      \"answer\": \"" + answer + "\"} } }";
		HttpResponse<String> response = Unirest.post("https://dev-106499.oktapreview.com/api/v1/users?activate=false")
				  .header("Accept", "application/json")
				  .header("Content-Type", "application/json")
				  .header("Authorization", "SSWS 00bvhwILAKvSLwFmFuKNZDVTorU4ukDHsulIfKzjLb")
				  .header("Cache-Control", "no-cache")
				  .body(bodyText)//"{\n  \"profile\": {\n "    \"firstName\": \"Brandon2\",\n    \"lastName\": \"Brock2\",\n    \"email\": \"brandon2@gmail.com\",\n    \"login\": \"brandon2@gmail.com\",\n		\"managerId\": \"123456\",\n 	\"manager\": \"Tom Brady\"\n  },\n  \"credentials\": {\n    \"password\" : { \"value\": \"PB23@ssword45\" },\n    \"recovery_question\": {\n      \"question\": \"Who's a major player in the cowboy scene?\",\n      \"answer\": \"Annie Oakley\"\n    }\n  }\n}")
				  .asString();
		System.out.println(response.getBody());
	}
	
	
	// Creates activated user with password, recovery question, and any other desired fields
	public static void createActivatedUsersWithPassAndRecQ(Dictionary profile, String password, String question, String answer) throws Exception
	{
		String bodyText = "{\n  \"profile\": {\n ";
		for (Enumeration i = profile.keys(); i.hasMoreElements();)
		{
			Object key = i.nextElement();
			bodyText += "\"" + key + "\": \"" + profile.get(key) + "\",";
		}
		bodyText = bodyText.substring(0,bodyText.length()-1) + "}, \"credentials\": {\n    \"password\" : { \"value\": \"" + password + "\" }, \n    \"recovery_question\": {\n      \"question\": \"" + question + "\",\n      \"answer\": \"" + answer + "\"} } }";
		HttpResponse<String> response = Unirest.post("https://dev-106499.oktapreview.com/api/v1/users?activate=true")
				  .header("Accept", "application/json")
				  .header("Content-Type", "application/json")
				  .header("Authorization", "SSWS 00bvhwILAKvSLwFmFuKNZDVTorU4ukDHsulIfKzjLb")
				  .header("Cache-Control", "no-cache")
				  .body(bodyText)//"{\n  \"profile\": {\n "    \"firstName\": \"Brandon2\",\n    \"lastName\": \"Brock2\",\n    \"email\": \"brandon2@gmail.com\",\n    \"login\": \"brandon2@gmail.com\",\n		\"managerId\": \"123456\",\n 	\"manager\": \"Tom Brady\"\n  },\n  \"credentials\": {\n    \"password\" : { \"value\": \"PB23@ssword45\" },\n    \"recovery_question\": {\n      \"question\": \"Who's a major player in the cowboy scene?\",\n      \"answer\": \"Annie Oakley\"\n    }\n  }\n}")
				  .asString();
		System.out.println(response.getBody());
	}
	
	// Creates unactivated user without credentials (i.e. password, recovery question)
	public static void createUnactivatedUsersWithoutCreds(Dictionary profile) throws Exception
	{
		String bodyText = "{\n  \"profile\": {\n ";
		for (Enumeration i = profile.keys(); i.hasMoreElements();)
		{
			Object key = i.nextElement();
			bodyText += "\"" + key + "\": \"" + profile.get(key) + "\",";
		}
		bodyText = bodyText.substring(0,bodyText.length()-1) + "} } } ";
		HttpResponse<String> response = Unirest.post("https://dev-106499.oktapreview.com/api/v1/users?activate=false")
				  .header("Accept", "application/json")
				  .header("Content-Type", "application/json")
				  .header("Authorization", "SSWS 00bvhwILAKvSLwFmFuKNZDVTorU4ukDHsulIfKzjLb")
				  .header("Cache-Control", "no-cache")
				  .body(bodyText)//"{\n  \"profile\": {\n "    \"firstName\": \"Brandon2\",\n    \"lastName\": \"Brock2\",\n    \"email\": \"brandon2@gmail.com\",\n    \"login\": \"brandon2@gmail.com\",\n		\"managerId\": \"123456\",\n 	\"manager\": \"Tom Brady\"\n  },\n  \"credentials\": {\n    \"password\" : { \"value\": \"PB23@ssword45\" },\n    \"recovery_question\": {\n      \"question\": \"Who's a major player in the cowboy scene?\",\n      \"answer\": \"Annie Oakley\"\n    }\n  }\n}")
				  .asString();
		System.out.println(response.getBody());
	}
	
	// Creates activated user without credentials (i.e. password, recovery question)
	public static void createActivatedUsersWithoutCreds(Dictionary profile) throws Exception
	{
		String bodyText = "{\n  \"profile\": {\n ";
		for (Enumeration i = profile.keys(); i.hasMoreElements();)
		{
			Object key = i.nextElement();
			bodyText += "\"" + key + "\": \"" + profile.get(key) + "\",";
		}
		bodyText = bodyText.substring(0,bodyText.length()-1) + "} } } ";
		HttpResponse<String> response = Unirest.post("https://dev-106499.oktapreview.com/api/v1/users?activate=true")
				  .header("Accept", "application/json")
				  .header("Content-Type", "application/json")
				  .header("Authorization", "SSWS 00bvhwILAKvSLwFmFuKNZDVTorU4ukDHsulIfKzjLb")
				  .header("Cache-Control", "no-cache")
				  .body(bodyText)//"{\n  \"profile\": {\n "    \"firstName\": \"Brandon2\",\n    \"lastName\": \"Brock2\",\n    \"email\": \"brandon2@gmail.com\",\n    \"login\": \"brandon2@gmail.com\",\n		\"managerId\": \"123456\",\n 	\"manager\": \"Tom Brady\"\n  },\n  \"credentials\": {\n    \"password\" : { \"value\": \"PB23@ssword45\" },\n    \"recovery_question\": {\n      \"question\": \"Who's a major player in the cowboy scene?\",\n      \"answer\": \"Annie Oakley\"\n    }\n  }\n}")
				  .asString();
		System.out.println(response.getBody());
	}
	
	// Creates unactivated user with password and any other desired fields.
		public static void createUnactivatedUsersWithPass(Dictionary profile, String password) throws Exception
		{
			String bodyText = "{\n  \"profile\": {\n ";
			for (Enumeration i = profile.keys(); i.hasMoreElements();)
			{
				Object key = i.nextElement();
				bodyText += "\"" + key + "\": \"" + profile.get(key) + "\",";
			}
			bodyText = bodyText.substring(0,bodyText.length()-1) + "}, \"credentials\": {\n    \"password\" : { \"value\": \"" + password + "\" } } } ";
			HttpResponse<String> response = Unirest.post("https://dev-106499.oktapreview.com/api/v1/users?activate=false")
					  .header("Accept", "application/json")
					  .header("Content-Type", "application/json")
					  .header("Authorization", "SSWS 00bvhwILAKvSLwFmFuKNZDVTorU4ukDHsulIfKzjLb")
					  .header("Cache-Control", "no-cache")
					  .body(bodyText)
					  .asString();
			System.out.println(response.getBody());
		}
		
		
		// Creates activated user with password and any other desired fields.
		public static void createActivatedUsersWithPass(Dictionary profile, String password) throws Exception
		{
			String bodyText = "{\n  \"profile\": {\n ";
			for (Enumeration i = profile.keys(); i.hasMoreElements();)
			{
				Object key = i.nextElement();
				bodyText += "\"" + key + "\": \"" + profile.get(key) + "\",";
			}
			bodyText = bodyText.substring(0,bodyText.length()-1) + "}, \"credentials\": {\n    \"password\" : { \"value\": \"" + password + "\" } } } ";
			HttpResponse<String> response = Unirest.post("https://dev-106499.oktapreview.com/api/v1/users?activate=true")
					  .header("Accept", "application/json")
					  .header("Content-Type", "application/json")
					  .header("Authorization", "SSWS 00bvhwILAKvSLwFmFuKNZDVTorU4ukDHsulIfKzjLb")
					  .header("Cache-Control", "no-cache")
					  .body(bodyText)
					  .asString();
			System.out.println(response.getBody());
		}
		
		// Creates unactivated user with security question and any other desired fields.
		public static void createUnactivatedUsersWithRecQ(Dictionary profile, String question, String answer) throws Exception
		{
			String bodyText = "{\n  \"profile\": {\n ";
			for (Enumeration i = profile.keys(); i.hasMoreElements();)
			{
				Object key = i.nextElement();
				bodyText += "\"" + key + "\": \"" + profile.get(key) + "\",";
			}
			bodyText = bodyText.substring(0,bodyText.length()-1) + "}, \"credentials\": {\n    \"recovery_question\": {\n      \"question\": \"" + question + "\",\n      \"answer\": \"" + answer + "\"} } } ";
			HttpResponse<String> response = Unirest.post("https://dev-106499.oktapreview.com/api/v1/users?activate=false")
					  .header("Accept", "application/json")
					  .header("Content-Type", "application/json")
					  .header("Authorization", "SSWS 00bvhwILAKvSLwFmFuKNZDVTorU4ukDHsulIfKzjLb")
					  .header("Cache-Control", "no-cache")
					  .body(bodyText)
					  .asString();
			System.out.println(response.getBody());
		}
		
		// Creates activated user with recovery question and any other desired fields
		public static void createActivatedUsersWithRecQ(Dictionary profile, String question, String answer) throws Exception
		{
			String bodyText = "{\n  \"profile\": {\n ";
			for (Enumeration i = profile.keys(); i.hasMoreElements();)
			{
				Object key = i.nextElement();
				bodyText += "\"" + key + "\": \"" + profile.get(key) + "\",";
			}
			bodyText = bodyText.substring(0,bodyText.length()-1) + "}, \"credentials\": {\n    \"recovery_question\": {\n      \"question\": \"" + question + "\",\n      \"answer\": \"" + answer + "\"} } }";
			HttpResponse<String> response = Unirest.post("https://dev-106499.oktapreview.com/api/v1/users?activate=true")
					  .header("Accept", "application/json")
					  .header("Content-Type", "application/json")
					  .header("Authorization", "SSWS 00bvhwILAKvSLwFmFuKNZDVTorU4ukDHsulIfKzjLb")
					  .header("Cache-Control", "no-cache")
					  .body(bodyText)//"{\n  \"profile\": {\n "    \"firstName\": \"Brandon2\",\n    \"lastName\": \"Brock2\",\n    \"email\": \"brandon2@gmail.com\",\n    \"login\": \"brandon2@gmail.com\",\n		\"managerId\": \"123456\",\n 	\"manager\": \"Tom Brady\"\n  },\n  \"credentials\": {\n    \"password\" : { \"value\": \"PB23@ssword45\" },\n    \"recovery_question\": {\n      \"question\": \"Who's a major player in the cowboy scene?\",\n      \"answer\": \"Annie Oakley\"\n    }\n  }\n}")
					  .asString();
			System.out.println(response.getBody());
		}
		
		// Creates unactivated user in a group and any other desired fields.
				public static void createUnactivatedUsersInGroup(Dictionary profile, String[] groupIDs) throws Exception
				{
					String bodyText = "{\n  \"profile\": {\n ";
					for (Enumeration i = profile.keys(); i.hasMoreElements();)
					{
						Object key = i.nextElement();
						bodyText += "\"" + key + "\": \"" + profile.get(key) + "\",";
					}
					String groupIDsStr = "";
					for (int i=0; i<groupIDs.length - 1; ++i)
					{
						groupIDsStr = "\"" + groupIDs[i] + "\", ";
					}
					groupIDsStr = "{" + groupIDs[groupIDs.length-1] + "}}";
					bodyText = bodyText.substring(0,bodyText.length()-1) + "}, \"credentials\": {\n     \"groupIds\": [\n    \"" + groupIDsStr + "\"\n    } } ";
					HttpResponse<String> response = Unirest.post("https://dev-106499.oktapreview.com/api/v1/users?activate=false")
							  .header("Accept", "application/json")
							  .header("Content-Type", "application/json")
							  .header("Authorization", "SSWS 00bvhwILAKvSLwFmFuKNZDVTorU4ukDHsulIfKzjLb")
							  .header("Cache-Control", "no-cache")
							  .body(bodyText)
							  .asString();
					System.out.println(response.getBody());
				}
				
				// Creates activated user in a group and any other desired fields
				public static void createActivatedUsersInGroup(Dictionary profile, String[] groupIDs) throws Exception
				{
					String bodyText = "{\n  \"profile\": {\n ";
					for (Enumeration i = profile.keys(); i.hasMoreElements();)
					{
						Object key = i.nextElement();
						bodyText += "\"" + key + "\": \"" + profile.get(key) + "\",";
					}
					String groupIDsStr = "";
					for (int i=0; i<groupIDs.length - 1; ++i)
					{
						groupIDsStr += " \"" + groupIDs[i] + "\" , ";
					}
					groupIDsStr += " \"" + groupIDs[groupIDs.length-1] + "\"";
					bodyText = bodyText.substring(0,bodyText.length()-1) + "\n}, \n    \"groupIds\": [\n    " + groupIDsStr + "\n  ] \n}";
					
					System.out.println(bodyText);
					
					HttpResponse<String> response = Unirest.post("https://dev-106499.oktapreview.com/api/v1/users?activate=true")
							  .header("Accept", "application/json")
							  .header("Content-Type", "application/json")
							  .header("Authorization", "SSWS 00bvhwILAKvSLwFmFuKNZDVTorU4ukDHsulIfKzjLb")
							  .header("Cache-Control", "no-cache")
							  .body(bodyText)
							  .asString();
					System.out.println(response.getBody());
				}
}

