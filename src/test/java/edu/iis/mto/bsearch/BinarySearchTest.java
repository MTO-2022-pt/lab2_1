package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void sizeOneInTable() {
        int[] sequence = {1};
        SearchResult searchResult = BinarySearch.search(1, sequence);
        if(!searchResult.isFound()) fail("SearchResult.isFound() was not set to true");
        if(searchResult.getPosition() != 0) fail("SearchResult.getPosition() was not set to 0");
    }

    @Test
    void sizeOneNotInTable() {
        int[] sequence = {1};
        SearchResult searchResult = BinarySearch.search(2, sequence);
        if(searchResult.isFound()) fail("SearchResult.isFound() was not set to false");
        if(searchResult.getPosition() != -1) fail("SearchResult.getPosition() was not set to -1");
    }

}
