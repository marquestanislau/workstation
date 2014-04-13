package mz.com.cstock.util;

import mz.com.cstock.model.User;

public class UserHolder {
	
	private static User user = new User();
	
	public static User sendUser(User user) {
		UserHolder.user = user;
//		UserHolder.user.setLoginDate(Calendar.getInstance());
		return UserHolder.user;
	}
	
	public static User copy() {
		return UserHolder.user;
	}
	
}
