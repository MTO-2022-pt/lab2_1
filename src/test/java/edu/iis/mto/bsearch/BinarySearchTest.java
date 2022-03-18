package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {
    }

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

}
