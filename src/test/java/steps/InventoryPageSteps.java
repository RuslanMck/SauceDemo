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

    @Step("Verify if products in grid are sorted in the alphabetical order by product name")
    public boolean checkAlphabeticalSorting(){
       return INVENTORY_PAGE.isSortedAlphabetically();
    }

    @Step("Verify if products in grid are sorted in the reverse alphabetical order by product name")
    public boolean checkAlphabeticalReversedSorting(){
        return INVENTORY_PAGE.isSortedAlphabeticallyReversed();
    }

    @Step("Verify if products in grid are sorted in the ascending order by price")
    public boolean checkAscendingSorting(){
        return INVENTORY_PAGE.isSortedInAscendingOrder();
    }

    @Step("Verify if products in grid are sorted in the descending order by price")
    public boolean checkDescendingSorting(){
        return INVENTORY_PAGE.isSortedInDescendingOrder();
    }

    @Step("Verify that the product can be added to the cart")
    public void addProductToTheCart(){
        INVENTORY_PAGE.clickAddToCartButton();
    }

    @Step("Verify the number of products in the cart")
    public String checkNumberOfProductsInCart(){
        return INVENTORY_PAGE.getItemsInTheCartValue();
    }

    @Step("Verify that the user can navigate to the shipping cart")
    public void checkCartNavigation(){
        INVENTORY_PAGE.clickShoppingCartButton();
    }

}
