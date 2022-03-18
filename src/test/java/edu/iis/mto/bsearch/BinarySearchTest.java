package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    /**
     *
     */
    private static final int EXPECTED_GET_POSITION_VALUE_IF_NOT_FOUND = -1;
    private SearchResult searchResult;
    private int key;
    private int[] seq;

    @BeforeEach
    void setUp() throws Exception {
        key = 10;
    }

    @Test
    void shouldFindElementInOneElementSequence() {
        seq = new int[] { key };
        int keyPosition = 0;
        searchResult = BinarySearch.search(key, seq);

        assertEquals(true, searchResult.isFound());
        assertEquals(keyPosition, searchResult.getPosition());

    }

    @Test
    void shouldNotFindElementInOneElementSequence() {
        seq = new int[] { 20 };
        searchResult = BinarySearch.search(key, seq);

        assertEquals(false, searchResult.isFound());
        assertEquals(EXPECTED_GET_POSITION_VALUE_IF_NOT_FOUND, searchResult.getPosition());
    }

    @Test
    void shouldFindElementAsFirstInMultipleElementSequence() {
        seq = new int[] { key, 20, 30 };
        searchResult = BinarySearch.search(key, seq);

        assertEquals(true, searchResult.isFound());
        assertEquals(0, searchResult.getPosition());
    }

    @Test
    void shouldFindElementAsLastInMultipleElementSequence() {
        seq = new int[] { 5, 8, key };
        int lastPosition = seq.length - 1;
        searchResult = BinarySearch.search(key, seq);

        assertEquals(true, searchResult.isFound());
        assertEquals(lastPosition, searchResult.getPosition());
    }

    @Test
    void shouldFindElementAsMiddleInMultipleEvenElementSequence() {
        seq = new int[] { 5, key, 15, 20 };
        int middlePositionRight = seq.length / 2;
        int middlePositionLeft = middlePositionRight - 1;
        searchResult = BinarySearch.search(key, seq);

        assertEquals(true, searchResult.isFound());

        int positionResult = searchResult.getPosition();
        assertTrue((middlePositionLeft == positionResult) || (middlePositionRight == positionResult));
    }

    @Test
    void shouldFindElementAsMiddleInMultipleOddElementSequence() {
        seq = new int[] { 5, key, 20 };
        int middlePosition = seq.length / 2;
        searchResult = BinarySearch.search(key, seq);

        assertEquals(true, searchResult.isFound());
        assertEquals(middlePosition, searchResult.getPosition());
    }

    @Test
    void shouldNotFindElementInMultipleElementSequence() {
        seq = new int[] { 5, 15, 20 };
        searchResult = BinarySearch.search(key, seq);

        assertEquals(false, searchResult.isFound());
        assertEquals(EXPECTED_GET_POSITION_VALUE_IF_NOT_FOUND, searchResult.getPosition());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSequenceIsEmpty() {
        seq = new int[] {};

        assertThrows(IllegalArgumentException.class, () -> {
            searchResult = BinarySearch.search(key, seq);
        });
    }
}
