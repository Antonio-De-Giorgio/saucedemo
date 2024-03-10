package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductPage {

    private final Page page;
    private final Locator burgerMenu;
    private final Locator logoutButton;
    private final Locator cart;
    private final Locator addToCart;
    private final Locator productSortContainer;

    public ProductPage(Page page) {
        this.page = page;
        this.burgerMenu = page.locator("id=react-burger-menu-btn");
        this.logoutButton = page.locator("id=logout_sidebar_link");
        this.cart = page.locator("id=shopping_cart_container");
        this.addToCart = page.locator("data-test=add-to-cart-sauce-labs-backpack");
        this.productSortContainer = page.locator("data-test=product_sort_container");
    }

    public void navigate() {
        page.navigate("https://saucedemo.com");
    }

    public void logout() {
        burgerMenu.click();
        logoutButton.click();
    }

    public void sortTest() {
        productSortContainer.click();
    }

    public void addProductToCart() {
        addToCart.click();
    }

    public void navigateToShoppingCart() {
        cart.click();
    }
}
