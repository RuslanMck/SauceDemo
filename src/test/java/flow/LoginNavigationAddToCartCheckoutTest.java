package flow;

import com.codeborne.selenide.WebDriverRunner;
import helpers.LoginHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import steps.*;
import ui.BasicTest;

public class LoginNavigationAddToCartCheckoutTest extends BasicTest {

    private LoginPage LOGIN_PAGE;
    private final InventoryPage INVENTORY_PAGE = new InventoryPage();
    private final InventoryPageSteps INVENTORY_PAGE_STEPS = new InventoryPageSteps();
    private final CartPageSteps CART_PAGE_STEPS = new CartPageSteps();
    private final CartPage CART_PAGE = new CartPage();
    private final CheckoutFirstStepPage CHECKOUT_FIRST_STEP_PAGE = new CheckoutFirstStepPage();
    private final CheckoutFirstStepSteps CHECKOUT_FIRST_STEP_STEPS = new CheckoutFirstStepSteps();
    private final CheckoutSecondStepPage CHECKOUT_SECOND_STEP_PAGE = new CheckoutSecondStepPage();
    private final CheckoutSecondStepSteps CHECKOUT_SECOND_STEP_STEPS = new CheckoutSecondStepSteps();
    private final CheckoutCompletePage CHECKOUT_COMPLETE_PAGE = new CheckoutCompletePage();
    private final CheckoutCompletePageSteps CHECKOUT_COMPLETE_PAGE_STEPS = new CheckoutCompletePageSteps();
    private LoginHelper loginHelper;

    @BeforeClass
    public void setUp() {
        LOGIN_PAGE = new LoginPage();
        super.baseSetUp(LOGIN_PAGE.getBASE_URL());
        loginHelper = new LoginHelper();
    }

    @Test(description = "Verify the flow of login > navigation > adding product to the cart > checkout")
    public void verifyLoginNavigationAddToCartCheckoutFlow() {
        loginHelper.loginAsStandardUser();

        INVENTORY_PAGE_STEPS.addProductToTheCart();
        Assert.assertEquals(WebDriverRunner.driver().url(), INVENTORY_PAGE.getBASE_URL());
        Assert.assertEquals(INVENTORY_PAGE_STEPS.checkNumberOfProductsInCart(), "1");

        INVENTORY_PAGE_STEPS.checkCartNavigation();
        Assert.assertEquals(WebDriverRunner.driver().url(), CART_PAGE.getBASE_URL());
        Assert.assertEquals(CART_PAGE_STEPS.verifyNumberOfUniqueItems(), 1);
        Assert.assertEquals(CART_PAGE_STEPS.verifyQtyOfItem(), "1");

        CART_PAGE_STEPS.proceedToCheckout();
        Assert.assertEquals(WebDriverRunner.driver().url(), CHECKOUT_FIRST_STEP_PAGE.getBASE_URL());
        CHECKOUT_FIRST_STEP_STEPS.enterFirstName("John");
        CHECKOUT_FIRST_STEP_STEPS.enterLastName("Doe");
        CHECKOUT_FIRST_STEP_STEPS.interZipCode("61000");
        CHECKOUT_FIRST_STEP_STEPS.proceedWithCheckout();
        Assert.assertEquals(WebDriverRunner.driver().url(), CHECKOUT_SECOND_STEP_PAGE.getBASE_URL());

        Assert.assertTrue(CHECKOUT_SECOND_STEP_STEPS.isProductItemPresented());
        Assert.assertTrue(CHECKOUT_SECOND_STEP_STEPS.isTotalPriceCorrect());
        CHECKOUT_SECOND_STEP_STEPS.completeCheckout();
        Assert.assertEquals(WebDriverRunner.driver().url(), CHECKOUT_COMPLETE_PAGE.getBASE_URL());

        Assert.assertEquals(CHECKOUT_COMPLETE_PAGE_STEPS.obtainResultText(), "Thank you for your order!");
        CHECKOUT_COMPLETE_PAGE_STEPS.navigateToHomePage();
        Assert.assertEquals(WebDriverRunner.driver().url(), INVENTORY_PAGE.getBASE_URL());




    }
}
