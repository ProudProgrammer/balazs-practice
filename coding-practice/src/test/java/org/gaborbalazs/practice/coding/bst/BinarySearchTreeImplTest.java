package org.gaborbalazs.practice.coding.bst;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BinarySearchTreeImplTest {

    @InjectMocks
    private BinarySearchTreeImpl underTest;

    @Test
    void test() {
        underTest.add(10);
        underTest.add(9);
        underTest.add(8);
        underTest.add(11);
        underTest.add(7);

        assertEquals(5, underTest.size());
        assertEquals(7, underTest.min());
        assertEquals(11, underTest.max());
    }
}