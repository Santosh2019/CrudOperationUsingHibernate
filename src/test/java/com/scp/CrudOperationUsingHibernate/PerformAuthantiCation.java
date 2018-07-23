package com.scp.CrudOperationUsingHibernate;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.scp.TestLogic.EmpController;
import com.scp.UtilityClass.readWriteExcelUtility;



public class PerformAuthantiCation {

	@DataProvider
	public Object[][] getTestData(){
		return readWriteExcelUtility.readTestData();
		
	}
	@Test(dataProvider="getTestData")
	public void getData(String userName, String password, String msg) {
		System.out.println(userName+"--------"+password+"-------"+msg);
		EmpController controller=new EmpController(); 
		String actualMsg =controller.validateUserCredentails(userName, password);
		Assert.assertEquals(actualMsg, msg);
	}
}
