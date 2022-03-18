package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {
    private static final int[] ONE_ELEMENT_SEQUENCE = {2};

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
    void test() {
        fail("Not yet implemented");
    }

}
