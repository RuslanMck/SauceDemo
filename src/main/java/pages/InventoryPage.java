package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

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

    public boolean isHeaderSecondaryVisible(){
        headerSecondary.shouldBe(Condition.visible);
        return headerSecondary.isDisplayed();
    }

    public boolean isProductsSortingDropdownVisible(){
        productsSortingDropdown.shouldBe(Condition.visible);
        return productsSortingDropdown.isDisplayed();
    }

    public void clickProductsSortingDropdown(){
        productsSortingDropdown.shouldBe(Condition.visible);
        productsSortingDropdown.click();
    }

    public void clickSortingOption(String option){
        clickProductsSortingDropdown();
        for (SelenideElement element : productSortingOptions){

            System.out.println("------------------- " + productSortingOptions.size());
            System.out.println("------------------- " + element.text());
            System.out.println("------------------- " + option);
            System.out.println("------------------- " + element.text().equals(option));

            if (element.text().equals(option)){
                element.click();
                break;
            }
        }
    }







}
