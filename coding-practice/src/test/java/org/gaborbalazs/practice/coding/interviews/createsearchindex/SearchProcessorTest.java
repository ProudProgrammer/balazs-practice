package org.gaborbalazs.practice.coding.interviews.createsearchindex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchProcessorTest {

    private static final String MILK = "Milk";
    private static final String CHOCOLATE_MILK = "Chocolate Milk";

    private SearchProcessor underTest;

    @BeforeEach
    void setUp() {
        underTest = new SearchProcessor();
    }

    @Test
    void shouldReturnProductsListBasedOnOneKeyword() {
        List<Product> expected = createProductsMatchingWithMilk();

        List<Product> result = underTest.searchProducts(MILK);

        assertEquals(expected, result);
    }

    @Test
    void shouldReturnProductsListBasedOnTwoKeywords() {
        List<Product> expected = createProductsMatchingWithChocolateMilk();

        List<Product> result = underTest.searchProducts(CHOCOLATE_MILK);

        assertEquals(expected, result);
    }

    private List<Product> createProductsMatchingWithMilk() {
        return List.of(new Product(1, "Amul milk", 44),
                new Product(2, "Nandini Chocolate Milk", 18),
                new Product(3, "Milk Chocolate", 28),
                new Product(4, "Chocolate Milk", 28));
    }

    private List<Product> createProductsMatchingWithChocolateMilk() {
        return List.of(new Product(2, "Nandini Chocolate Milk", 63),
                new Product(3, "Milk Chocolate", 100),
                new Product(4, "Chocolate Milk", 100));
    }
}
