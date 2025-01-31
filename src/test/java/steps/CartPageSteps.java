package steps;

import io.qameta.allure.Step;
import pages.CartPage;

public class CartPageSteps {

    private final CartPage CART_PAGE = new CartPage();

    @Step("Verify number of unique items in the cart")
    public int verifyNumberOfUniqueItems(){
        return CART_PAGE.getNumberOfUniqueItems();
    }

    @Step("Verify the qty of one unique item")
    public String verifyQtyOfItem(){
        return CART_PAGE.getQtyOnOneItem();
    }

    @Step("Verify that user can proceed to checkout")
    public void proceedToCheckout(){
        CART_PAGE.clickCheckoutButton();
    }
}
