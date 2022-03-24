package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTest {
    int key;

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void isInSequence() {
        int[] seqS = { 1 };
        key = 0;
        SearchResult result = BinarySearch.search(1, seqS);
        assertTrue(result.isFound());
        assertEquals(key, result.getPosition());
    }

    @Test
    void notInSequence() {
        int[] seqS = { 1 };
        key = -1;
        SearchResult result = BinarySearch.search(2, seqS);
        assertTrue(result.isFound());
        assertEquals(key, result.getPosition());
    }

    @Test
    void isFirstInSequence() {
        int[] seqL = {1, 2, 3};
        key = 0;
        SearchResult result = BinarySearch.search(1, seqL);
        assertTrue(result.isFound());
        assertEquals(key, result.getPosition());
    }

    @Test
    void isLastInSequence() {
        int[] seqL = {4, 5, 6};
        key = seqL.length - 1;
        SearchResult result = BinarySearch.search(key, seqL);
        assertTrue(result.isFound());
        assertEquals(key, result.getPosition());
    }

    @Test
    void isMiddleInSequence() {
        int[] seqL = {7, 8, 9};
        key = seqL.length/2;
        SearchResult result = BinarySearch.search(key, seqL);
        assertTrue(result.isFound());
        assertEquals(key, result.getPosition());
    }

    @Test
    void notLongInSequence() {
        int[] seqL = {10, 11, 12};
        key = seqL[0] - 1;
        SearchResult result = BinarySearch.search(key, seqL);
        assertFalse(result.isFound());
        assertEquals(-1, result.getPosition());
    }
}
