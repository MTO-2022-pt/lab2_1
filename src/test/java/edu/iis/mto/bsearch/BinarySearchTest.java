package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {
    private static final int[] ONE_ELEMENT_SEQUENCE = {2};
    private static final int[] MULTI_ELEMENT_SEQUENCE = {-3, 0, 1, 3, 6, 9, 12};
    private static final int[] EMPTY_ELEMENT_SEQUENCE = {};
    private static final int[] UNSORTED_MULTI_ELEMENT_SEQUENCE = {0, 1, -3, 3, 6, 9, 12};
    private static final int[] SEQUENCE_WITH_DUPLICATED_ELEMENTS = {1, 2, 2, 7, 10};

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    public void searchForElementInSeqence(){
        int key = 2;
        int expected_pos = 1;
        SearchResult search = BinarySearch.search(key, ONE_ELEMENT_SEQUENCE);
        assertTrue(search.isFound());
        assertEquals(expected_pos, search.getPosition());
    }

    @Test
    public void searchForElementNotInSequence() {
        int key = 4;
        int expected_pos = -1;
        SearchResult search = BinarySearch.search(key, ONE_ELEMENT_SEQUENCE);
        assertFalse(search.isFound());
        assertEquals(expected_pos, search.getPosition());
    }

    @Test
    public void searchForElementAtFirstPositionInSequence() {
        int key = -3;
        int expected_pos = 1;
        SearchResult search = BinarySearch.search(key, MULTI_ELEMENT_SEQUENCE);
        assertTrue(search.isFound());
        assertEquals(expected_pos, search.getPosition());
        assertEquals(MULTI_ELEMENT_SEQUENCE[search.getPosition() - 1], key);
    }

    @Test
     public void searchForElementAtLastPositionInSequence(){
        int key = MULTI_ELEMENT_SEQUENCE[MULTI_ELEMENT_SEQUENCE.length - 1];
        int expected_pos = MULTI_ELEMENT_SEQUENCE.length;
        SearchResult search = BinarySearch.search(key, MULTI_ELEMENT_SEQUENCE);
        assertTrue(search.isFound());
        assertEquals(expected_pos, search.getPosition());
        assertEquals(MULTI_ELEMENT_SEQUENCE[search.getPosition() - 1], key);
    }

    @Test
    public void searchForElementAtMiddlePositionInSequence() {
        int key = 3;
        int ecpected_pos = 4;
        SearchResult search = BinarySearch.search(key, MULTI_ELEMENT_SEQUENCE);
        assertTrue(search.isFound());
        assertEquals(ecpected_pos, search.getPosition());
        assertEquals(MULTI_ELEMENT_SEQUENCE[search.getPosition() - 1], key);
    }

    @Test
    public void searchForElementInMultiSequence() {
        int key = 5;
        int expected_pos = -1;
        SearchResult search = BinarySearch.search(key, MULTI_ELEMENT_SEQUENCE);
        assertFalse(search.isFound());
        assertEquals(expected_pos, search.getPosition());
    }

    @Test
    public void searchForElementInEmptySequence() {
        int key = 5;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BinarySearch.search(key, EMPTY_ELEMENT_SEQUENCE);
        });
    }

    @Test
    public void searchForElementInUnsortedSequence() {
        int key = 5;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BinarySearch.search(key, UNSORTED_MULTI_ELEMENT_SEQUENCE);
        });
    }

    @Test
    public void searchForElementInDuplicatedSequence() {
        int key = 2;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BinarySearch.search(key, SEQUENCE_WITH_DUPLICATED_ELEMENTS);
        });
    }
}
