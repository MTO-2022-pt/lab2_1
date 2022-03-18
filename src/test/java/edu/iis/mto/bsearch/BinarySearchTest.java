package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {
    private static final int[] ONE_ELEMENT_SEQUENCE = {2};
    private static final int[] MULTI_ELEMENT_SEQUENCE = {-3, 0, 1, 3, 6, 9, 12};

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
    void test() {
        fail("Not yet implemented");
    }

}
