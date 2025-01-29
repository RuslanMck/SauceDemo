package ui;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public abstract class TestConfig {

    public void basicConfig(){
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

        ChromeOptions chromeOptions = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_leak_detection", false);

        chromeOptions.setExperimentalOption("prefs", prefs);

        Configuration.browserCapabilities = chromeOptions;
    }
}
