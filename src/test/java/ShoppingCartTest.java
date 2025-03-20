import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

class ShoppingCartTest {
    @Test
    void calculateItem() {
        ShoppingCart cart = new ShoppingCart();
        double price = 3.5;
        int quantity = 2;
        double result = cart.calculateItem(price, quantity);
        assertEquals(7, result, 0.001);
    }

    @Test
    void calculateTotal() {
        ShoppingCart cart = new ShoppingCart();
        ArrayList<Double> prices = new ArrayList<>(Arrays.asList(10.5, 20.0, 30.75));
        double result = cart.calculateTotal(prices);
        assertEquals(61.25, result, 0.001);
    }
}