package steps;

import io.qameta.allure.Step;
import pages.CheckoutCompletePage;

public class CheckoutCompletePageSteps {

    private final CheckoutCompletePage CHECKOUT_COMPLETE_PAGE = new CheckoutCompletePage();

    @Step("Verify that the order status text is displayed")
    public String obtainResultText(){
       return CHECKOUT_COMPLETE_PAGE.getResultText();
    }

    @Step("Verify that the user can navigate back to the home page")
    public void navigateToHomePage(){
        CHECKOUT_COMPLETE_PAGE.clickBackHomeButton();
    }
}
