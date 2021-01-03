package test;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;
import page.CartPage;
import page.ProductPage;
import service.ProductPageDataReader;

public class CartTest extends CommonConditions {
    @Test
    public void testAddToCart() {
        ProductPage productPage = new ProductPage(ProductPageDataReader.getProductPageUrl())
                .openPage()
                .addToBasket();
        String expectedName = productPage.getProductName();
        int expectedPrice = productPage.getProductPrice();

        CartPage cartPage = new CartPage()
                .openPage();
        String actualName = cartPage.getItemNameByIndex(0);
        int actualPrice = cartPage.getItemPriceByIndex(0);
        assertThat(actualName).isEqualTo(expectedName);
        assertThat(actualPrice).isEqualTo(expectedPrice);
    }
}
