package steps;

import io.qameta.allure.Step;
import pages.CheckoutSecondStepPage;

public class CheckoutSecondStepSteps {

    private CheckoutSecondStepPage CHECKOUT_SECOND_STEP = new CheckoutSecondStepPage();

    @Step("Verify if the product is displayed in the page")
    public boolean isProductItemPresented() {
        return CHECKOUT_SECOND_STEP.productItemVisibility();
    }

    @Step("Compare the sum of all products in the cart with the displayed Item total")
    public boolean isTotalPriceCorrect() {
        return CHECKOUT_SECOND_STEP.compareSumOfProductPrices() && CHECKOUT_SECOND_STEP.compareTotalPrices();
    }

    @Step("Verify if the order can be completed")
    public void completeCheckout(){
        CHECKOUT_SECOND_STEP.clickFinishButton();
    }


}
