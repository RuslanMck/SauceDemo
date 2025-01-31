package steps;

import io.qameta.allure.Step;
import pages.CheckoutFirstStepPage;

public class CheckoutFirstStepSteps {

    private final CheckoutFirstStepPage CHECKOUT_FIRST_STEP_PAGE = new CheckoutFirstStepPage();

    @Step("Verify that the user can populate the first name")
    public void enterFirstName(String firstName) {
        CHECKOUT_FIRST_STEP_PAGE.inputFirstName(firstName);
    }

    @Step("Verify that the user can populate the last name")
    public void enterLastName(String lastName) {
        CHECKOUT_FIRST_STEP_PAGE.inputLastName(lastName);
    }

    @Step("Verify that the user can populate a postal code")
    public void interZipCode(String postalCode){
        CHECKOUT_FIRST_STEP_PAGE.inputPostalCode(postalCode);
    }

    @Step("Verify that the user can proceed to the next checkout step")
    public void proceedWithCheckout(){
        CHECKOUT_FIRST_STEP_PAGE.clickContinueButton();
    }
}
