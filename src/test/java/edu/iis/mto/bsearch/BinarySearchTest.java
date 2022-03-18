package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;


class BinarySearchTest {

    SearchResult result;
    int SEARCHED_VALUE;
    final int ARR_SIZE = 7;
    int[] testSeq = new int[ARR_SIZE];
    int targetVal;

    @BeforeEach
    void setUp() throws Exception {
        Random rand = new Random();
        targetVal = Math.abs(rand.nextInt(30));
        for(int i = 0; i < ARR_SIZE; i++){
            testSeq[i] = targetVal + i;
        }
    }

    @Test
    void test1() {
        SEARCHED_VALUE = 7;
        int[] testOneElementSeq = {SEARCHED_VALUE};
        result = BinarySearch.search(SEARCHED_VALUE, testOneElementSeq);
        assertTrue(result.isFound());
    }

    @Test
    void test2(){
        SEARCHED_VALUE = 9;
        int[] testOneElementSeq = {SEARCHED_VALUE+1};
        result = BinarySearch.search(SEARCHED_VALUE, testOneElementSeq);
        assertFalse(result.isFound());
    }

    @Test
    void test3(){
        SEARCHED_VALUE = testSeq[0];
        result = BinarySearch.search(SEARCHED_VALUE, testSeq);
        assertTrue(result.isFound());
    }

    @Test
    void test4(){
        SEARCHED_VALUE = testSeq[ARR_SIZE-1];
        result = BinarySearch.search(SEARCHED_VALUE, testSeq);
        assertTrue(result.isFound());
    }

    @Test
    void test5(){
        SEARCHED_VALUE = testSeq[ARR_SIZE/2];
        result = BinarySearch.search(SEARCHED_VALUE, testSeq);
        assertTrue(result.isFound());
    }

    @Test
    void test6(){
        final int SEARCHED_VALUE = targetVal-1;
        result = BinarySearch.search(SEARCHED_VALUE, testSeq);
        assertFalse(result.isFound());
    }

}
