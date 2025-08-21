package testcases;


import org.testng.annotations.Test;

import base.Baseclass;
import pages.LoginPage;
import utils.ConfigReader;

public class CreateAccount extends Baseclass{
	@Test
    public void testAccountCreation() {
        LoginPage login = new LoginPage(driver);

        String name = ConfigReader.get("username");
        String email = ConfigReader.get("email");
        String password = ConfigReader.get("password");
        String phone = ConfigReader.get("phone");

        login.createAccount(name, email, password, phone);
    }
}
