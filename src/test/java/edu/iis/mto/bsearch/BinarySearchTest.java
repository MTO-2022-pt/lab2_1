package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {
    private static final int[] seqOneElement = {1};
    private static final int[] seqBiggerOdd = {1, 3, 4, 5, 6, 7, 8};
    private static final int[] seqBiggerEven = {1, 3, 4, 5, 6, 7, 8, 9};
    private static final int[] seqEmpty = {};

    @Test
    void elementIsInSeq() {
        int posInSeq = 0;
        SearchResult result = BinarySearch.search(seqOneElement[posInSeq], seqOneElement);
        assertTrue(result.isFound());
        assertEquals(posInSeq, result.getPosition());
    }

    @Test
    void elementIsNotInSeqLenOne() {
        int posInSeq = -1;
        SearchResult result = BinarySearch.search(posInSeq, seqOneElement);
        assertFalse(result.isFound());
        assertEquals(posInSeq, result.getPosition());
    }

    @Test
    void elementIsFirstInSeq() {
        int posInSeq = 0;
        SearchResult result = BinarySearch.search(seqBiggerOdd[posInSeq], seqBiggerOdd);
        assertTrue(result.isFound());
        assertEquals(posInSeq, result.getPosition());
    }

    @Test
    void elementIsLastInSeq() {
        int posInSeq = seqBiggerOdd.length - 1;
        SearchResult result = BinarySearch.search(seqBiggerOdd[posInSeq], seqBiggerOdd);
        assertTrue(result.isFound());
        assertEquals(posInSeq, result.getPosition());
    }

    @Test
    void elementIsMiddleInOddSeq() {
        int posInSeq = (seqBiggerOdd.length / 2);
        SearchResult result = BinarySearch.search(seqBiggerOdd[posInSeq], seqBiggerOdd);
        assertTrue(result.isFound());
        assertEquals(posInSeq, result.getPosition());
    }

    @Test
    void elementIsMiddleInEvenSeqPreMiddle() {
        int posInSeq = (seqBiggerEven.length / 2) - 1;
        SearchResult result = BinarySearch.search(seqBiggerEven[posInSeq], seqBiggerEven);
        assertTrue(result.isFound());
        assertEquals(posInSeq, result.getPosition());
    }

    @Test
    void elementIsMiddleInEvenSeqPostMiddle() {
        int posInSeq = seqBiggerEven.length / 2;
        SearchResult result = BinarySearch.search(seqBiggerEven[posInSeq], seqBiggerEven);
        assertTrue(result.isFound());
        assertEquals(posInSeq, result.getPosition());
    }

    @Test
    void elementIsNotInSeqLenBigger() {
        int posInSeq = -1;
        SearchResult result = BinarySearch.search(posInSeq, seqBiggerOdd);
        assertFalse(result.isFound());
        assertEquals(posInSeq, result.getPosition());
    }

    @Test
    void seqLenIsZeroShouldThrowIllegalArgumentException() {
        int keyToFind = -1;
        assertThrowsExactly(IllegalArgumentException.class, () -> BinarySearch.search(keyToFind, seqEmpty));
    }
}
