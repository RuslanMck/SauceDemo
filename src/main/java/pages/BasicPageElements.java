package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public abstract class BasicPageElements {

    private SelenideElement header = Selenide.$(".primary_header");
    private SelenideElement headerLogo = Selenide.$(".app_logo");
    private SelenideElement footer = Selenide.$(".footer");
    private SelenideElement navigationMenuButton = Selenide.$("#react-burger-menu-btn");
    private SelenideElement navigationMenuBlock = Selenide.$(".bm-menu");
    private ElementsCollection navigationMenuButtons = Selenide.$$(".bm-item-list");
    private SelenideElement inventoryNavigationButton = Selenide.$("#inventory_sidebar_link");
    private SelenideElement aboutNavigationButton = Selenide.$("#about_sidebar_link");
    private SelenideElement logoutNavigationButton = Selenide.$("#logout_sidebar_link");
    private SelenideElement resetNavigationButton = Selenide.$("#reset_sidebar_link");
    private SelenideElement closeNavigationButton = Selenide.$(".bm-cross-button");
    private SelenideElement shoppingCartButton = Selenide.$("#shopping_cart_container");
    private SelenideElement privacyPolicy = Selenide.$(".footer_copy");
    private SelenideElement twitterSocialButton = Selenide.$(".social_twitter");
    private SelenideElement linkedinSocialButton = Selenide.$(".social_linkedin");
    private SelenideElement facebookSocialButton = Selenide.$(".social_facebook");


    public boolean isHeaderVisible() {
        header.shouldBe(Condition.visible);
        return header.isDisplayed();
    }

    public boolean isFooterVisible() {
        footer.shouldBe(Condition.visible);
        return footer.isDisplayed();
    }

    public boolean isLogoVisible() {
        headerLogo.shouldBe(Condition.visible);
        return headerLogo.isDisplayed();
    }

    public boolean isNavigationMenuButtonVisible() {
        navigationMenuButton.shouldBe(Condition.visible);
        return navigationMenuButton.isDisplayed();
    }

    public void clickNavigationMenuButton() {
        navigationMenuButton.shouldBe(Condition.visible);
        navigationMenuButton.click();
    }

    public boolean isNavigationMenuBlockVisible() {
        navigationMenuBlock.shouldBe(Condition.visible);
        return navigationMenuBlock.isDisplayed();
    }

    public boolean isInventoryNavigationButtonVisible() {
        inventoryNavigationButton.shouldBe(Condition.visible);
        return inventoryNavigationButton.isDisplayed();
    }

    public void clickInventoryNavigationButton() {
        inventoryNavigationButton.shouldBe(Condition.visible);
        inventoryNavigationButton.click();
    }

    public boolean isAboutNavigationButtonVisible() {
        aboutNavigationButton.shouldBe(Condition.visible);
        return aboutNavigationButton.isDisplayed();
    }

    public void clickAboutNavigationButton() {
        aboutNavigationButton.shouldBe(Condition.visible);
        aboutNavigationButton.click();
    }

    public boolean isLogoutNavigationButtonVisible() {
        logoutNavigationButton.shouldBe(Condition.visible);
        return logoutNavigationButton.isDisplayed();
    }

    public void clickLogoutNavigationButton() {
        logoutNavigationButton.shouldBe(Condition.visible);
        logoutNavigationButton.click();
    }

    public boolean isResetNavigationButtonVisible() {
        resetNavigationButton.shouldBe(Condition.visible);
        return resetNavigationButton.isDisplayed();
    }

    public void clickResetNavigationButton() {
        resetNavigationButton.shouldBe(Condition.visible);
        resetNavigationButton.click();
    }

    public boolean isCloseNavigationButtonVisible() {
        closeNavigationButton.shouldBe(Condition.visible);
        return closeNavigationButton.isDisplayed();
    }

    public void clickCloseNavigationButton() {
        closeNavigationButton.shouldBe(Condition.visible);
        closeNavigationButton.click();
    }

    public boolean isShoppingCartButtonVisible() {
        shoppingCartButton.shouldBe(Condition.visible);
        return shoppingCartButton.isDisplayed();
    }

    public void clickShoppingCartButton() {
        shoppingCartButton.shouldBe(Condition.visible);
        shoppingCartButton.click();
    }

    public boolean isPrivacyPolicyVisible() {
        privacyPolicy.shouldBe(Condition.visible);
        return privacyPolicy.isDisplayed();
    }

    public boolean isTwitterSocialButtonVisible() {
        twitterSocialButton.shouldBe(Condition.visible);
        return twitterSocialButton.isDisplayed();
    }

    public void clickTwitterSocialButton() {
        twitterSocialButton.shouldBe(Condition.visible);
        twitterSocialButton.click();
    }

    public boolean isLinkedinSocialButtonVisible() {
        linkedinSocialButton.shouldBe(Condition.visible);
        return linkedinSocialButton.isDisplayed();
    }

    public void clickLinkedinSocialButton() {
        linkedinSocialButton.shouldBe(Condition.visible);
        linkedinSocialButton.click();
    }

    public boolean isFacebookSocialButtonVisible() {
        facebookSocialButton.shouldBe(Condition.visible);
        return facebookSocialButton.isDisplayed();
    }

    public void clickFacebookSocialButton() {
        facebookSocialButton.shouldBe(Condition.visible);
        facebookSocialButton.click();
    }

}
