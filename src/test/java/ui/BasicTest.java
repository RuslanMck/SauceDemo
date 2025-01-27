package ui;

import com.codeborne.selenide.Selenide;

public class BasicTest extends TestConfig {

    public void baseSetUp(String pageUrl){
        super.basicConfig();
        Selenide.open(pageUrl);
    }
}
