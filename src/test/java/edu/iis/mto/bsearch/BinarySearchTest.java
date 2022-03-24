package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
/*///todo assert correct pos, add short array for test 1,2 + refactor test names*/

class BinarySearchTest {

    SearchResult result;
    int SEARCHED_VALUE;
    final int ARR_SIZE_ODD = 7;
    final int ARR_SIZE_EVEN = 10;
    int[] testSeqOdd = new int[ARR_SIZE_ODD];
    int[] testSeqEven = new int[ARR_SIZE_EVEN];
    int targetVal;

    @BeforeEach
    void setUp() throws Exception {
        Random rand = new Random();
        targetVal = Math.abs(rand.nextInt(30));
        for(int i = 0; i < ARR_SIZE_ODD; i++){
            testSeqOdd[i] = targetVal + i;
        }
        for(int i = 0; i < ARR_SIZE_EVEN; i++){
            testSeqEven[i] = targetVal + i;
        }
    }

    @Test
    void testPresentInOneElementArray() {
        SEARCHED_VALUE = 7;
        int[] testOneElementSeq = {SEARCHED_VALUE};
        result = BinarySearch.search(SEARCHED_VALUE, testOneElementSeq);
        assertTrue(result.isFound());
    }

    @Test
    void testNotPresentInOneElementArray(){
        SEARCHED_VALUE = 9;
        int[] testOneElementSeq = {SEARCHED_VALUE+1};
        result = BinarySearch.search(SEARCHED_VALUE, testOneElementSeq);
        assertFalse(result.isFound());
    }

    @Test
    void testFirstElementOddLenArray(){
        SEARCHED_VALUE = testSeqOdd[0];
        result = BinarySearch.search(SEARCHED_VALUE, testSeqOdd);
        assertTrue(result.isFound());
    }

    @Test
    void testLastElementOddLenArray(){
        SEARCHED_VALUE = testSeqOdd[ARR_SIZE_ODD -1];
        result = BinarySearch.search(SEARCHED_VALUE, testSeqOdd);
        assertTrue(result.isFound());
    }

    @Test
    void testMidElementOddLenArray(){
        SEARCHED_VALUE = testSeqOdd[ARR_SIZE_ODD /2];
        result = BinarySearch.search(SEARCHED_VALUE, testSeqOdd);
        assertTrue(result.isFound());
    }

    @Test
    void testNotPresentOddLenArray(){
        final int SEARCHED_VALUE = targetVal-1;
        result = BinarySearch.search(SEARCHED_VALUE, testSeqOdd);
        assertFalse(result.isFound());
    }


}
