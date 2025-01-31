package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helpers.ElementsCollectionHelpers;
import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
public class InventoryPage extends BasicPageElements {

    private final String BASE_URL = "https://www.saucedemo.com/inventory.html";

    private SelenideElement headerSecondary = Selenide.$(".header_secondary_container");
    private SelenideElement productsSortingDropdown = Selenide.$(".select_container");
    private ElementsCollection productSortingOptions = Selenide.$$x("//*[@class='product_sort_container']//option");
    private SelenideElement productGrid = Selenide.$(".inventory_container");
    private SelenideElement productGridName = Selenide.$(".inventory_item_name");
    private SelenideElement productGridDescription = Selenide.$(".inventory_item_desc");
    private SelenideElement productGridPrice = Selenide.$(".inventory_item_price");
    private SelenideElement productGridAddToCartButton = Selenide.$("#add-to-cart-sauce-labs-backpack");
    private ElementsCollection addToCartButtonsList = Selenide.$$(".btn_inventory");
    private ElementsCollection productNamesList = Selenide.$$(".inventory_item .inventory_item_name");
    private ElementsCollection productPricesList = Selenide.$$(".inventory_item .inventory_item_price");
    private SelenideElement itemsInTheCartCounter = Selenide.$(".shopping_cart_badge");
    private SelenideElement shoppingCartButton = Selenide.$("#shopping_cart_container");

    public boolean isHeaderSecondaryVisible() {
        headerSecondary.shouldBe(Condition.visible);
        return headerSecondary.isDisplayed();
    }

    public boolean isProductsSortingDropdownVisible() {
        productsSortingDropdown.shouldBe(Condition.visible);
        return productsSortingDropdown.isDisplayed();
    }

    public void clickProductsSortingDropdown() {
        productsSortingDropdown.shouldBe(Condition.visible);
        productsSortingDropdown.click();
    }

    public void clickSortingOption(String option) {
        clickProductsSortingDropdown();
        for (SelenideElement element : productSortingOptions) {
            if (element.text().equals(option)) {
                element.click();
                break;
            }
        }
    }

    public boolean isSortedAlphabetically() {
        return ElementsCollectionHelpers.isSortedAlphabetically(productNamesList);
    }

    public boolean isSortedAlphabeticallyReversed() {
        return ElementsCollectionHelpers.isSortedReverseAlphabetically(productNamesList);
    }

    public boolean isSortedInAscendingOrder(){
        return ElementsCollectionHelpers.isSortedInNumericalAscendingOrder(productPricesList);
    }

    public boolean isSortedInDescendingOrder(){
        return ElementsCollectionHelpers.isSortedInNumericalDescendingOrder(productPricesList);
    }

    public void clickAddToCartButton(){
        addToCartButtonsList.get(ThreadLocalRandom.current().nextInt(0, addToCartButtonsList.size()))
                .shouldBe(Condition.visible)
                .click();
    }

    public String getItemsInTheCartValue(){
        itemsInTheCartCounter.shouldBe(Condition.visible);
        return itemsInTheCartCounter.text();
    }

    public void clickShoppingCartButton(){
        shoppingCartButton.shouldBe(Condition.visible);
        shoppingCartButton.click();
    }


}
