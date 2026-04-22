package org.gaborbalazs.practice.coding.interviews.createsearchindex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchEngineWithInvertedIndexTest {

    private static final String MILK = "Milk";
    private static final String CHOCOLATE_MILK = "Chocolate Milk";

    private SearchEngineWithInvertedIndex underTest;

    @BeforeEach
    void setUp() {
        underTest = new SearchEngineWithInvertedIndex();
    }

    @Test
    void shouldReturnProductsListBasedOnOneKeyword() {
        List<Result> expected = createProductsMatchingWithMilk();

        List<Result> result = underTest.search(MILK);

        assertEquals(expected, result);
    }

    @Test
    void shouldReturnProductsListBasedOnTwoKeywords() {
        List<Result> expected = createProductsMatchingWithChocolateMilk();

        List<Result> result = underTest.search(CHOCOLATE_MILK);

        assertEquals(expected, result);
    }

    private List<Result> createProductsMatchingWithMilk() {
        return List.of(new Result(1, "Amul milk", 44),
                new Result(3, "Milk Chocolate", 28),
                new Result(4, "Chocolate Milk", 28),
                new Result(2, "Nandini Chocolate Milk", 18));
    }

    private List<Result> createProductsMatchingWithChocolateMilk() {
        return List.of(new Result(3, "Milk Chocolate", 92),
                new Result(4, "Chocolate Milk", 92),
                new Result(2, "Nandini Chocolate Milk", 59));
    }
}