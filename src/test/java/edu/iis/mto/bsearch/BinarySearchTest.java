package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class BinarySearchTest {

    SearchResult searchResult;
    int key = 0, keyPosition = 1;
    int[] seq;

    @Test
    void shouldFindElementInOneElementSeq() {
        seq = new int[]{key};
        searchResult = BinarySearch.search(key, seq);

        assertTrue(searchResult.isFound());
        assertEquals(keyPosition, searchResult.getPosition());
    }

    @Test
    void shouldNotFindElementInOneElementSeq() {
        keyPosition = -1;
        seq = new int[]{1};
        searchResult = BinarySearch.search(key, seq);

        assertFalse(searchResult.isFound());
        assertEquals(keyPosition, searchResult.getPosition());
    }

    @Test
    void isFirstElement() {
        seq = new int[]{key, 1, 2};
        searchResult = BinarySearch.search(key, seq);

        assertTrue(searchResult.isFound());
        assertEquals(keyPosition, searchResult.getPosition());
    }

    @Test
    void isLastElement() {
        key = 3;
        keyPosition = 3;
        seq = new int[]{1, 2, key};
        searchResult = BinarySearch.search(key, seq);

        assertTrue(searchResult.isFound());
        assertEquals(keyPosition, searchResult.getPosition());
    }

    @Test
    void shouldNotFind() {
        keyPosition = -1;
        seq = new int[]{1, 2, 3};
        searchResult = BinarySearch.search(key, seq);

        assertFalse(searchResult.isFound());
        assertEquals(keyPosition, searchResult.getPosition());
    }

    @Test
    void isMiddleElementInOddArray() {
        seq = new int[]{-1, key, 1};
        
        keyPosition = 2;
        searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(keyPosition, searchResult.getPosition());
    }

    @Test
    void isMiddleElementInEvenArray() {
        seq = new int[]{-1, key, 1, 2};
        
        keyPosition = 2;
        searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        int positionResult = searchResult.getPosition();
        assertTrue(keyPosition == positionResult);
    }

    @Test
    void isSecondMiddleElementInEvenArray() {
        seq = new int[]{-2, -1, 0, 1};
        keyPosition = 3;
        searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        int positionResult = searchResult.getPosition();
        assertTrue(keyPosition == positionResult);
    }

    @Test()
    void shouldThrowExceptionForEmptySeq() {
        keyPosition = -1;

        assertThrows(NullPointerException.class, () -> searchResult = BinarySearch.search(key, seq));
    }

}
