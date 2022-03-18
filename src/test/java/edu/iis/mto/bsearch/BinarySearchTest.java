package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BinarySearchTest {
    public final static int[] sequenceLong = {1, 4, 6, 8, 10, 45};
    public final static int[] sequenceShort = { 6 };
    public final static int[] sequenceEmpty = { };

    @Test
    public void inShortSequence() {
        SearchResult result;
        try {
            result = BinarySearch.search(sequenceShort[0], sequenceShort);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            assertEquals(e.getMessage(), "");
            return;
        }
        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
    }

    @Test
    public void notInShortSequence() {
        try {
            assertFalse(BinarySearch.search(sequenceShort[0]+1, sequenceShort).isFound());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            assertEquals(e.getMessage(), "");
        }
    }

    @Test
    public void firstInSequence() {
        SearchResult result;
        try {
            result = BinarySearch.search(sequenceLong[0], sequenceLong);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            assertEquals(e.getMessage(), "");
            return;
        }
        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
    }

    @Test
    public void lastInSequence() {
        SearchResult result;
        try {
            result = BinarySearch.search(sequenceLong[sequenceLong.length-1], sequenceLong);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            assertEquals(e.getMessage(), "");
            return;
        }
        assertTrue(result.isFound());
        assertEquals(sequenceLong.length-1,  result.getPosition());
    }

    @Test
    public void midInSequence() {
        SearchResult result;
        try {
            result = BinarySearch.search(sequenceLong[sequenceLong.length/2], sequenceLong);
        } catch (IllegalAccessException e) {
            assertEquals(e.getMessage(), "");
            e.printStackTrace();
            return;
        }
        assertTrue(result.isFound());
        assertEquals(sequenceLong.length/2, result.getPosition());
    }

    @Test
    public void notInLongSequence() {
        try {
            assertFalse(BinarySearch.search(sequenceLong[0]-1, sequenceLong).isFound());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            assertEquals(e.getMessage(), "");
        }
    }

    @Test
    public void emptySequence() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> BinarySearch.search(sequenceShort[0], sequenceEmpty));
    }

}
