package mz.com.cstock.util;

import java.util.Calendar;

import mz.com.cstock.model.LogedUser;
import mz.com.cstock.model.User;

public class UserHolder {
	
	private static User user = new User();
	
	public static User callUser(User user) {
		UserHolder.user = user;
//		UserHolder.user.setLoginDate(Calendar.getInstance());
		return UserHolder.user;
	}
	
	public static User copy() {
		return UserHolder.user;
	}
	
}
