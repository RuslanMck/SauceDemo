package ui;

import com.codeborne.selenide.Configuration;

public abstract class TestConfig {

    public void basicConfig(){
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
}
