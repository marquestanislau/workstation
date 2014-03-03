package mz.com.dao.testes;

import mz.com.cstock.model.LogedUser;
import mz.com.cstock.model.User;

import org.junit.Test;

public class InhirintaceTests {

	@Test
	public void testHH() {
		LogedUser user = (LogedUser) new User();
		user.setEmail("************");
	}
}
