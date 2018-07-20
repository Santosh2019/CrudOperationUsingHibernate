package com.scp.TestLogic;

import java.util.ArrayList;
import java.util.List;
import com.scp.Constant.AppLevelConstant;
import com.scp.bean.Employee;

public class EmpController {
	@SuppressWarnings("unlikely-arg-type")
	public static String validateUserCredentails(String userName, String password) {
		String dbUserName = null;
		String dbPassword = null;
		try {
			List<Employee> list = new ArrayList<Employee>();
			for (Employee employee2 : list) {
				dbUserName = employee2.getEmployeeName();
				dbPassword = employee2.getEmployeeId();
				break;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (dbUserName == null) {
				dbUserName = "";
			}
			if (dbPassword == null) {
				dbPassword = "";
			}
		}
		
		
		System.out.println(""+dbUserName);

		System.out.println("Hi :"+dbPassword);
		System.out.println("Hi :"+userName);
		System.out.println("Hi :"+password);
		
		
		
		if (userName == null) {
			return AppLevelConstant.USERNAME_CANT_BE_EMPTY;
		} else if (password == null) {
			return AppLevelConstant.PASSWORD_CANT_BE_EMPTY;
		} else if (dbUserName.equals(userName) && dbPassword.equals(password)) {// if(dbUserName.equals(userName) &&
			// dbPassword.equals(password)) {
			return AppLevelConstant.LOGIN_SUCCESS;
		}
		return AppLevelConstant.USERNAME_PASSWORD_INVALID;

	}

}
