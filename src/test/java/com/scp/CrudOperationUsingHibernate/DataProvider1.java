package com.scp.CrudOperationUsingHibernate;
import org.testng.annotations.DataProvider;  
import org.testng.annotations.Test;

import com.scp.TestLogic.TestLogic;

import junit.framework.Assert;

public class DataProvider1 {
	
	@Test(dataProvider="getdata")	
	public void authanticate(int employeeId, String employeeName, String result) {
		
	//	System.out.println("inside method **********");
		boolean b1=false;
		if(result.equalsIgnoreCase("true")) {
			b1=true;
			
		}
		System.out.println(/*"id "+employeeId+ "name "+employeeName+ "eslt ="+*/TestLogic.login(employeeId,employeeName));
			Assert.assertEquals(b1, TestLogic.login(employeeId,employeeName));
		
	}
	
	@DataProvider(name="getdata")
	public Object[][] getData1() {
		
		Object object[][]=new Object[4][3];
		object[0][0]=11;
		object[0][1]="Sachin";
		object[0][2]="true";
		
		
		object[1][0]=12;
		object[1][1]="Swapnil";
		object[1][2]="true";
	
		object[2][0]=13;
		object[2][1]="Sachin";
		object[2][2]="true";
		
		object[3][0]=14;
		object[3][1]="Ninad";
		object[3][2]="true";
		
		return object;
	}
}
