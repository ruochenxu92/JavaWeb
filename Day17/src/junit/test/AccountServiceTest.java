package junit.test;

import java.sql.SQLException;

import org.junit.Test;

import service.AccountService;

public class AccountServiceTest {
	
	@Test
	public void testTransfer() throws SQLException{
		AccountService service = new AccountService();
		service.transfer(1,2,1000);
	}

	@Test
	public void demo1(){
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread);
		ThreadLocal t = new ThreadLocal();
		t.set("aaaa");
		String a= (String) t.get();
		System.out.println(a);
		
	}
	
}
