package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {
    }

    //testy_v1
    @Test
    void thereIsOneInSingleElementSequenceTest(){
        int[] sequence = {1};
        SearchResult result = BinarySearch.search(1, sequence);
        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
    }

    @Test
    void thereIsNoInSingleElementSequenceTest() {
        int[] sequence = {1};
        SearchResult result = BinarySearch.search(2, sequence);
        assertFalse(result.isFound());
        assertEquals(-1, result.getPosition());
    }

    @Test
    void firstOneInMultipleElementSequenceTest(){
        int[] sequence = {1, 2, 3};
        SearchResult result = BinarySearch.search(1, sequence);
        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
    }


    @Test
    void lastOneInMultipleElementSequenceTest(){
        int[] sequence = {1, 2, 3};
        SearchResult result = BinarySearch.search(3, sequence);
        assertTrue(result.isFound());
        assertEquals(sequence.length - 1, result.getPosition());
    }

    @Test
    void middleOneInMultipleElementSequenceTest(){
        int[] sequence = {1, 2, 3};
        SearchResult result = BinarySearch.search(2, sequence);
        assertTrue(result.isFound());
        assertEquals(1, result.getPosition());
    }

    @Test
    void itIsNotInMultipleElementSequenceTest(){
        int[] sequence = {1, 2, 3};
        SearchResult result = BinarySearch.search(4, sequence);
        assertFalse(result.isFound());
        assertEquals(-1, result.getPosition());
    }

    //testy_v2
    @Test
    void sequenceIsEmptyTest(){
        int[] sequence = {};
        assertThrows(IllegalArgumentException.class, () -> {
            BinarySearch.search(1, sequence);
        } );
    }

    @Test
    void firstOneInTwoElementSequenceTest(){
        int[] sequence = {1, 2};
        SearchResult result = BinarySearch.search(1, sequence);
        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
    }

    @Test
    void lastOneInTwoElementSequenceTest(){
        int[] sequence = {1, 2};
        SearchResult result = BinarySearch.search(2, sequence);
        assertTrue(result.isFound());
        assertEquals(1, result.getPosition());
    }

    @Test
    void middleLeftOneInEvenSizedSequenceTest(){
        int[] sequence = {1, 2, 3, 4};
        SearchResult result = BinarySearch.search(2, sequence);
        assertTrue(result.isFound());
        assertEquals(1, result.getPosition());
    }

    @Test
    void middleRightOneInEvenSizedSequenceTest(){
        int[] sequence = {1, 2, 3, 4};
        SearchResult result = BinarySearch.search(3, sequence);
        assertTrue(result.isFound());
        assertEquals(2, result.getPosition());
    }

    @Test
    void searchWithNullSequenceTest(){
        int[] sequence = null;
        assertThrows(NullPointerException.class, () -> {
            BinarySearch.search(3, sequence);
        });
    }

    @Test
    void searchWithNegativeValuesSequenceTest(){
        int[] sequence = {-4, -3, -2, -1};
        SearchResult result = BinarySearch.search(-2, sequence);
        assertTrue(result.isFound());
        assertEquals(2, result.getPosition());
    }

    @Test
    void searchWithNegativeAndZeroValuesSequenceTest(){
        int[] sequence = {-4, -3, -2, -1, 0};
        SearchResult result = BinarySearch.search(-2, sequence);
        assertTrue(result.isFound());
        assertEquals(2, result.getPosition());
    }

    @Test
    void searchWithMixedValuesSequenceTest(){
        int[] sequence = {-2, -1, 0, 1, 2};
        SearchResult result = BinarySearch.search(0, sequence);
        assertTrue(result.isFound());
        assertEquals(2, result.getPosition());
    }

}
