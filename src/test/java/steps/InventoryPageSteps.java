package steps;

import helpers.ProductGridSortingOptions;
import io.qameta.allure.Step;
import pages.InventoryPage;

public class InventoryPageSteps {

    private final InventoryPage INVENTORY_PAGE = new InventoryPage();

    @Step("Logout from the user account")
    public void logoutFromUserAccount(){
        INVENTORY_PAGE.clickNavigationMenuButton();
        INVENTORY_PAGE.clickLogoutNavigationButton();
    }

    @Step("Verify if products in grid can be sorted")
    public void clickSortingOption(ProductGridSortingOptions sortingOption){
        INVENTORY_PAGE.clickSortingOption(sortingOption.getText());
    }


}
