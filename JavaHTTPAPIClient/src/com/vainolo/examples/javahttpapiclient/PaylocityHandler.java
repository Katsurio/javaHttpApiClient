package com.vainolo.examples.javahttpapiclient;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import java.util.Dictionary;
import java.util.Hashtable;

public class PaylocityHandler {
	
	public static void main(String[] args) throws Exception {
		Dictionary<String, String> profile = new Hashtable();
		
		profile.put("firstName", "Jubbs2");
		profile.put("lastName", "McGee");
		profile.put("email", "jubbs2@gmail.com");
		profile.put("login", "jubbs2@gmail.com");
		profile.put("title", "Batman");
		profile.put("managerId", "654321");
		profile.put("manager", "Commisioner Gordan");
		profile.put("zenefitsId", "7654322");
		
		String password = "P12@ssword";
		String question = "How many licks does it take to get to the center of a Tootsie Pop?";
		String answer = "Three";
		String[] groupIDs = {"00gdnbrfymLI74ZMR0h7"};
				
		//Okta_JavaHTTPAPIClient client = new Okta_JavaHTTPAPIClient();
		Okta_JavaHTTPAPIClient.createActivatedUsersWithPassAndRecQ(profile, password, question, answer);
		
		
		/* These are for testing purposes
		Okta_JavaHTTPAPIClient.createUnactivatedUsersWithPassAndRecQ(profile, password, question, answer);
		Okta_JavaHTTPAPIClient.createActivatedUsersWithPassAndRecQ(profile, password, question, answer);
		Okta_JavaHTTPAPIClient.createUnactivatedUsersWithoutCreds(profile);
		Okta_JavaHTTPAPIClient.createActivatedUsersWithoutCreds(profile);
		Okta_JavaHTTPAPIClient.createUnactivatedUsersWithPass(profile, password);
		Okta_JavaHTTPAPIClient.createActivatedUsersWithPass(profile, password);
		Okta_JavaHTTPAPIClient.createActivatedUsersInGroup(profile, groupIDs);
		*/
	}
}

/*

{
  "profile": {
    "firstName": "Brandon",
    "lastName": "Brock",
    "email": "brandon@gmail.com",
    "login": "brandon@gmail.com"
  },
  "credentials": {
    "password": {
      "value": "PB23@ssword45"
    },
    "recovery_question": {
      "question": "Who's a major player in the cowboy scene?",
      "answer": "Annie Oakley"
    }
  }
}

*/