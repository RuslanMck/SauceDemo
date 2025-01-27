package ui;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTests extends BasicTest {

    private LoginPage loginPage = new LoginPage();

    @BeforeClass
    public void setUp(){
        super.baseSetUp(loginPage.getBASE_URL());
    }

    @Test
    public void test(){
        System.out.println("Test executed");
    }


}
