package com.Swag.Utilities;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class JiraUtilityCode {
	
	    private static final String JIRA_URL = "https://prasad34.atlassian.net";
	    private static final String JIRA_USERNAME = "bobbilihariprasad222@gmail.com";
	    private static final String JIRA_API_TOKEN = "ATATT3xFfGF0j1Y1lDlYe9jsuEOtm0cdJUMcPUhvmpN0VCwqbcxt3KZuEO3qxXz3nZdVPDKg2nuQRDk3GHqEHUpld_HoqttQqRwUs22u7BiNHuAdM0CYQWa_3XQ3vTYibyFb0J7HuXMCqmrE2Ov3ZiNiLbAt-kD6N5lscbLhRFyjNFRziZ4Di_I=120752F5";
	    private static final String JIRA_PROJECT_KEY = "TEL";
	    private static final String JIRA_ISSUE_TYPE = "Bug";

	    public static void createJiraIssue(String summary, String description) {
	        JSONObject issueDetails = new JSONObject();
	        issueDetails.put("summary", summary);
	        issueDetails.put("description", description);
	        issueDetails.put("issuetype", new JSONObject().put("name", JIRA_ISSUE_TYPE));
	        issueDetails.put("project", new JSONObject().put("key", JIRA_PROJECT_KEY));

	        JSONObject issue = new JSONObject();
	        issue.put("fields", issueDetails);

	        Response response = RestAssured.given()
	            .auth().preemptive().basic(JIRA_USERNAME, JIRA_API_TOKEN)
	            .header("Content-Type", "application/json")
	            .body(issue.toString())
	            .post(JIRA_URL + "/rest/api/2/issue");

	        if (response.statusCode() == 201) {
	            System.out.println("Issue created successfully: " + response.jsonPath().getString("key"));
	        } else {
	            System.err.println("Failed to create issue: " + response.statusLine());
	        }
	    
	}


}
