package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void Its_in_sequence()
    {
        int[] array = {1};
        SearchResult ob = BinarySearch.search(1,array);
        assertEquals(1,ob.getPosition());
        assertTrue(ob.isFound());
    }
    @Test
    void Not_in_sequence()
    {
        int[] array = {1};
        SearchResult ob = BinarySearch.search(2,array);
        assertEquals(-1,ob.getPosition());
        assertFalse(ob.isFound());
    }
    @Test
    void It_is_the_first_element()
    {
        int[] array = {1, 2, 3, 9, 24, 26, 30, 45, 50};
        SearchResult ob = BinarySearch.search(1,array);
        assertEquals(1,ob.getPosition());
        assertTrue(ob.isFound());
    }
    @Test
    void It_is_the_last_element()
    {
        int[] array = {1, 2, 3, 9, 24, 26, 30, 45, 50};
        SearchResult ob = BinarySearch.search(50,array);
        assertEquals(ob.getPosition(),array.length);
        assertTrue(ob.isFound());
    }
    @Test
    void It_is_the_middle_element()
    {
        int[] array = {1, 2, 3, 9, 24, 26, 30, 45, 50};
        SearchResult ob = BinarySearch.search(24,array);
        assertEquals(5,ob.getPosition());
        assertTrue(ob.isFound());
    }
    @Test
    void Not_in_sequence_more_than_one()
    {
        int[] array = {1, 2, 3, 9, 24, 26, 30, 45, 50};
        SearchResult ob = BinarySearch.search(5,array);
        assertEquals(-1,ob.getPosition());
        assertFalse(ob.isFound());
    }
    @Test
    void EmptyArray()
    {
        int[] array = {};
        SearchResult ob = BinarySearch.search(5,array);
        assertEquals(-1,ob.getPosition());
        assertFalse(ob.isFound());
    }

}
