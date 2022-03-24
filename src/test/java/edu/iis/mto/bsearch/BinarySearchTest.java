package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void elementIsInSeq() {
        int keyToFind = 1;
        int [] seq = {1};
        int posInSeq = 1;
        SearchResult result = BinarySearch.search(keyToFind,seq);
        assertTrue(result.isFound());
        assertEquals(posInSeq,result.getPosition());
    }

    @Test
    void elementIsNotInSeqLenOne() {
        int keyToFind = 2;
        int [] seq = {1};
        int posInSeq = -1;
        SearchResult result = BinarySearch.search(keyToFind,seq);
        assertFalse(result.isFound());
        assertEquals(posInSeq,result.getPosition());
    }

    @Test
    void elementIsFirstInSeq() {
        int keyToFind = 1;
        int [] seq = {1,3,4,5,6,7,8};
        int posInSeq = 1;
        SearchResult result = BinarySearch.search(keyToFind,seq);
        assertTrue(result.isFound());
        assertEquals(posInSeq,result.getPosition());
    }

    @Test
    void elementIsLastInSeq() {
        int keyToFind = 8;
        int [] seq = {1,3,4,5,6,7,8};
        int posInSeq = 7;
        SearchResult result = BinarySearch.search(keyToFind,seq);
        assertTrue(result.isFound());
        assertEquals(posInSeq,result.getPosition());
    }

    @Test
    void elementIsMiddleInOddSeq() {
        int keyToFind = 5;
        int [] seq = {1,3,4,5,6,7,8};
        int posInSeq = 4;
        SearchResult result = BinarySearch.search(keyToFind,seq);
        assertTrue(result.isFound());
        assertEquals(posInSeq,result.getPosition());
    }

    @Test
    void elementIsMiddleInEvenSeqPreMiddle() {
        int keyToFind = 5;
        int [] seq = {1,3,4,5,6,7,8,9};
        int posInSeq = 4;
        SearchResult result = BinarySearch.search(keyToFind,seq);
        assertTrue(result.isFound());
        assertEquals(posInSeq,result.getPosition());
    }

    @Test
    void elementIsMiddleInEvenSeqPostMiddle() {
        int keyToFind = 6;
        int [] seq = {1,3,4,5,6,7,8,9};
        int posInSeq = 5;
        SearchResult result = BinarySearch.search(keyToFind,seq);
        assertTrue(result.isFound());
        assertEquals(posInSeq,result.getPosition());
    }

    @Test
    void elementIsNotInSeqLenBigger() {
        int keyToFind = 2;
        int [] seq = {1,3,4,5,6,7,8};
        int posInSeq = -1;
        SearchResult result = BinarySearch.search(keyToFind,seq);
        assertFalse(result.isFound());
        assertEquals(posInSeq,result.getPosition());
    }

    @Test
    void seqLenIsZeroShouldThrowIllegalArgumentException() {
        int keyToFind = 2;
        int [] seq = {};
        assertThrowsExactly(IllegalArgumentException.class,()->BinarySearch.search(keyToFind,seq));
    }
}
