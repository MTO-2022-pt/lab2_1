package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {
    public final static int[] sequenceLong = {1, 4, 6, 8, 10, 45};
    public final static int[] sequenceShort = { 6 };

    @Test
    void inShortSequence() {
        SearchResult result = BinarySearch.search(sequenceShort[0], sequenceShort);
        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
    }

    @Test
    void notInShortSequence() {
        assertFalse(BinarySearch.search(sequenceShort[0]+1, sequenceShort).isFound());
    }

    @Test
    void firstInSequence() {
        SearchResult result = BinarySearch.search(sequenceLong[1], sequenceLong);
        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
    }

    @Test
    void lastInSequence() {
        SearchResult result = BinarySearch.search(sequenceLong[sequenceLong.length-1], sequenceLong);
        assertTrue(result.isFound());
        assertEquals(sequenceLong.length-1,  result.getPosition());
    }

    @Test
    void midInSequence() {
        SearchResult result = BinarySearch.search(sequenceLong[sequenceLong.length/2], sequenceLong);
        assertTrue(result.isFound());
        assertEquals(sequenceLong.length/2, result.getPosition());
    }

    @Test
    void notInLongSequence() {
        assertFalse(BinarySearch.search(sequenceLong[0]-1, sequenceLong).isFound());
    }

}
