package ui;

import com.codeborne.selenide.Selenide;
import helpers.LoginHelper;
import helpers.ProductGridSortingOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import steps.InventoryPageSteps;
import steps.LoginPageSteps;


public class InventoryPageTest extends BasicTest{
    private final LoginPage LOGIN_PAGE = new LoginPage();
    private final InventoryPage INVENTORY_PAGE = new InventoryPage();
    private final LoginPageSteps LOGIN_PAGE_STEPS = new LoginPageSteps();
    private final InventoryPageSteps INVENTORY_PAGE_STEPS = new InventoryPageSteps();
    private LoginHelper loginHelper;


    @BeforeClass
    public void setUp(){
        super.baseSetUp(LOGIN_PAGE.getBASE_URL());
        loginHelper = new LoginHelper();
    }

    @Test(description = "Verify the navigation to the /inventory.html page is restricted for not logged in user")
    public void pageNavigationWithoutLogin(){
        Selenide.open(INVENTORY_PAGE.getBASE_URL());
        Assert.assertTrue(LOGIN_PAGE_STEPS.verifyErrorMessageDisplaying());
        Assert.assertEquals(LOGIN_PAGE_STEPS.retrieveErrorMessageText(),
                "Epic sadface: You can only access '/inventory.html' when you are logged in.");
    }

    @Test(description = "Verify inventory page", dependsOnMethods = {"pageNavigationWithoutLogin"})
    public void verifyInventoryPageElements(){
        loginHelper.loginAsStandardUser();

        INVENTORY_PAGE.clickSortingOption(ProductGridSortingOptions.NAME_A_TO_Z.getText());
        Assert.assertTrue(INVENTORY_PAGE_STEPS.checkAlphabeticalSorting());

        INVENTORY_PAGE.clickSortingOption(ProductGridSortingOptions.NAME_Z_TO_A.getText());
        Assert.assertTrue(INVENTORY_PAGE_STEPS.checkAlphabeticalReversedSorting());

        INVENTORY_PAGE.clickSortingOption(ProductGridSortingOptions.PRICE_LOW_TO_HIGH.getText());
        Assert.assertTrue(INVENTORY_PAGE_STEPS.checkAscendingSorting());

        INVENTORY_PAGE.clickSortingOption(ProductGridSortingOptions.PRICE_HIGH_TO_LOW.getText());
        Assert.assertTrue(INVENTORY_PAGE_STEPS.checkDescendingSorting());
    }



}
