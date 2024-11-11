package october_2024;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrOfProductsTest {

    ArrOfProducts arrOfProducts;

    @BeforeEach
    public void setup() {
        arrOfProducts = new ArrOfProducts();
    }

    @Test
    public void testExample1() {
        int[] nums = {1, 2, 3, 4};
        int[] expected = {24, 12, 8, 6};

        assertArrayEquals(expected, arrOfProducts.productExceptSelf(nums));
    }

    @Test
    public void testExample2() {
        int[] nums = {-1, 1, 0, -3, 3};
        int[] expected = {0, 0, 9, 0, 0};

        assertArrayEquals(expected, arrOfProducts.productExceptSelf(nums));
    }
}
