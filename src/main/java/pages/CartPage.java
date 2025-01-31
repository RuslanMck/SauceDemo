package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class CartPage extends BasicPageElements{

    private final String BASE_URL = "https://www.saucedemo.com/cart.html";

    private ElementsCollection cartItemsList = Selenide.$$(".cart_item");
    private SelenideElement itemQty = Selenide.$(".cart_quantity");
    private SelenideElement checkoutButton = Selenide.$("#checkout");

    public int getNumberOfUniqueItems(){
        return cartItemsList.size();
    }

    public String getQtyOnOneItem(){
        itemQty.shouldBe(Condition.visible);
        return itemQty.text();
    }

    public void clickCheckoutButton(){
        checkoutButton.shouldBe(Condition.visible);
        checkoutButton.click();
    }

}
