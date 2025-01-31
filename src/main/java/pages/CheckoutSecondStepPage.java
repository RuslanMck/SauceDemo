package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helpers.ElementsCollectionHelpers;
import lombok.Getter;

import java.util.List;

@Getter
public class CheckoutSecondStepPage extends BasicPageElements {

    private final String BASE_URL = "https://www.saucedemo.com/checkout-step-two.html";

    private final SelenideElement productItem = Selenide.$(".cart_item");
    private final ElementsCollection productPricesList = Selenide.$$(".inventory_item_price");
    private final SelenideElement productTotalSum = Selenide.$(".summary_subtotal_label");
    private final SelenideElement taxPrice = Selenide.$(".summary_tax_label");
    private final SelenideElement cartTotal = Selenide.$(".summary_total_label");
    private final SelenideElement finishCheckoutButton = Selenide.$("#finish");

    public double getItemTotalNoSymbols() {
        return ElementsCollectionHelpers.removeCurrencySymbolAsDouble(productTotalSum);
    }

    public double getTaxNoSymbol() {
        return ElementsCollectionHelpers.removeCurrencySymbolAsDouble(taxPrice);
    }

    public double getTotalNoSymbol() {
        return ElementsCollectionHelpers.removeCurrencySymbolAsDouble(cartTotal);
    }

    public double getCalculatedProductsTotal() {
        return getProductsPricesSum(productPricesList);
    }

    private double getProductsPricesSum(ElementsCollection listOfPrices) {
        List<Double> pricesWithoutSymbols = ElementsCollectionHelpers.removeCurrencySymbolsAsDouble(listOfPrices);
        double sum = 0;
        for (double price : pricesWithoutSymbols) {
            sum += price;
        }
        return sum;
    }

    public boolean compareSumOfProductPrices() {
        return Math.abs(getCalculatedProductsTotal() - getItemTotalNoSymbols()) < 0.01;
    }

    public boolean productItemVisibility() {
        productItem.shouldBe(Condition.visible);
        return productItem.isDisplayed();
    }

    public boolean compareTotalPrices() {
        double calculatedTotal = getCalculatedProductsTotal() + getTaxNoSymbol();
        double expectedTotal = getTotalNoSymbol();

        return Math.abs(calculatedTotal - expectedTotal) < 0.01;
    }

    public void clickFinishButton() {
        finishCheckoutButton.shouldBe(Condition.visible);
        finishCheckoutButton.click();
    }
}
