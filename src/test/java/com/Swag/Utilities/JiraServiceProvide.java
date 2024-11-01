package com.Swag.Utilities;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class JiraServiceProvide {
	
	public JiraClient jira;
	public String project;
	
	public JiraServiceProvide(String jiraurl,String username, String password, String project )
	{
		BasicCredentials creds	= new BasicCredentials(username,password);
		jira=new JiraClient(jiraurl,creds);
		this.project=project;
		
	}
	
	public void createJiraTicket(String issueType,String summary, String description, String reporter)
	{
		try {
			FluentCreate fluentCreate=jira.createIssue(project, issueType);
			fluentCreate.field(Field.SUMMARY,summary);
			fluentCreate.field(Field.DESCRIPTION,summary);
			Issue issue=fluentCreate.execute();
			System.out.println("new ticket is created id: "+issue);
		} catch (JiraException e) {
			
			e.printStackTrace();
		}
	}


	

}



