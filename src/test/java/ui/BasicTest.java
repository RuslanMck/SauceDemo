package ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;


public class BasicTest extends TestConfig {


    public void baseSetUp(String pageUrl) {
        super.basicConfig();
        WebDriverRunner.driver().clearCookies();
        Selenide.open(pageUrl);

    }
}
