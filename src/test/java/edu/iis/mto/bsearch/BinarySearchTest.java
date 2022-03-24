package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {
    private static final int[] seqOneElement = {1};
    private static final int[] seqBiggerOdd = {1, 3, 4, 5, 6, 7, 8};
    private static final int[] seqBiggerEven = {1, 3, 4, 5, 6, 7, 8, 9};
    private static final int[] seqEmpty = {};
    private static final int[] seqNotSorted = {1, 6, 4, 7, 8, 2, 5};
    private static final int[] seqSortedDescending = {9, 7, 6, 5, 4, 3, 2, 1};
    private static final int[] seqWithDuplicates = {1, 2, 3, 3, 4, 5};

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

    @Test
    void seqIsNotSortedAtAllShouldThrowsxception() {
        int keyToFind = 4;
        assertThrowsExactly(IllegalArgumentException.class, () -> BinarySearch.search(keyToFind, seqNotSorted));
    }

    @Test
    void seqIsNotSortedAscendingShouldThrowsxception() {
        int keyToFind = 4;
        assertThrowsExactly(IllegalArgumentException.class, () -> BinarySearch.search(keyToFind, seqSortedDescending));
    }

    @Test
    void seqConstainsRepeteadKeysShouldThrowsxception() {
        int keyToFind = 4;
        assertThrowsExactly(IllegalArgumentException.class, () -> BinarySearch.search(keyToFind, seqWithDuplicates));
    }

}
