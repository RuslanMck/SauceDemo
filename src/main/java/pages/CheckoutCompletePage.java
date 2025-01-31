package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class CheckoutCompletePage extends BasicPageElements{

    private final String BASE_URL = "https://www.saucedemo.com/checkout-complete.html";

    private SelenideElement resultText = Selenide.$(".complete-header");
    private SelenideElement backHomeButton = Selenide.$("#back-to-products");

    public String getResultText(){
        resultText.shouldBe(Condition.visible);
        return resultText.text();
    }

    public void clickBackHomeButton(){
        backHomeButton.shouldBe(Condition.visible);
        backHomeButton.click();
    }
}
